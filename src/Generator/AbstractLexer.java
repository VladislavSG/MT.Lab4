package Generator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLexer {
    private final String src;
    private int pos = 0;

    public AbstractLexer(final String src) {
        this.src = src;
    }

    private boolean test(String t) {
        return src.startsWith(t, pos);
    }

    public List<Integer> tokenize() throws IOException {
        List<Integer> tokens = new ArrayList<>();
        while (pos != src.length()) {
            tokens.add(nexttoken());
        }
        return tokens;
    }

    protected abstract int nexttoken() throws IOException;

    protected int nexttoken(String[] lexems) throws IOException {
        for (int i = 0; i < lexems.length; ++i) {
            if (test(lexems[i])) {
                pos += lexems[i].length();
                return i;
            }
        }
        throw new IOException("can't recognize next token. pos = " + pos);
    }
}
