/**
 * The animal card class
 *
 * @author Mahsa Bazzaz 9631405
 * @version 0.0
 */

public class AnimalCard implements Cloneable {
    private String name;
    private int energy;
    private int lives;
    private Damage firstMethodOfDamaging;
    private Damage secondMethodOfDamaging;

    /**
     * the first constructor (for the ones with two methods for damaging)
     *
     * @param name                   name of the animal
     * @param lives                  lives of the animal
     * @param energy                 energy of the animal
     * @param firstMethodOfDamaging  first method of damaging
     * @param secondMethodOfDamaging second method of damaging
     */
    public AnimalCard(String name, int lives, int energy, Damage firstMethodOfDamaging, Damage secondMethodOfDamaging) {
        this.name = name;
        this.lives = lives;
        this.energy = energy;
        this.firstMethodOfDamaging = firstMethodOfDamaging;
        this.secondMethodOfDamaging = secondMethodOfDamaging;


    }

    /**
     * the second constructor (for the ones without second method of damaging)
     *
     * @param name                  name of the animal
     * @param lives                 lives of the animal
     * @param energy                energy of the animal
     * @param firstMethodOfDamaging first method of damaging
     */
    public AnimalCard(String name, int lives, int energy, Damage firstMethodOfDamaging) {
        this.name = name;
        this.lives = lives;
        this.energy = energy;
        this.firstMethodOfDamaging = firstMethodOfDamaging;
        this.secondMethodOfDamaging = null;

    }

    /**
     * private constructor -->for making new cards from the samples :)))
     *
     * @param obj the object
     */
    private AnimalCard(AnimalCard obj) {
        this.name = obj.name;
        this.lives = obj.lives;
        this.energy = obj.energy;
        this.firstMethodOfDamaging = obj.firstMethodOfDamaging;
        this.secondMethodOfDamaging = obj.secondMethodOfDamaging;

    }

    /**
     * to clone
     *
     * @return the animal card
     */
    public AnimalCard clone() {
        return new AnimalCard(this);
    }

    /**
     * to get the name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * to get the energy
     *
     * @return energy
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * decrease the energy
     *
     * @param e energy to be decreased
     */
    public void decreaseEnergy(int e) {
        this.energy -= e;
    }

    /**
     * to increase energy
     *
     * @param e the amount to increase
     */
    public void increaseEnergy(int e) {
        energy += e;
    }

    /**
     * to get the lives
     *
     * @return lives
     */
    public int getLives() {
        return lives;
    }

    /**
     * to set the lives
     *
     * @param l lives to be decreased
     */
    public void decreaseLives(int l) {
        lives -= l;
    }

    /**
     * to set energy
     *
     * @param energy the energy
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }


    /**
     * ti get first method of damaging
     *
     * @return first method of damaging
     */
    public Damage getFirstMethodOfDamaging() {
        return firstMethodOfDamaging;
    }

    /**
     * to get second method of damaging
     *
     * @return second method of damaging
     */
    public Damage getSecondMethodOfDamaging() {
        return secondMethodOfDamaging;
    }

    /**
     * to print
     */
    public void print() {
        Constants constants = new Constants();
        if (secondMethodOfDamaging.getName() != "no" && secondMethodOfDamaging.getIntensity() != 0) {
            System.out.println(name + "--->initial lives: " + constants.getLive().get(name) + " Lives left: " + lives
                    + "Initial energy+ " + constants.getEnergy().get(name) + "Energy left: " + energy + "" +
                    " ,first method of damaging: " + firstMethodOfDamaging.getName() + "--> " + firstMethodOfDamaging.getIntensity() +
                    " ,Second method of damaging" + secondMethodOfDamaging.getName() + "--> " + secondMethodOfDamaging.getIntensity());
        } else {
            System.out.println(name + "--->Lives left: " + lives + " ,Energy left: " + energy + "" +
                    " ,first method of damaging: " + firstMethodOfDamaging.getName() + "--> " + firstMethodOfDamaging.getIntensity());
        }

    }

}
