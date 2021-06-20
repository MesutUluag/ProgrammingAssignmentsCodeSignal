import java.math.BigDecimal;
import java.util.Objects;

public class Dog {
    private BigDecimal height;
    private BigDecimal weight;
    private String race;
    private String name;

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(race, dog.race) && Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(race, name);
    }
}
