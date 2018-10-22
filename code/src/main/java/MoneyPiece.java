import java.util.Scanner;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/22
 * @desc 给你六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多，
 * 编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。
 */
public class MoneyPiece {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            long result = count(n);
            System.out.println(result);
        }
    }

    private static long count(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] coins = new int[]{1, 5, 10, 20, 50, 100};
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[n];
    }
}
