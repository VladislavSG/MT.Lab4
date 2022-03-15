package Base;

public class Terminal extends Particle {
    public Terminal(final String name) {
        super(name);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Terminal) {
            return ((Terminal) obj).getText().equals(getText());
        } else {
            return false;
        }
    }
}
