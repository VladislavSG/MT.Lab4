package Base;

public class NotTerminal extends Particle {
    public NotTerminal(final String name) {
        super(name);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof NotTerminal) {
            return ((NotTerminal) obj).getName().equals(getName());
        } else {
            return false;
        }
    }
}
