package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MidAfterTreeCalLevel {

	/*
	 * 7
	*2 3 1 5 7 6 4(后序)
	*1 2 3 4 5 6 7(中序)
	*打印层次遍历:4 1 6 3 5 7 2
	*基本思路:后序序列的最后一个元素为根，再中序序列中找到根的索引，
	*左边即为左子树，右边极为右子树，分别对左右子树递归构建二叉树
	 */
	public Node calTree(int[] mid, int[] after) {

		if (mid.length == 0) {//结点为null
			return null;
		}
		if (mid.length == 1) {//当前结点为叶子结点
			Node node = new Node(mid[0]);
			return node;
		}

		int rootData = after[after.length - 1];
		Node root = new Node(rootData);//根节点

		int middle = 0;
		for (int i = 0; i < mid.length; i++) {
			if (rootData == mid[i]) {
				middle = i;//根节点在中序的索引
			}
		}

		int[] leftMid = new int[middle];
		int[] leftAfter = new int[middle];
		for (int i = 0; i < middle; i++) {
			leftMid[i] = mid[i];
			leftAfter[i] = after[i];
		}

		int[] rightMid = new int[mid.length - middle - 1];
		int[] rightAfter = new int[mid.length - middle - 1];
		for (int i = 0; i < mid.length - middle - 1; i++) {
			rightMid[i] = mid[i + middle + 1];
			rightAfter[i] = after[i + middle];
		}
        //中序左子树，后序左子树
		root.left = calTree(leftMid, leftAfter);
		//中序右子树，后序右子树
		root.right = calTree(rightMid, rightAfter);

		return root;
	}

	public static void main(String[] args) {

		MidAfterTreeCalLevel mtc = new MidAfterTreeCalLevel();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] after = new int[n];
		int[] mid = new int[n];
		for (int i = 0; i < n; i++) {
			after[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			mid[i] = in.nextInt();
		}

		Node root = mtc.calTree(mid, after);
		mtc.print(root);
	}
	
	private void print(Node root) {//使用队列层次打印二叉树
		Queue<Node> queue = new LinkedList<Node>();
		StringBuilder sb = new StringBuilder();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			sb.append(node.data + " ");
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		System.out.println(sb.toString().trim());
	}
	
	private class Node {//自定义结点
		int data;
		Node left = null;
		Node right = null;
		public Node(int data) {
			this.data = data;
		}
	}
}
