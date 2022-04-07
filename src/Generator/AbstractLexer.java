package Generator;

import Base.Terminal;
import Base.Token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLexer {
    private final String src;
    private int pos = 0;

    public AbstractLexer(final String src) {
        this.src = src.replaceAll(" ", "");
    }

    private boolean test(String t) {
        return src.startsWith(t, pos);
    }

    public List<Token> tokenize() throws IOException {
        List<Token> tokens = new ArrayList<>();
        while (pos != src.length()) {
            tokens.add(nexttoken());
        }
        return tokens;
    }

    protected abstract Token nexttoken() throws IOException;

    protected Token nexttoken(Terminal[] lexems) throws IOException {
        for (final Terminal lexem : lexems) {
            Token t = lexem.test(src.substring(pos));
            if (t != null) {
                pos += t.getText().length();
                return t;
            }
        }
        throw new IOException("can't recognize next token. pos = " + pos);
    }
}
