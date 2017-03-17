package Graph;

import java.util.Scanner;
import java.util.Stack;

public class DFSWithStack {

	/*8 6  
	0 7
	0 1
	2 0
	4 1
	2 4
	3 5
	result:
	{ 0 1 4 2 7 }
	{ 3 5 }
	{ 6 }
	1 2
	1 7
	2 3
	3 4
	4 7
	*/
	Scanner in;
	int n, m;
	int[][] a;
	boolean[] visited;
	DFSWithStack() {
		in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		a = new int[n][n];
		visited = new boolean[n];

		for (int i = 0; i < m; i++) {
			int begin = in.nextInt();
			int end = in.nextInt();
			a[begin][end] = a[end][begin] = 1;
		}
	}

	public void DFS() {
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfsWithStack(i);
			}
		}
	}

	private void dfsWithStack(int vertex) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(vertex);
		System.out.print("{ ");
		while (!stack.isEmpty()) {
			int currentVertex = stack.pop();
			System.out.print(currentVertex + " ");
			for (int i = n - 1; i >= 0; i--) {//从大到小进栈，从小到大输出
				if (!visited[i]  && a[currentVertex][i] == 1) {
					visited[i] = true;
					stack.push(i);
				}
			}
		}
		System.out.println("}");
	}

	public static void main(String[] args) {
       DFSWithStack main=new DFSWithStack();
       main.DFS();
	}
}
