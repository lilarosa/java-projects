import java.util.Scanner;

/**
 * PasswordChecker
 * 规则：长度>=8，含大写、小写、数字、特殊字符
 */
public class PasswordChecker {

    static boolean hasUpper(String s){ return s.chars().anyMatch(Character::isUpperCase); }
    static boolean hasLower(String s){ return s.chars().anyMatch(Character::isLowerCase); }
    static boolean hasDigit(String s){ return s.chars().anyMatch(Character::isDigit); }
    static boolean hasSpecial(String s){
        return s.chars().anyMatch(c -> "!@#$%^&*()-_=+[]{};:'\",.<>/?`~|\\".indexOf(c) >= 0);
    }

    static String check(String pwd){
        StringBuilder sb = new StringBuilder();
        if (pwd.length() < 8) sb.append("长度<8; ");
        if (!hasUpper(pwd)) sb.append("缺少大写; ");
        if (!hasLower(pwd)) sb.append("缺少小写; ");
        if (!hasDigit(pwd)) sb.append("缺少数字; ");
        if (!hasSpecial(pwd)) sb.append("缺少特殊字符; ");
        return sb.length() == 0 ? "Strong Password ✅" : "Weak: " + sb;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter password: ");
            String pwd = sc.nextLine();
            System.out.println(check(pwd));
        }
    }
}
