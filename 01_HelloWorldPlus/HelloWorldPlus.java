import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * HelloWorldPlus
 * - 打印个人介绍
 * - 打印当前时间
 * - 随机名言
 */
public class HelloWorldPlus {
    public static void main(String[] args) {
        System.out.println("Hi, I'm Tao Wang. 👋");
        System.out.println("Umschüler FI AE @ DAA Böblingen.");
        System.out.println("Learning: Java, JS, Linux, Networks.");

        LocalDateTime now = LocalDateTime.now();
        String formatted = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("Current time: " + formatted);

        String[] quotes = {
            "Practice makes progress.",
            "Talk is cheap, show me the code. — Linus Torvalds",
            "Simplicity is the soul of efficiency. — Austin Freeman",
            "The only way to learn a new programming language is by writing programs in it. — Kernighan"
        };
        int idx = new Random().nextInt(quotes.length);
        System.out.println("Quote: " + quotes[idx]);
    }
}
