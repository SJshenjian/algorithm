import java.util.Scanner;

/**
 * @author  Jian Shen
 * @version  V1.0
 * @date  2018/10/21
 * @desc  大富翁游戏，玩家根据骰子的点数决定走的步数，即骰子点数为1时可以走一步，点数为2时可以走两步，
 * 点数为n时可以走n步。求玩家走到第n步（n<=骰子最大点数且是方法的唯一入参）时，总共有多少种投骰子的方法。
 */
public class MonopolyGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = (int) Math.pow(2, n-1);
        System.out.println(result);
    }
}
