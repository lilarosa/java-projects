import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * SimpleCalculator
 * 控制台计算器：输入两个数和运算符(+ - * /)
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            double a = sc.nextDouble();

            System.out.print("Enter operator (+ - * /): ");
            String op = sc.next();

            System.out.print("Enter second number: ");
            double b = sc.nextDouble();

            double result;
            switch (op) {
                case "+": result = a + b; break;
                case "-": result = a - b; break;
                case "*": result = a * b; break;
                case "/":
                    if (b == 0) { 
                        System.out.println("Error: division by zero."); 
                        return; 
                    }
                    result = a / b; break;
                default:
                    System.out.println("Unknown operator.");
                    return;
            }
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid number input.");
        }
    }
}
