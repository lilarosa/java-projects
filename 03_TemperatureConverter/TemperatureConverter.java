import java.util.Scanner;

/**
 * TemperatureConverter
 * 摄氏/华氏相互转换
 */
public class TemperatureConverter {

    static double cToF(double c) { return c * 9 / 5 + 32; }
    static double fToC(double f) { return (f - 32) * 5 / 9; }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Convert (C2F/F2C): ");
            String mode = sc.next().trim().toUpperCase();
            System.out.print("Value: ");
            double v = sc.nextDouble();

            if (mode.equals("C2F")) {
                System.out.printf("%.2f °C = %.2f °F%n", v, cToF(v));
            } else if (mode.equals("F2C")) {
                System.out.printf("%.2f °F = %.2f °C%n", v, fToC(v));
            } else {
                System.out.println("Unknown mode.");
            }
        }
    }
}
