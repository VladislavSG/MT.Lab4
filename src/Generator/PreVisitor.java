package Generator;

import Base.*;
import GrammarParser.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static Generator.Utilities.bite;

public class PreVisitor {
    public final HashMap<NotTerminal, Set<Integer>> first = new HashMap<>();
    public final List<Rule> lines = new ArrayList<>();
    public final Map<Literal, Integer> literals = new LinkedHashMap<>();
    public static final Integer EPS = -1;

    private class Initializer extends GrammarBaseVisitor<HashMap<NotTerminal, Set<Integer>>> {

        public Initializer(final ParseTree tree) {
            visit(tree);
            boolean chg = true;
            while (chg) {
                chg = false;
                for (final Rule r : lines) {
                    final Set<Integer> x = first.get(r.left);
                    for (final Term term : r.alts) {
                        final Set<Integer> y = calc_first(term.getAlternative());
                        chg |= !x.containsAll(y);
                        x.addAll(y);
                    }
                }
            }
        }

        public Particle convert(final ParseTree tree) {
            if (tree instanceof TerminalNode) {
                String s = bite(tree.getText());
                if (((TerminalNode) tree).getSymbol().getType() == GrammarLexer.Action) {
                    return new Action(s);
                }
                if (((TerminalNode) tree).getSymbol().getType() == GrammarLexer.Literal) {
                    Literal l = new Literal(s);
                    literals.putIfAbsent(l, literals.size());
                    return l;
                }
            }
            if (tree instanceof GrammarParser.LeftContext leftContext) {
                return new NotTerminal(leftContext);
            }
            throw new IllegalArgumentException();
        }

        @Override
        public HashMap<NotTerminal, Set<Integer>> visitLine(final GrammarParser.LineContext ctx) {
            NotTerminal left = new NotTerminal(ctx.left());
            first.computeIfAbsent(left, k -> new HashSet<>());
            List<Term> alts = new ArrayList<>();
            for (final GrammarParser.TermContext t : ctx.right().term()) {
                Stream<ParseTree> streamParticles = (t.children == null) ? Stream.empty() : t.children.stream();
                List<Particle> alternative = streamParticles
                                                .map(this::convert)
                                                .toList();
                alts.add(new Term(alternative));
            }
            String local = ctx.Args() == null ? null : bite(ctx.Args().getText());
            lines.add(new Rule(left, alts, local));
            return super.visitLine(ctx);
        }

        @Override
        protected HashMap<NotTerminal, Set<Integer>> defaultResult() {
            return first;
        }
    }

    public Set<Integer> calc_first(List<Particle> x) {
        x = x.stream().filter(Predicate.not(Action.class::isInstance)).toList();
        return calc_first_b(x);
    }

    private Set<Integer> calc_first_b(List<Particle> x) {
        if (x.isEmpty()) {
            return Collections.singleton(EPS);
        } else {
            final Particle p = x.get(0);
            final String name = p.getText();
            assert (name.length() > 0);
            if (p instanceof Literal) {
                return Collections.singleton(literals.get(p));
            } else {
                Set<Integer> next = first.get((NotTerminal) p);
                if (next.remove(EPS)) {
                    next.addAll(calc_first_b(x.subList(1, x.size())));
                }
                return next;
            }
        }
    }

    public PreVisitor(final ParseTree tree) {
        new Initializer(tree);
    }
}
