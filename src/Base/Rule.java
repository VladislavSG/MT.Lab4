package Base;

import java.util.List;

public class Rule {
    public final NotTerminal left;
    public final List<Term> alts;

    public Rule(final NotTerminal left, final List<Term> alts) {
        this.left = left;
        this.alts = alts;
    }
}
