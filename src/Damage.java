/**
 * the damage class
 *
 * @author Mahsa Bazzaz 9631405
 * @version 0.0
 */
public class Damage {
    String name;
    int intensity;

    /**
     * the constructor
     *
     * @param name      name of the damage
     * @param intensity intensity of the damage
     */
    public Damage(String name, int intensity) {
        this.name = name;
        this.intensity = intensity;
    }

    /**
     * for no damage :)))
     */
    public Damage() {
        name = "no";
        intensity = 0;
    }

    /**
     * to get the name of damage
     *
     * @return name of damage
     */
    public String getName() {
        return name;
    }

    /**
     * to get the intensity of the damage
     *
     * @return intensity of the damage
     */
    public int getIntensity() {
        return intensity;
    }

    /**
     * to compare damage types
     *
     * @param o the damage
     * @return true if the same false if not
     */
    public int compareTo(Damage o) {
        if (o.name.equals(this.name)) {
            return 1;
        } else {
            return 0;
        }
    }
}
