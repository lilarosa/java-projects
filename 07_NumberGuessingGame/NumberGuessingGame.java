import java.util.Random;
import java.util.Scanner;

/**
 * NumberGuessingGame
 * 1-100 随机数，提示大/小，统计尝试次数
 */
public class NumberGuessingGame {
    public static void main(String[] args) {
        int target = new Random().nextInt(100) + 1;
        int tries = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Guess a number (1-100). Type 0 to quit.");
            while (true) {
                System.out.print("Your guess: ");
                int g = sc.nextInt();
                if (g == 0) { System.out.println("Bye!"); break; }
                tries++;
                if (g == target) {
                    System.out.println("Correct! Tries = " + tries);
                    break;
                } else if (g < target) {
                    System.out.println("Too small.");
                } else {
                    System.out.println("Too big.");
                }
            }
        }
    }
}
