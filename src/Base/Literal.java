package Base;

public class Literal extends Terminal {
    public Literal(final String name) {
        super(name, 0);
    }

    public Literal(final String name, final int id) {
        super(name, id);
    }

    @Override
    public Token test(final String s) {
        return s.startsWith(getText()) ? new Token(getText(), getId()) : null;
    }

    @Override
    public String textConstructor() {
        return "new Literal(\"" + getText() + "\", " + getId() + ")";
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Literal) {
            return ((Literal) obj).getText().equals(getText());
        } else {
            return false;
        }
    }
}
