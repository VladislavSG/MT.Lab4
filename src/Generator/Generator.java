package Generator;

import Base.*;
import GrammarParser.GrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import GrammarParser.*;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Generator {
    StringBuilder s;
    private final PreVisitor preVisitor;

    public Generator(final ParseTree tree) {
        if (tree instanceof GrammarParser.SContext sContext) {
            preVisitor = new PreVisitor(tree);
            gen(sContext);
        } else {
            throw new IllegalArgumentException("not S nterm");
        }
    }

    private void gen(final GrammarParser.SContext ctx) {
        String name = ctx.name().Name().getText();
        s = new StringBuilder("import java.io.IOException; public class ")
                .append(name)
                .append(" extends Generator.AbstractParser { ");
        s.append("private static String[] lexems = new String[] {");
        s.append(preVisitor.literals
                .keySet()
                .stream()
                .map(s -> "\"" + s.getText() + "\"")
                .collect(Collectors.joining(", ")));
        s.append("}; public ")
                .append(name)
                .append("(String src) { super(src); } ")
                .append("protected int nexttoken() throws IOException { return super.nexttoken(lexems); } ");
        genBody();
        s.append('}');
    }

    private void genBody() {
        for (final Rule r : preVisitor.lines) {
            genRule(r);
        }
    }

    private void genRule(Rule r) {
        s.append("public void ")
            .append(r.left.getText())
            .append("(");
        if (r.left.getArguments() != null) {
            s.append(r.left.getArguments());
        }
        s.append(") throws IOException { switch(peek()) {");
        boolean hasEps = false;
        for (Term t : r.alts) {
            boolean hasNotEps = false;
            for (int c : preVisitor.calc_first(t.getAlternative())) {
                if (c == 0) {
                    hasEps = true;
                } else {
                    hasNotEps = true;
                    s.append("case(").append(c).append("): ");
                }
            }
            if (!hasNotEps) continue;
            s.append(" { ");
            for (Particle p : t.getAlternative()) {
                if (p instanceof Literal literal) {
                    s.append("expected(").append(preVisitor.literals.get(literal)).append("); ");
                } else if (p instanceof NotTerminal nt) {
                    s.append(nt.getText()).append("(");
                    String args = nt.getArguments();
                    if (args != null) {
                        s.append(args);
                    }
                    s.append("); ");
                } else {
                    s.append(p.getText());
                }
            }
            s.append("break; } ");
        }
        if (!hasEps) {
            s.append("default: throw new IOException(); ");
        }
        s.append("} }");
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
                    Generator visitor = new Generator(tree);
                    writer.write(visitor.s.toString());
                }
            } catch (IOException e) {
                System.err.println("error with file " + p);
            }
        }
    }
}
