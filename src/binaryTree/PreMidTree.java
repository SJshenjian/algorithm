package binaryTree;

import java.util.Scanner;

public class PreMidTree {

	private static StringBuilder sb = new StringBuilder();
	public static void calTree(int[] pre, int[] mid) {

		if (mid.length == 0)
			return;
		if (mid.length == 1) {
			sb.append(mid[0] + " ");
			return;
		}
		int middle = 0;
		for (int i = 0; i < mid.length; i++) {
			if (mid[i] == pre[0]) {
				middle = i;
			}
		}

		int[] leftMid = new int[middle];
		int[] leftPre = new int[middle];

		for (int i = 0; i < middle; i++) {
			leftMid[i] = mid[i];
			leftPre[i] = pre[i + 1];
		}

		int[] rightMid = new int[mid.length - middle - 1];
		int[] rightPre = new int[mid.length - middle - 1];

		for (int i = 0; i < mid.length - middle - 1; i++) {
			rightMid[i] = mid[i + middle + 1];
			rightPre[i] = pre[i + middle + 1];
		}
		calTree(leftPre, leftMid);
		calTree(rightPre, rightMid);
		sb.append(pre[0] + " ");		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] pre = { 4, 1, 3, 2, 6, 5, 7 };
		int[] mid = { 1, 2, 3, 4, 5, 6, 7 };
		calTree(pre, mid);
		System.out.println(sb.toString().trim());
	}
}
