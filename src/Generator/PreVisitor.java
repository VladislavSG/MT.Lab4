package Generator;

import Base.*;
import GrammarParser.GrammarBaseVisitor;
import GrammarParser.GrammarParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import GrammarParser.GrammarLexer;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PreVisitor {
    public final HashMap<NotTerminal, Set<Character>> first = new HashMap<>();
    public final List<Rule> lines = new ArrayList<>();
    public static final Character EPS = 0;

    private class Initializer extends GrammarBaseVisitor<HashMap<NotTerminal, Set<Character>>> {
        public Initializer(final ParseTree tree) {
            visit(tree);
            boolean chg = true;
            while (chg) {
                chg = false;
                for (final Rule r : lines) {
                    final Set<Character> x = first.get(r.left);
                    for (final Term term : r.alts) {
                        final Set<Character> y = calc_first(term.getAlternative());
                        chg |= !x.containsAll(y);
                        x.addAll(y);
                    }
                }
            }
        }

        @Override
        public HashMap<NotTerminal, Set<Character>> visitLine(final GrammarParser.LineContext ctx) {
            NotTerminal left = new NotTerminal(ctx.left());
            first.computeIfAbsent(left, k -> new HashSet<>());
            List<Term> alts = new ArrayList<>();
            for (final GrammarParser.TermContext t : ctx.right().term()) {
                Stream<ParseTree> streamParticles = (t.children == null) ? Stream.empty() : t.children.stream();
                List<Particle> alternative = streamParticles
                                                .map(Utilities::convert)
                                                .toList();
                alts.add(new Term(alternative));
            }
            lines.add(new Rule(left, alts));
            return super.visitLine(ctx);
        }

        @Override
        protected HashMap<NotTerminal, Set<Character>> defaultResult() {
            return first;
        }
    }

    public Set<Character> calc_first(List<Particle> x) {
        x = x.stream().filter(Predicate.not(Action.class::isInstance)).toList();
        return calc_first_b(x);
    }

    private Set<Character> calc_first_b(List<Particle> x) {
        if (x.isEmpty()) {
            return Collections.singleton(EPS);
        } else {
            final Particle p = x.get(0);
            final String name = p.getText();
            assert (name.length() > 0);
            if (p instanceof Terminal) {
                return Collections.singleton(name.charAt(0));
            } else {
                Set<Character> next = first.get((NotTerminal) p);
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
