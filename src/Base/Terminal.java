package Base;

public abstract class Terminal extends Particle {
    private int id;

    public Terminal(final String name, final int id) {
        super(name);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public abstract Token test(String s);

    public abstract String textConstructor();
}
