package Generator;

import Base.*;
import GrammarParser.GrammarLexer;
import GrammarParser.GrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Generator {
    private static final Pattern scope_t1 = Pattern.compile("\\$([a-z]\\w*)::(\\w+)");
    private static final Pattern scope_t2 = Pattern.compile("\\$(\\d+)::(\\w+)");
    private static final Pattern scope_t3 = Pattern.compile("\\$(\\w+)");
    private final PreVisitor preVisitor;
    StringBuilder s;

    public Generator(final ParseTree tree) {
        if (tree instanceof GrammarParser.SContext sContext) {
            preVisitor = new PreVisitor(tree);
            gen(sContext);
        } else {
            throw new IllegalArgumentException("not S nterm");
        }
    }

    private static String ctxName(NotTerminal nt) {
        return nt.getText() + "Context";
    }

    private static String process(String action, Term term) {
        String x1 = scope_t1.matcher(action).replaceAll("(($1Context)getContext($1Context.class)).$2");
        String x2 = scope_t2.matcher(x1).replaceAll(matchResult -> {
            int pos = Integer.parseInt(matchResult.group(1));
            String className = ctxName((NotTerminal) term
                    .getAlternative()
                    .stream()
                    .filter(p -> (p instanceof NotTerminal))
                    .skip(pos)
                    .findFirst()
                    .orElseThrow());
            return "((" + className + ")ctx.children.get($1)).$2";
        });
        return scope_t3.matcher(x2).replaceAll("ctx.$1");
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

    private void gen(final GrammarParser.SContext ctx) {
        String name = ctx.name().Name().getText();
        s = new StringBuilder("import java.io.IOException; import Generator.RuleContext; public class ")
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

    private void genContexts(Rule r) {
        String name = ctxName(r.left);
        s.append("public class ")
                .append(name)
                .append(" extends RuleContext { ");
        if (r.local != null) {
            s.append(r.local.replaceAll(",", ";")).append(";");
        }
        s.append("public ")
                .append(name)
                .append("() { super(curContext); curContext = this; } } ");
    }

    private void genBody() {
        for (final Rule r : preVisitor.lines) {
            genContexts(r);
            genRule(r);
        }
    }

    private void genRule(Rule r) {
        s.append("public ")
                .append(ctxName(r.left)).append(" ")
                .append(r.left.getText())
                .append("(");
        if (r.left.getArguments() != null) {
            s.append(r.left.getArguments());
        }
        String ctxName = ctxName(r.left);
        s.append(") throws IOException { ")
                .append(ctxName)
                .append(" ctx = new ").append(ctxName).append("() ; switch(peek()) {");
        for (Term t : r.alts) {
            for (int c : preVisitor.calc_first(t.getAlternative())) {
                if (c == -1) {
                    s.append("default: ");
                } else {
                    s.append("case(").append(c).append("): ");
                }
            }
            s.append(" { ");
            for (Particle p : t.getAlternative()) {
                if (p instanceof Literal literal) {
                    s.append("expected(").append(preVisitor.literals.get(literal)).append("); ");
                } else if (p instanceof NotTerminal nt) {
                    s.append(nt.getText()).append("(");
                    String args = nt.getArguments();
                    if (args != null) {
                        s.append(process(args, t));
                    }
                    s.append("); ");
                } else {
                    s.append(process(p.getText(), t));
                }
            }
            s.append("break; } ");
        }
        s.append("} exitRule(ctx); return ctx; }");
    }
}
