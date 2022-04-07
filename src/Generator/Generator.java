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
    private final String name;
    StringBuilder p;
    StringBuilder l;

    public Generator(final ParseTree tree) {
        if (tree instanceof GrammarParser.SContext sContext) {
            preVisitor = new PreVisitor(tree);
            name = sContext.name().Name().getText();
            genParser(sContext);
            genLexer();
        } else {
            throw new IllegalArgumentException("not S nterm");
        }
    }

    private static String process(String action, Term term) {
        String x1 = scope_t1.matcher(action).replaceAll("(($1Context)getContext($1Context.class)).$2");
        String x2 = scope_t2.matcher(x1).replaceAll(matchResult -> {
            int pos = Integer.parseInt(matchResult.group(1));
            String className = ctxName(term
                    .getAlternative()
                    .stream()
                    .filter(p -> !(p instanceof Action))
                    .skip(pos)
                    .findFirst()
                    .orElseThrow());
            return "((" + className + ")ctx.children.get($1)).$2";
        });
        return scope_t3.matcher(x2).replaceAll("ctx.$1");
    }

    private static String ctxName(Particle p) {
        if (p instanceof Terminal) {
            return "Token";
        } else {
            return p.getText() + "Context";
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
                try (BufferedWriter writerP = Files.newBufferedWriter(path.resolve(name + "Parser.java"));
                     BufferedWriter writerL = Files.newBufferedWriter(path.resolve(name + "Lexer.java"))) {
                    Generator visitor = new Generator(tree);
                    writerP.write(visitor.p.toString());
                    writerL.write(visitor.l.toString());
                }
            } catch (IOException e) {
                System.err.println("error with file " + p);
            }
        }
    }

    private void genLexer() {
        String name = this.name + "Lexer";
        l = new StringBuilder("import java.io.IOException;" +
                "import java.util.List;" +
                "import Generator.RuleContext;" +
                "import Base.*;" +
                "public class ")
                .append(name)
                .append(" extends Generator.AbstractLexer { ");
        l.append("private static Terminal[] lexems = new Terminal[] {");
        l.append(preVisitor.literals
                .keySet()
                .stream()
                .map(Terminal::textConstructor)
                .collect(Collectors.joining(", ")));
        l.append("}; public ")
                .append(name)
                .append("(String src) { super(src); } ")
                .append("protected Token nexttoken() throws IOException { return super.nexttoken(lexems); } ");
        l.append('}');
    }

    private void genParser(final GrammarParser.SContext ctx) {
        String name = this.name + "Parser";
        p = new StringBuilder("import java.io.IOException;" +
                "import java.util.List;" +
                "import Generator.RuleContext;" +
                "import Base.*;" +
                "public class ")
                .append(name)
                .append(" extends Generator.AbstractParser { ");
        p.append("public ")
                .append(name)
                .append("(List<Token> tokens) { super(tokens); } ");
        genBody();
        p.append('}');
    }

    private void genContexts(Rule r) {
        String name = ctxName(r.left);
        p.append("public class ")
                .append(name)
                .append(" extends RuleContext { ");
        if (r.local != null) {
            p.append(r.local.replaceAll(",", ";")).append(";");
        }
        p.append("public ")
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
        p.append("public ")
                .append(ctxName(r.left)).append(" ")
                .append(r.left.getText())
                .append("(");
        if (r.left.getArguments() != null) {
            p.append(r.left.getArguments());
        }
        String ctxName = ctxName(r.left);
        p.append(") throws IOException { ")
                .append(ctxName)
                .append(" ctx = new ").append(ctxName).append("() ; switch(peek().getId()) {");
        for (Term t : r.alts) {
            for (int c : preVisitor.calc_first(t.getAlternative())) {
                if (c == -1) {
                    p.append("default: ");
                } else {
                    p.append("case(").append(c).append("): ");
                }
            }
            p.append(" { ");
            for (Particle p : t.getAlternative()) {
                if (p instanceof Terminal terminal) {
                    this.p.append("expected(").append(preVisitor.literals.get(terminal)).append("); ");
                } else if (p instanceof NotTerminal nt) {
                    this.p.append(nt.getText()).append("(");
                    String args = nt.getArguments();
                    if (args != null) {
                        this.p.append(process(args, t));
                    }
                    this.p.append("); ");
                } else {
                    this.p.append(process(p.getText(), t));
                }
            }
            p.append("break; } ");
        }
        p.append("} exitRule(ctx); return ctx; }");
    }
}
