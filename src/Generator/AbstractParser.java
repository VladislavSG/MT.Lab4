package Generator;

import java.io.IOException;

public class AbstractParser {
    final String src;
    int pos = 0;

    public AbstractParser(final String src) {
        this.src = src;
    }

    char peek() {
        return pos == src.length() ? 0 : src.charAt(pos);
    }

    void expect(String m) throws IOException {
        int startPos = pos;
        for(char c : m.toCharArray()) {
            if (peek() != c)
                throw new IOException("expected " + m + " at pos: " + startPos);
            pos += 1;
        }
    }
}
