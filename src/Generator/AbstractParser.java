package Generator;

import java.io.IOException;
import java.util.List;

public abstract class AbstractParser {
    protected int pos = 0;
    protected RuleContext curContext;
    private final List<Integer> tokens;

    public AbstractParser(final List<Integer> tokens) {
        this.tokens = tokens;
    }

    protected void exitRule(final RuleContext ctx) {
        curContext = curContext.parent;
        if (curContext != null) {
            curContext.children.add(ctx);
        }
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
        return pos == tokens.size() ? -1 : tokens.get(pos);
    }

    protected void expected(int m) throws IOException {
        if (peek() != m)
            throw new IOException("expected " + m + " at pos: " + pos);
        nexttoken();
    }

    protected int nexttoken() throws IOException {
        return pos == tokens.size() ? -1 : tokens.get(pos++);
    }

}
