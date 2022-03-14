package Base;

import java.util.List;

public class Rule {
    public final NotTerminal left;
    public final List<Particle> right;

    public Rule(final NotTerminal left, final List<Particle> right) {
        this.left = left;
        this.right = right;
    }
}
