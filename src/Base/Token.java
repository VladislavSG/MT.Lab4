package Base;

public class Token extends Particle {
    private final int id;

    public Token(final String text, final int id) {
        super(text);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
