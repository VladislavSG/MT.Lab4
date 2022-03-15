package Base;

import Generator.Utilities;
import GrammarParser.GrammarParser;

public class NotTerminal extends Particle {
    private final String arguments;

    public NotTerminal(final String name) {
        this(name, null);
    }

    public NotTerminal(final String name, final String arguments) {
        super(name);
        this.arguments = arguments;
    }

    public NotTerminal(final GrammarParser.LeftContext ctx) {
        this(ctx.NTerminal().getText().toUpperCase(),
             ctx.Args() == null ? null : Utilities.bite(ctx.Args().getText()));
    }

    public String getArguments() {
        return arguments;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof NotTerminal) {
            return ((NotTerminal) obj).getText().equals(getText());
        } else {
            return false;
        }
    }
}
