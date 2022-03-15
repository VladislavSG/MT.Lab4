package Base;

public class Lexem extends Particle {
    private final String value;
    private final int k;

    public Lexem(final String name, final String value, int k) {
        super(name);
        this.value = value;
        this.k = k;
    }

    public int getK() {
        return k;
    }

    public String getValue() {
        return value;
    }
}
