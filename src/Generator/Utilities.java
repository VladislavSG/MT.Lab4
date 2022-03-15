package Generator;

import Base.Action;
import Base.NotTerminal;
import Base.Particle;
import Base.Terminal;
import GrammarParser.GrammarLexer;
import GrammarParser.GrammarParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.function.Function;

public class Utilities {

    public static String bite(String s) {
        if (s.length() < 2) {
            return "";
        } else {
            return s.substring(1, s.length() - 1);
        }
    }

    public static Particle convert(final ParseTree tree) {
        if (tree instanceof TerminalNode) {
            String s = bite(tree.getText());
            if (((TerminalNode) tree).getSymbol().getType() == GrammarLexer.Action) {
                return new Action(s);
            }
            if (((TerminalNode) tree).getSymbol().getType() == GrammarLexer.Literal) {
                return new Terminal(s);
            }
        }
        if (tree instanceof GrammarParser.LeftContext leftContext) {
            return new NotTerminal(leftContext.NTerminal().getText());
        }
        throw new IllegalArgumentException();
    }
}
