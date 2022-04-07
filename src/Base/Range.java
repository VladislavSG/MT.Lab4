package Base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Range extends Terminal {
    final Pattern p;

    public Range(final String name) {
        this(name, 0);
    }

    public Range(final String name, int id) {
        super(name, id);
        this.p = Pattern.compile(name);
    }

    @Override
    public Token test(final String s) {
        final Matcher m = p.matcher(s);
        return m.lookingAt() ? new Token(s.substring(0, m.end()), getId()) : null;
    }

    @Override
    public String textConstructor() {
        return "new Range(\"" + getText() + "\", " + getId() + ")";
    }
}
