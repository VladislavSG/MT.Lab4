package Base;

public class Action extends Particle {
    public Action(final String name) {
        super(name);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Action) {
            return ((Action) obj).getText().equals(getText());
        } else {
            return false;
        }
    }
}
