/**
 * the player class that human and computer are extended from
 *
 * @author Mahsa Bazzaz 9631405
 * @version 0.0
 */
public abstract class Player {
    public static final int NUMBER_OF_HEALING_ALLOWED = 3;
    private int id;
    private int lives;
    CardDeck cardDeck;
    public static final int PLAYER_LIVES = 10;
    int healingNumber;

    /**
     * the constructor
     *
     * @param id id of the player
     */
    public Player(int id) {
        this.id = id;
        lives = PLAYER_LIVES;
        if(this instanceof Human)
            System.out.printf("Setting up things for player %d\n", id);
        else if(this instanceof Computer)
            System.out.println("Setting things up for computer.");
        cardDeck = new CardDeck(this);
        healingNumber = NUMBER_OF_HEALING_ALLOWED;
    }

    /**
     * to get the id
     *
     * @return id
     */
    public int getId() {
        return id;
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
     * to decrement lives
     */
    public void decrementLiveByOne() {
        lives--;
    }

    /**
     * turn to play
     * this method has been override in human and computer
     *
     * @param opponent
     */
    public void turnToPlay(Player opponent) {

    }

    /**
     * to get the card deck
     *
     * @return
     */
    public CardDeck getCardDeck() {
        return cardDeck;
    }

    /**
     * to get the healing number
     *
     * @return healing number
     */
    public int getHealingNumber() {
        return healingNumber;
    }

    /**
     * to decrease the healing number
     */
    public void decreaseHealingNumber() {
        healingNumber--;
    }

}
