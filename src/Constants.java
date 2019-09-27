import java.util.HashMap;
import java.util.Map;

/**
 * the maps
 *
 * @author Mahsa Bazzaz 9631405
 * @version 0.0
 */
public class Constants {


    private Map<String, Integer> energy = new HashMap<>();
    private Map<String, Integer> live = new HashMap<>();

    public Constants() {
        energy.put("LION", 1000);
        energy.put("BEAR", 900);
        energy.put("TIGER", 850);
        energy.put("VULTURE", 600);
        energy.put("FOX", 600);
        energy.put("ELEPHANT", 500);
        energy.put("WOLF", 700);
        energy.put("HOG", 500);
        energy.put("HIPPOPOTAMUS", 360);
        energy.put("COW", 400);
        energy.put("RABBIT", 350);
        energy.put("TURTLE", 230);

        live.put("LION", 900);
        live.put("BEAR", 850);
        live.put("TIGER", 850);
        live.put("VULTURE", 350);
        live.put("FOX", 400);
        live.put("ELEPHANT", 1200);
        live.put("WOLF", 450);
        live.put("HOG", 1100);
        live.put("HIPPOPOTAMUS", 1000);
        live.put("COW", 750);
        live.put("RABBIT", 200);
        live.put("TURTLE", 350);

    }

    /**
     * to get the energy map
     *
     * @return energy map
     */
    public Map<String, Integer> getEnergy() {
        return energy;
    }

    /**
     * to get the lives
     * @return lives map
     */
    public Map<String, Integer> getLive() {
        return live;
    }
}
