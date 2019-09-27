import java.util.Scanner;

/**
 * the human class
 *
 * @author Mahsa Bazzaz 9631405
 * @version 0.0
 */
public class Human extends Player {
    Scanner scanner = new Scanner(System.in);

    /**
     * the constructor
     *
     * @param id id of the player
     */
    public Human(int id) {
        super(id);
    }

    //YOU CAN SEE THE JAVA DOC IN PLAYER CLASS
    @Override
    public void turnToPlay(Player opponent) {
        boolean choiceWasAcceptable = false;
        boolean successfulTurn = false;
        boolean invalidCard = true;
        new Display(this, opponent);
        int s;
        System.out.printf("Player %d DO YOU WANT TO ATTACK OR HEAL? A for attack and H for heal\n", this.getId());
        while (!successfulTurn) {
            String whatNext = scanner.next();
            if (whatNext.equals("A")) {
                while (!choiceWasAcceptable || invalidCard) {
                    invalidCard = false;
                    System.out.printf("Player %d How many cards you want to choose from yours?\n", this.getId());
                    int numberOfchoices = scanner.nextInt();
                    if (numberOfchoices > 0 && numberOfchoices < cardDeck.getDeckSize()) {
                        System.out.println("Choose the card(s) enter the index");
                        int[] indexes = new int[numberOfchoices];
                        for (int i = 0; i < numberOfchoices; i++) {
                            indexes[i] = scanner.nextInt();
                            if (indexes[i] < 0 || indexes[i] > cardDeck.getDeckSize()) {
                                System.out.println("ERROR:INVALID CARD INDEX. TRY AGAIN.");
                                invalidCard = true;
                                break;
                            }

                        }

                        if (!invalidCard) {
                            System.out.printf("Player %d choose the opponent card: enter the index\n", this.getId());
                            s = scanner.nextInt();
                            if (s >= 0 && s < opponent.getCardDeck().getDeckSize()) {
                                if (getCardDeck().targetAnimalCard(opponent, s, indexes)) {
                                    choiceWasAcceptable = true;
                                    break;
                                } else {
                                    System.out.print("BAD CHOICE.TRY AGAIN");
                                }
                            }
                        }
                    } else {
                        System.out.println("ERROR::OUT OF RANGE NUMBER!!.TRY AGAIN");
                        invalidCard = true;
                    }

                }
                successfulTurn = true;
                System.out.printf("NOW IT'S %d PLAYER TURN\n",opponent.getId());
            } else if (whatNext.equals("H")) {
                System.out.printf("Player %d What card do you want to heal? Enter the index\n", this.getId());
                cardDeck.heal(this, scanner.nextInt());
                successfulTurn = true;
            } else {
                System.out.println("ERROR::BAD INPUT!!.TRY AGAIN.");
            }
        }
    }
}
