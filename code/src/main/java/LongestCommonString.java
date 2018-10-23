import java.util.Scanner;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/23
 * @desc 给出两个字符串（可能包含空格）,找出其中最长的公共连续子串,输出其长度。
 */
public class LongestCommonString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            int length = count(a, b);
            System.out.println(length);
        }
    }

    private static int count(String a, String b) {
        if (a == null || b == null) {
            return 0;
        }

        int[][] dp = new int[a.length()][b.length()];
        int max = 0;

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }

        return max;
    }
}
