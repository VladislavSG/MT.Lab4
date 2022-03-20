package Generator;

import java.io.IOException;

public abstract class AbstractParser {
    protected final String src;
    protected int pos = 0;
    private int curToken = -2;
    protected RuleContext curContext;

    protected void exitRule(final RuleContext ctx) {
        curContext = curContext.parent;
        if (curContext != null) {
            curContext.children.add(ctx);
        }
    }

    public AbstractParser(final String src) {
        this.src = src;
    }

    protected RuleContext getContext(Class<?> token) {
        return getContext(token, 0);
    }

    protected RuleContext getContext(Class<?> token, int n) {
        for (RuleContext x = curContext; x != null; x = x.parent) {
            if (token.isInstance(x)) {
                if (n == 0) {
                    return x;
                } else {
                    n -= 1;
                }
            }
        }
        return null;
    }

    protected int peek() throws IOException {
        if (curToken == -2) {
            nexttoken();
        }
        return curToken;
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
        if (curToken == -1) {
            return -1;
        }
        for(int i = 0; i < lexems.length; ++i) {
            if (test(lexems[i])) {
                pos += lexems[i].length();
                int prev = curToken;
                curToken = i;
                return prev;
            }
        }
        curToken = -1;
        return curToken;
    }
}
