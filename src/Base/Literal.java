package Base;

public class Literal extends Particle {
    public Literal(final String name) {
        super(name);
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
