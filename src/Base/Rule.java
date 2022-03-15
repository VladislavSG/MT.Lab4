package Base;

import java.util.List;

public class Rule {
    public final NotTerminal left;
    public final List<Term> alts;
    public final String local;

    public Rule(final NotTerminal left, final List<Term> alts, String local) {
        this.left = left;
        this.alts = alts;
        this.local = local;
    }
}
