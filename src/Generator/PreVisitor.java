package Generator;

import Base.*;
import GrammarParser.GrammarBaseVisitor;
import GrammarParser.GrammarLexer;
import GrammarParser.GrammarParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static Generator.Utilities.bite;

public class PreVisitor {
    public static final Integer EPS = -1;
    public final HashMap<NotTerminal, Set<Integer>> first = new HashMap<>();
    public final List<Rule> lines = new ArrayList<>();
    public final Map<Terminal, Integer> literals = new LinkedHashMap<>();
    public final Map<String, Terminal> lexems = new HashMap<>();

    public PreVisitor(final ParseTree tree) {
        new Initializer(tree);
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
            if (p instanceof Terminal) {
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

        private Terminal update(Terminal t) {
            int newId = literals.size();
            Integer oldId = literals.putIfAbsent(t, newId);
            t.setId(oldId == null ? newId : oldId);
            return t;
        }

        private Terminal rangeConstruct(String text) {
            return update(new Range(bite(text, 2, 1)));
        }

        private Terminal literalConstruct(String text) {
            return update(new Literal(bite(text)));
        }

        public Particle convert(final ParseTree tree) {
            if (tree instanceof TerminalNode terminalNode) {
                String text = tree.getText();
                int type = terminalNode.getSymbol().getType();
                switch (type) {
                    case (GrammarLexer.Action): {
                        return new Action(bite(text));
                    }
                    case (GrammarLexer.Literal): {
                        return literalConstruct(text);
                    }
                    case (GrammarLexer.Range): {
                        return rangeConstruct(text);
                    }
                    case (GrammarLexer.Name): {
                        Terminal res = lexems.get(text);
                        if (res == null) {
                            throw new RuntimeException("unknown lexem");
                        }
                        return res;
                    }
                    default: {
                        throw new IllegalArgumentException();
                    }
                }
            }
            if (tree instanceof GrammarParser.LeftContext leftContext) {
                return new NotTerminal(leftContext);
            }
            throw new IllegalArgumentException();
        }

        @Override
        public HashMap<NotTerminal, Set<Integer>> visitPravilo(final GrammarParser.PraviloContext ctx) {
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
            return super.visitPravilo(ctx);
        }

        @Override
        public HashMap<NotTerminal, Set<Integer>> visitLexem(final GrammarParser.LexemContext ctx) {
            TerminalNode literal = ctx.Literal();
            Terminal t;
            if (literal == null) {
                t = rangeConstruct(ctx.Range().getText());
            } else {
                t = literalConstruct(ctx.Literal().getText());
            }
            lexems.put(ctx.Name().getText(), t);
            return super.visitLexem(ctx);
        }

        @Override
        protected HashMap<NotTerminal, Set<Integer>> defaultResult() {
            return first;
        }
    }
}
