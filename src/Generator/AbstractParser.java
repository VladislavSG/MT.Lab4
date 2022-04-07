package Generator;

import Base.Token;

import java.io.IOException;
import java.util.List;

public abstract class AbstractParser {
    private final Token EOF = new Token(null, -1);
    protected int pos = 0;
    protected RuleContext curContext;
    private final List<Token> tokens;

    public AbstractParser(final List<Token> tokens) {
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

    protected Token peek() throws IOException {
        return pos == tokens.size() ? EOF : tokens.get(pos);
    }

    protected void expected(int m) throws IOException {
        if (peek().getId() != m)
            throw new IOException("expected " + m + " at pos: " + pos);
        //curContext.children.add(peek());
        nexttoken();
    }

    protected Token nexttoken() throws IOException {
        return pos == tokens.size() ? EOF : tokens.get(pos++);
    }

}
