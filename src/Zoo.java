import java.security.InvalidParameterException;
import java.util.Scanner;

/**
 * the zoo class that contains main method
 * @author Mahsa Bazzaz 9631405
 * @version 0.0
 */
public class Zoo {
    public static void main(String[] args) {
        System.out.println("Player mode OR Computer mode? Enter P OR C");
        Scanner scanner = new Scanner(System.in);
        String c = scanner.nextLine();
        if (c.equals("P") || c.equals("C")) {
            new Game(c);
        } else {
            System.out.println("ERROR::Bad input. Try again");
            throw new InvalidParameterException();
        }
    }

}
