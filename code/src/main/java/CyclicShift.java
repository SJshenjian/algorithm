import java.util.Scanner;

/**
 * 字符串ABCD，可以由字符串BCDA或者CDAB通过循环移位而得到。
 * 请编程实现以下检测：字符串S1是否可以由字符串S2通 过循环移位而得到 -- 美团
 *
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/27
 */
public class CyclicShift {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            System.out.println(isContained(s1, s2));
        }
    }

    private static boolean isContained(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(s2).append(s2);

        if (builder.toString().contains(s1)) {
            return true;
        }
        return false;
    }
}
