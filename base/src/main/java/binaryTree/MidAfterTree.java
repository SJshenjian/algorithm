package binaryTree;
import java.util.Scanner;

/*
 *已知二叉树后序，中序序列，打印先序序列:
 *后序序列的最后一个元素定为根，在中序序列中查找根所在位置，从而确定左右子树
 *递归求解，返回条件为 结点为空或者为叶子结点
 *7
 *2 3 1 5 7 6 4
 *1 2 3 4 5 6 7
 */
public class MidAfterTree {

	public static StringBuilder sb = new StringBuilder();// 用于存储先序序列

	public static void calTree(int[] mid, int[] after) {

		if (mid.length == 0)// 当结点为空时，返回
			return;
		
		if (mid.length == 1) {// 当为叶子结点时，为根返回
			sb.append(mid[0] + " ");
			return;
		}

		int root = after[after.length - 1];// 后序序列的最后一个就是跟
		sb.append(root + " ");

		int middle = 0;//middle代表当前根在中序序列的索引
		for (int i = 0; i < mid.length; i++) {
			if (mid[i] == root) {
				middle = i;
			}
		}

		int[] leftMid = new int[middle];
		int[] leftAfter = new int[middle];
		
		for (int i = 0; i < middle; i++) {
			leftMid[i] = mid[i];//中序序列的左子树
			leftAfter[i] = after[i];//后序序列的左子树
		}

		int[] rightMid = new int[mid.length - middle - 1];
		int[] rightAfter = new int[mid.length - middle - 1];
		
		for (int i = 0; i < mid.length - middle - 1; i++) {
			rightMid[i] = mid[i + middle + 1];//中序序列的右子树
		}

		for (int i = 0; i < mid.length - middle - 1; i++) {
			rightAfter[i] = after[i + middle];//后序序列的右子树
		}

		calTree(leftMid, leftAfter);//中序左子树，后序左子树
		calTree(rightMid, rightAfter);//中序右子树，后序右子树

	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] mid = new int[n];
		int[] after = new int[n];
		for (int i = 0; i < n; i++) {
			after[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			mid[i] = in.nextInt();
		}
		calTree(mid, after);
		System.out.println("Preorder: " + sb.toString().trim());
	}

}
