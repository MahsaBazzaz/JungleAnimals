import java.util.*;

/**
 * the factory class
 * to make sample animal cards
 *
 * @author Mahsa Bazzaz 9631405
 * @version 0.0
 */
public class Factory {
    private Map<String, Integer> map = new HashMap<String, Integer>();

    /**
     * actually no constructor :)))
     */
    public Factory() {

    }

    /**
     * to create animal cards
     *
     * @param cards to put animals in
     */
    public void create(ArrayList<AnimalCard> cards) {
        cards.add(new AnimalCard("LION", 900, 1000, new Damage("INJURE", 150), new Damage("KILL", 500)));
        cards.add(new AnimalCard("BEAR", 850, 900, new Damage("INJURE", 130), new Damage("KILL", 600)));
        cards.add(new AnimalCard("TIGER", 850, 850, new Damage("INJURE", 120), new Damage("KILL", 650)));
        cards.add(new AnimalCard("VULTURE", 350, 600, new Damage("INJURE", 100),new Damage()));
        cards.add(new AnimalCard("FOX", 400, 600, new Damage("INJURE", 90),new Damage()));
        cards.add(new AnimalCard("ELEPHANT", 1200, 500, new Damage("HURT", 70), new Damage("ATTACK", 50)));
        cards.add(new AnimalCard("WOLF", 450, 700, new Damage("KILL", 700),new Damage()));
        cards.add(new AnimalCard("HOG", 1100, 500, new Damage("HURT", 80),new Damage()));
        cards.add(new AnimalCard("HIPPOPOTAMUS", 1000, 360, new Damage("KILL", 700),new Damage()));
        cards.add(new AnimalCard("COW", 750, 400, new Damage("ATTACK", 90), new Damage("INJURE", 100)));
        cards.add(new AnimalCard("RABBIT", 200, 350, new Damage("BITE", 80),new Damage()));
        cards.add(new AnimalCard("TURTLE", 350, 230, new Damage("BITE", 200),new Damage()));

    }
}
