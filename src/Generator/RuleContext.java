package Generator;

import java.util.ArrayList;
import java.util.List;

public class RuleContext {
    public RuleContext parent;
    public List<RuleContext> children = new ArrayList<>();

    public RuleContext(final RuleContext parent) {
        this.parent = parent;
    }
}
