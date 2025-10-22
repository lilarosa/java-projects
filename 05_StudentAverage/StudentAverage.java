import java.util.Arrays;
import java.util.Scanner;

/**
 * StudentAverage
 * 输入若干分数，计算平均分与等级
 */
public class StudentAverage {
    static char grade(double avg) {
        if (avg >= 90) return 'A';
        if (avg >= 80) return 'B';
        if (avg >= 70) return 'C';
        if (avg >= 60) return 'D';
        return 'F';
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Number of scores: ");
            int n = sc.nextInt();
            if (n <= 0) { System.out.println("Invalid n"); return; }

            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Score #" + (i+1) + ": ");
                arr[i] = sc.nextDouble();
            }
            double sum = 0;
            for (double v : arr) sum += v;
            double avg = sum / n;

            System.out.println("Scores: " + Arrays.toString(arr));
            System.out.printf("Average: %.2f, Grade: %c%n", avg, grade(avg));
        }
    }
}
