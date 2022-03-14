package Generator;

import Base.NotTerminal;
import Base.Particle;
import Base.Rule;
import Base.Terminal;
import GrammarParser.GrammarBaseVisitor;
import GrammarParser.GrammarParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import GrammarParser.GrammarLexer;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Generator.Utilities.bite;

public class FirstSetCreate {
    private static class Initializer extends GrammarBaseVisitor<HashMap<NotTerminal, Set<Character>>> {
        private final HashMap<NotTerminal, Set<Character>> first = new HashMap<>();
        List<Rule> lines = new ArrayList<>();
        public final Character EPS = 0;

        @Override
        public HashMap<NotTerminal, Set<Character>> visitTerminal(final TerminalNode node) {
            if (node.getSymbol().getType() == GrammarLexer.NTerminal) {
                first.computeIfAbsent(new NotTerminal(node.getText()), k -> new HashSet<>());
            }
            return super.visitTerminal(node);
        }

        @Override
        public HashMap<NotTerminal, Set<Character>> visitLine(final GrammarParser.LineContext ctx) {
            NotTerminal left = new NotTerminal(ctx.left().NTerminal().getText());
            for (final GrammarParser.TermContext t : ctx.right().term()) {
                Stream<ParseTree> streamParticles = (t.children == null) ? Stream.empty() : t.children.stream();
                lines.add(new Rule(
                        left,
                        streamParticles
                                .filter(c -> !(c instanceof TerminalNode) ||
                                        ((TerminalNode) c).getSymbol().getType() != GrammarParser.Action)
                                .map(c -> c instanceof TerminalNode
                                          ? new Terminal(bite(c.getText()))
                                          : new NotTerminal(((GrammarParser.LeftContext)c).NTerminal().getText()))
                                .collect(Collectors.toList())));
            }
            return super.visitLine(ctx);
        }

        @Override
        protected HashMap<NotTerminal, Set<Character>> defaultResult() {
            return first;
        }

        private Set<Character> calc_first(final List<Particle> x) {
            if (x.isEmpty()) {
                return Collections.singleton(EPS);
            } else {
                final Particle p = x.get(0);
                final String name = p.getName();
                assert (name.length() > 0);
                if (p instanceof Terminal) {
                    return Collections.singleton(name.charAt(0));
                } else {
                    Set<Character> next = first.get((NotTerminal) p);
                    if (next.remove(EPS)) {
                        next.addAll(calc_first(x.subList(1, x.size())));
                    }
                    return next;
                }
            }
        }
    }

    static public HashMap<NotTerminal, Set<Character>> create(final ParseTree tree) {
        Initializer visitor = new Initializer();
        HashMap<NotTerminal, Set<Character>> first = visitor.visit(tree);
        boolean chg = true;
        while (chg) {
            chg = false;
            for (final Rule r : visitor.lines) {
                final Set<Character> x = first.get(r.left);
                final Set<Character> y = visitor.calc_first(r.right);
                chg |= !x.containsAll(y);
                x.addAll(y);
            }
        }
        return first;
    }
}
