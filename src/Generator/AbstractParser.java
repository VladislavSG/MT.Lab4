package Generator;

import java.io.IOException;

public abstract class AbstractParser {
    protected final String src;
    protected int pos = 0;
    private int curToken = -1;

    public AbstractParser(final String src) {
        this.src = src;
    }

    protected int peek() throws IOException {
        if (curToken == -1) {
            curToken = nexttoken();
        }
        return pos == src.length() ? 0 : nexttoken();
    }

    protected void expected(int m) throws IOException {
        if (peek() != m)
            throw new IOException("expected " + m + " at pos: " + pos);
        nexttoken();
    }

    protected boolean test(String t) {
        return src.startsWith(t, pos);
    }

    protected abstract int nexttoken() throws IOException;

    protected int nexttoken(String[] lexems) throws IOException {
        for(int i = 0; i < lexems.length; ++i) {
            if (test(lexems[i])) {
                pos += lexems[i].length();
                int prev = curToken;
                curToken = i;
                return prev;
            }
        }
        throw new IOException("unknown token");
    }
}
