package Base;

public class Lexem extends Particle {
    private final Terminal value;
    private final int k;

    public Lexem(final String name, final Terminal value, int k) {
        super(name);
        this.value = value;
        this.k = k;
    }

    public int getK() {
        return k;
    }

    public Terminal getValue() {
        return value;
    }
}
