package Base;

import java.util.Objects;

public class Particle {
    private final String name;

    public Particle(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Particle{" +
                "name='" + name + '\'' +
                '}';
    }
}
