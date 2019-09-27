import java.util.*;

/**
 * the card deck class
 *
 * @author Mahsa Bazzaz 9631405
 * @version 0.0
 */
public class CardDeck {
    public static final int NUMBER_OF_CARDS = 30;
    public static final int NUMBER_OF_ANIMALS = 10;

    private ArrayList<AnimalCard> cards;//all different types of cards
    private AnimalCard[] allCards; //all the generated cards
    private ArrayList<AnimalCard> animals;// the chosen cards
    private Constants constants = new Constants();

    /**
     * the constructor
     *
     * @param player the player
     */
    public CardDeck(Player player) {
        cards = new ArrayList<>();
        allCards = new AnimalCard[NUMBER_OF_CARDS];
        animals = new ArrayList<>();
        distributeCards(player);
    }

    /**
     * distribute cards in the star of the game
     */
    public void distributeCards(Player player) {
        Random random = new Random();
        Factory f = new Factory();
        f.create(cards);
        for (int j = 0; j < allCards.length; j++) {

            allCards[j] = cards.get(random.nextInt(11)).clone();
        }
        chooseCard(player);
    }

    /**
     * to choose the cards in the beginning of the game
     */
    private void chooseCard(Player player) {
        if (player instanceof Human) {
            int j;
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Player %d there are %d cards below, Choose %d cards you want: NOTE:: enter the index\n",
                    player.getId(), NUMBER_OF_CARDS, NUMBER_OF_ANIMALS);
            for (int i = 0; i < allCards.length; i++) {
                System.out.print(i + "\t");
                allCards[i].print();
            }
            for (int i = 0; i < NUMBER_OF_ANIMALS; i++) {
                j = scanner.nextInt();
                if (0 <= j && j < allCards.length) {
                    animals.add(allCards[j]);
                } else {
                    System.out.println("ERROR::OUT OF RANGE CARD NUMBER!!.START AGAIN");
                    throw new IndexOutOfBoundsException();
                }
            }
        } else if (player instanceof Computer) {
            int[] selected = new int[NUMBER_OF_ANIMALS];
            int temp;
            int counter=0;
            Random random = new Random();
            for (int j = 0; j < NUMBER_OF_ANIMALS; j++) {
                temp = random.nextInt(NUMBER_OF_CARDS - 1);
                for (int k = 0; k < j; k++) {
                    if (selected[k] != temp)
                        counter++;
                }
                if(counter==j)
                    selected[j] = temp;
                else
                    j--;
            }

            for (int i = 0; i < NUMBER_OF_ANIMALS; i++) {
                animals.add(allCards[selected[i]]);
            }
        }
    }

    /**
     * to get the animals
     *
     * @return animals
     */
    public ArrayList<AnimalCard> getAnimals() {
        return animals;
    }

    /**
     * to get the deck size
     *
     * @return
     */
    public int getDeckSize() {
        return animals.size();
    }

    /**
     * to get all the randomly generated cards
     *
     * @return
     */
    public AnimalCard[] getAllCards() {
        return allCards;
    }

    /**
     * to target an animal card
     *
     * @param opp               the opponent player
     * @param opAnimalCardIndex the target animal card
     * @param index             the indexes
     * @return if the attack was successful or not
     */
    public boolean targetAnimalCard(Player opp, int opAnimalCardIndex, int[] index) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int sumOfAttack = 0;
        ArrayList<String> s = new ArrayList<>();
        boolean areTheTypes = true;
        for (int i = 0; i < index.length; i++) {
            System.out.printf("Which method of %s card\n", animals.get(index[i]).getName());
            s.add(scanner.nextLine());
        }
        if (index.length > 1) {
            for (int i = 1; i < index.length; i++) {
                if (!s.get(i).equals(s.get(i - 1))) {
                    System.out.print("Type don't match.");
                    areTheTypes = false;
                }
            }
        } else if (index.length == 1) areTheTypes = true;
        if (areTheTypes) {
            for (int i = 0; i < index.length; i++) {
                if (animals.get(index[i]).getFirstMethodOfDamaging().getName().equals(s.get(i))) {
                    sumOfAttack += animals.get(index[i]).getFirstMethodOfDamaging().getIntensity();
                }
                if (animals.get(index[i]).getSecondMethodOfDamaging().getName().equals(s.get(i))) {
                    sumOfAttack += animals.get(index[i]).getSecondMethodOfDamaging().getIntensity();
                }
            }

            int remaining = opp.getCardDeck().getAnimals().get(opAnimalCardIndex).getLives() - sumOfAttack;
            for (int i = 0; i < index.length; i++) {
                if (animals.get(index[i]).getEnergy() - (sumOfAttack / index.length) < 0)
                    flag = false;
                break;
            }

            if (flag) {
                for (int j = 0; j < index.length; j++) {
                    animals.get(index[j]).decreaseEnergy(sumOfAttack / index.length);
                    if (remaining < 0) {
                        animals.get(index[j]).increaseEnergy(Math.abs(remaining) / index.length);
                    }
                    System.out.printf("the card's %s Energy reduced to %d \n", animals.get(index[j]).getName(), animals.get(index[j]).getEnergy());
                }
                opp.getCardDeck().getAnimals().get(opAnimalCardIndex).decreaseLives(sumOfAttack);
                System.out.printf("the card's %s life reduced to %d\n",
                        opp.getCardDeck().getAnimals().get(opAnimalCardIndex).getName(), opp.getCardDeck().getAnimals().get(opAnimalCardIndex).getLives());
                if (remaining == 0)
                    animalDead(opp, opAnimalCardIndex);
            }


        }
        return flag;
    }

    public void heal(Player player, int index) {
        player.decreaseHealingNumber();
        if (player.getHealingNumber() <= 0)
            System.out.print("YOU ARE NOT ALLOWED TO HEAL ANY MORE!!");
        else {
            for (Map.Entry<String, Integer> entry : constants.getEnergy().entrySet()) {
                if (entry.getKey().equals(animals.get(index).getName()))
                    animals.get(index).setEnergy(entry.getValue());
            }
            System.out.printf("the %s's energy is full again!", animals.get(index).getName());
        }
    }

    /**
     * delete an animal card if it has no lives left
     *
     * @param opponent the opponent
     * @param index    the index of the card
     */
    public void animalDead(Player opponent, int index) {
        int p;
        if (opponent.getId() == 1)
            p = 2;
        else p = 1;

        if (opponent.getCardDeck().getAnimals().get(index).getLives() == 0) {
            System.out.printf("Player %d YOU KILLED %s\n", p, opponent.getCardDeck().getAnimals().get(index).getName());
            opponent.getCardDeck().getAnimals().remove(index);
            opponent.decrementLiveByOne();
            System.out.printf("Player %d you lost one of your cards.\n", opponent.getId());
        }

    }

}
