import java.util.Scanner;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/24
 * @desc (美团)给定一组非负整数组成的数组h，代表一组柱状图的高度，其中每个柱子的宽度都为1。
 * 在这组柱状图中找到能组成的最大矩形的面积。 入参h为一个整型数组，代表每个柱子的高度，返回面积的值。
 */
public class RectangleMaxArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < height.length; i++) {
            height[i] = scanner.nextInt();
        }
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int max = -1;
        for (int i = 0; i < height.length; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && height[left] >= height[i]) {
                left--;
            }

            while (right < height.length && height[right] >= height[i]) {
                right++;
            }

            int area = (right - left - 1) * height[i];
            if (max < area) {
                max = area;
            }
        }
        return max;
    }
}
