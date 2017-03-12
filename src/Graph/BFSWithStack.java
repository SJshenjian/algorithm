package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

	/*8 6
	0 7
	0 1
	2 0
	4 1
	2 4
	3 5
	result:
	{ 0 1 2 7 4 }
	{ 3 5 }
	{ 6 }*/

public class BFSWithStack {

	Scanner in;
	int n, m;
	int[][] a;
	boolean[] visited;
	
	BFSWithStack() {
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

	public void BFS(){
		for(int i=0;i<n;i++){
			if(!visited[i]){
				visited[i]=true;
				bfsWithQueue(i);
			}
		}
	}

	private void bfsWithQueue(int vertex) {
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(vertex);
		System.out.print("{ ");
		while(!queue.isEmpty()){
			int v=queue.poll();
			System.out.print(v+" ");
			for(int i=0;i<n;i++){
				if(!visited[i] && a[v][i]==1){
					visited[i]=true;
					queue.add(i);
				}
			}
		}
		System.out.println("}");
	}

	public static void main(String[] args) {
       BFSWithStack main=new BFSWithStack();
       main.BFS();
	}
}
