import GrammarParser.GrammarBaseVisitor;
import GrammarParser.GrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import GrammarParser.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Generator extends GrammarBaseVisitor<Void> {
    StringBuilder s;
    HashMap<String, HashMap<Integer, List<Character>>> first = new HashMap<>();

    private static String bite(String s) {
        if (s.length() < 2) {
            return "";
        } else {
            return s.substring(1, s.length() - 1);
        }
    }

    public static void main(String[] args) {
        for (final String p : args) {
            try {
                CharStream cs = fromFileName("test_grammars/" + p);  //load the file
                GrammarLexer lexer = new GrammarLexer(cs);  //instantiate a lexer
                CommonTokenStream tokens = new CommonTokenStream(lexer); //scan stream for tokens
                GrammarParser parser = new GrammarParser(tokens);  //parse the tokens

                ParseTree tree = parser.s(); // parse the content and get the tree
                Path path = Path.of("test_out");
                Files.createDirectories(path);
                String name = p.substring(0, p.indexOf('.'));
                try (BufferedWriter writer = Files.newBufferedWriter(path.resolve(name + ".java"))) {
                    Generator visitor = new Generator();
                    visitor.visit(tree);
                    writer.write(visitor.s.toString());
                }
            } catch (IOException e) {
                System.err.println("error with file " + p);
            }
        }
    }

    @Override
    public Void visitS(final GrammarParser.SContext ctx) {
        String name = ctx.name().Name().getText();
        s = new StringBuilder("import java.io.IOException; public class ")
            .append(name)
            .append(" extends AbstractParser { public ")
            .append(name)
            .append("(String src) { super(src); } ");
        ctx.body().accept(this);
        s.append('}');
        return defaultResult();
    }

    @Override
    public Void visitLine(final GrammarParser.LineContext ctx) {
        s.append("public Node ");
        ctx.left().accept(this);
        s.append(" throws IOException { ");
        ctx.right().accept(this);
        s.append(" } ");
        return defaultResult();
    }

    public Set<Character> constructFirst(ParseTree term) {
        int n = term.getChildCount();
        Set<Character> res = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            res.remove((char)0);
            ParseTree c = term.getChild(i);
            res.addAll(first(c));
            if (!res.contains((char)0)) {
                return res;
            }
        }
        if (term instanceof TerminalNode node &&
                node.getSymbol().getType() == GrammarParser.Literal) {
            String text = bite(node.getText());
            return new HashSet<>(text.isEmpty() ? 0 : text.charAt(0));
        } else {
            return new HashSet<>((char)0);
        }
    }

    @Override
    public Void visitRight(final GrammarParser.RightContext ctx) {
        s.append("Node node = new Node(); switch(peek()) {");
        for (ParseTree c : ctx.children) {
            if (c instanceof GrammarParser.TermContext term) {
                char f = first(term);
                if (f != 0) {
                    s.append("case('")
                            .append(f)
                            .append("')");
                } else {
                    s.append("default");
                }
                s.append(": {");
                term.accept(this);
                s.append("break; }");
            }
        }
        s.append("} return node;");
        return defaultResult();
    }

    @Override
    public Void visitTerm(final GrammarParser.TermContext ctx) {
        if (ctx.children != null) {
            for (ParseTree c : ctx.children) {
                if (c instanceof TerminalNode terminal) {
                    String a = terminal.getText();
                    if (terminal.getSymbol().getType() == GrammarParser.Action) {
                        s.append(bite(a));
                    } else {
                        s.append("expect(\"")
                                .append(bite(a))
                                .append("\");");
                    }
                } else {
                    s.append("node.add(");
                    c.accept(this);
                    s.append(");");
                }
            }
        }
        return defaultResult();
    }

    //    @Override
//    public Void visitBody(final GrammarParser.BodyContext ctx) {
//        for (ParseTree l : ctx.children) {
//            assert(l instanceof GrammarParser.LineContext);
//            GrammarParser.LineContext ruleCtx = (GrammarParser.LineContext) l;
//            rules.put(ruleCtx.left().RuleName().getText(), );
//        }
//        return super.visitBody(ctx);
//    }

    @Override
    public Void visitLeft(final GrammarParser.LeftContext ctx) {
        String name = "rule" + ctx.RuleName().getText().toUpperCase();
        s.append(name).append('(');
        TerminalNode args = ctx.Args();
        if (args != null) {
            String a = args.getText();
            s.append(a, 1, a.length()-1);
        }
        s.append(")");
        return defaultResult();
    }
}
