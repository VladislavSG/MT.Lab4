package Generator;

import Base.NotTerminal;
import GrammarParser.GrammarBaseVisitor;
import GrammarParser.GrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
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
    private final HashMap<NotTerminal, Set<Character>> first;

    public Generator(final ParseTree tree) {
        first = FirstSetCreate.create(tree);
    }

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
                    HashMap<NotTerminal, Set<Character>> firstSet = FirstSetCreate.create(tree);
                    Generator visitor = new Generator(tree);
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
            .append(" extends Generator.AbstractParser { public ")
            .append(name)
            .append("(String src) { super(src); } ");
        ctx.body().accept(this);
        s.append('}');
        return defaultResult();
    }

    @Override
    public Void visitLine(final GrammarParser.LineContext ctx) {
        s.append("public Generator.Node ");
        ctx.left().accept(this);
        s.append(" throws IOException { ");
        ctx.right().accept(this);
        s.append(" } ");
        return defaultResult();
    }

    @Override
    public Void visitRight(final GrammarParser.RightContext ctx) {
        s.append("Generator.Node node = new Generator.Node(); switch(peek()) {");
        for (ParseTree c : ctx.children) {
            if (c instanceof GrammarParser.TermContext term) {
                char f = 0; //first.get(term);
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
        String name = "rule" + ctx.NTerminal().getText().toUpperCase();
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
