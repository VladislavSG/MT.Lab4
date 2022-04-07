package Base;

public class Token {
    private final String text;
    private final int id;

    public Token(final String text, final int id) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }
}
