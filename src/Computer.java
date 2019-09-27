import java.util.ArrayList;
import java.util.Random;

/**
 * the computer class
 *
 * @author Mahsa Bazzaz 9631405
 * @version 0.0
 */
public class Computer extends Player {
    /**
     * the constructor
     */
    public Computer() {
        super(1);
    }

    @Override
    public void turnToPlay(Player opponent) {
        new Display(this, opponent);
        Random random = new Random();
        int ifRandom = random.nextInt(1);
        int[] index;
        if(ifRandom == 0){//ATTACK
            int howMany = random.nextInt(1)+1; //one or two
            index = new int[howMany];
            for(int i=0;i<howMany;i++){
                index[i] = random.nextInt(cardDeck.getDeckSize()-1);
            }
            int oppentIndex = random.nextInt(opponent.cardDeck.getDeckSize()-1);
            attack(opponent,oppentIndex,index);

        }
        else if(ifRandom == 1){ //HEAL
            int which = random.nextInt(cardDeck.getDeckSize()-1);
            cardDeck.heal(this,which);
        }
    }

    private void attack(Player opp, int opAnimalCardIndex, int[] index){
        boolean flag = true;
        int sumOfAttack = 0;
        boolean wasSuccessful = false;
        ArrayList<Integer> card = generate(index);
        while (!wasSuccessful) {
            if (typeCheck(index, card)) {
                wasSuccessful = true;
                for (int i = 0; i < index.length; i++) {
                    if (this.getCardDeck().getAnimals().get(index[i]).getFirstMethodOfDamaging().getName().equals(card.get(i))) {
                        sumOfAttack += opp.getCardDeck().getAnimals().get(index[i]).getFirstMethodOfDamaging().getIntensity();
                    }
                    if (this.getCardDeck().getAnimals().get(index[i]).getSecondMethodOfDamaging().getName().equals(card.get(i))) {
                        sumOfAttack += opp.getCardDeck().getAnimals().get(index[i]).getSecondMethodOfDamaging().getIntensity();
                    }
                }

                int remaining = opp.getCardDeck().getAnimals().get(opAnimalCardIndex).getLives() - sumOfAttack;
                for (int i = 0; i < index.length; i++) {
                    if (opp.getCardDeck().getAnimals().get(index[i]).getEnergy() - (sumOfAttack / index.length) < 0)
                        flag = false;
                    break;
                }

                if (flag) {
                    for (int j = 0; j < index.length; j++) {
                        opp.getCardDeck().getAnimals().get(index[j]).decreaseEnergy(sumOfAttack / index.length);
                        if (remaining < 0) {
                            opp.getCardDeck().getAnimals().get(index[j]).increaseEnergy(Math.abs(remaining) / index.length);
                        }
                        System.out.printf("the card's %s Energy reduced to %d \n",
                                opp.getCardDeck().getAnimals().get(index[j]).getName(), opp.getCardDeck().getAnimals().get(index[j]).getEnergy());
                    }
                    opp.getCardDeck().getAnimals().get(opAnimalCardIndex).decreaseLives(sumOfAttack);
                    System.out.printf("the card's %s life reduced to %d\n",
                            opp.getCardDeck().getAnimals().get(opAnimalCardIndex).getName(), opp.getCardDeck().getAnimals().get(opAnimalCardIndex).getLives());
                    if (remaining == 0)
                        opp.getCardDeck().animalDead(opp, opAnimalCardIndex);
                }
            }
        }
    }
    private ArrayList<Integer> generate(int[] index){
        ArrayList<Integer> s = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < index.length; i++) {
            s.add(random.nextInt(1)); //0 or 1
        }
        return s;
    }
    private boolean typeCheck(int[] index,ArrayList<Integer> s){
        boolean areTheTypes = true;
        if (index.length > 1) {
            for (int i = 1; i <= index.length; i++) {
                if (!s.get(i).equals(s.get(i - 1))) {
                    areTheTypes = false;
                }
            }
        }
        else if (index.length == 1) areTheTypes = true;
        return areTheTypes;
    }
}
