/**
 * ExceptionHandlingDemo
 * 演示 try-catch-finally；制造两种常见异常
 */
public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        // 1) ArithmeticException: /0
        try {
            int x = 10 / 0;
            System.out.println(x); // 不会执行
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("Finally after arithmetic.");
        }

        // 2) NumberFormatException
        try {
            int n = Integer.parseInt("abc");
            System.out.println(n); // 不会执行
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } finally {
            System.out.println("Finally after parsing.");
        }

        System.out.println("Program continues normally.");
    }
}
