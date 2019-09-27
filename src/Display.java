/**
 * the display class
 *
 * @author Mahsa Bazzaz 9631405
 * @version 0.0
 */

public class Display {
    /**
     * the constructor and everything :)))
     *
     * @param player   the player
     * @param opponent the opponent
     */
    public Display(Player player, Player opponent) {
        System.out.println("--------------YOUR DECK:-------------------");
        for (int i = 0; i < player.getCardDeck().getDeckSize(); i++) {
            System.out.print(i + "\t");
            player.getCardDeck().getAnimals().get(i).print();
        }
        System.out.println("----------OPPONENT DECK DECK:--------------");
        for (int i = 0; i < opponent.getCardDeck().getDeckSize(); i++) {
            System.out.print(i + "\t");
            opponent.getCardDeck().getAnimals().get(i).print();
        }

    }
}
