import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TermChecker {
	public static void main(String[] args) {
        // 1. 定义术语库 (Map 就像一本字典，Key是英文，Value是匈牙利语)
        Map<String, String> rules = new HashMap<>();
        rules.put("Invoice", "Számla");
        rules.put("Contract", "Szerződés");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Step 1: Paste SOURCE text (English):");
        String source = scanner.nextLine();

        System.out.println("Step 2: Paste TARGET text (Hungarian):");
        String target = scanner.nextLine();

        System.out.println("\n--- Performing QA Check ---");

        /**
         * 【重点笔记：Map 遍历逻辑】
         * Map 本身是一个整体，不能直接被 for-each 循环。
         * 所以我们要通过 rules.entrySet() 把 Map 变成一个“装满名片的集合”。
         * * Map.Entry<String, String> : 这一对术语的“类型名称”，就像“名片”的规格。
         * entry : 我们给当前这张“名片”起的临时代号。
         * rules.entrySet() : 拿出字典里所有的“名片对”。
         */
        for (Map.Entry<String, String> entry : rules.entrySet()) {
            
            // entry.getKey()   -> 拿到名片正面的原文（如 "Invoice"）
            // entry.getValue() -> 拿到名片反面的标准译文（如 "Számla"）
            String sourceTerm = entry.getKey();
            String targetTerm = entry.getValue();

            // 逻辑第一步：先看原文里有没有这个词
            if (source.contains(sourceTerm)) {
                
                // 逻辑第二步：如果原文有，但译文里【不包含】对应的标准词
                // "!" 表示“非”或者“不”
                if (!target.contains(targetTerm)) {
                    System.err.println("❌ 术语错误：原文有 '" + sourceTerm + 
                                       "'，但译文中没找到对应的 '" + targetTerm + "'。");
                } else {
                    System.out.println("✅ 术语检查通过：'" + sourceTerm + "' 翻译正确。");
                }
            }
        }
        
        scanner.close();
    }
}
