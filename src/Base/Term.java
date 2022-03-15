package Base;

import java.util.List;

public class Term {
    private final List<Particle> alternative;

    public Term(final List<Particle> alternative) {
        this.alternative = alternative;
    }

    public List<Particle> getAlternative() {
        return alternative;
    }
}
