package string;

import java.util.Scanner;

public class Knapsack {

	static int knapsackCal(int[] v, int[] w,int capacity){
		int[][] m=new int[v.length][capacity+1];
		
		for(int j=0;j<=capacity;j++){
			if(w[w.length-1] <= j){
				m[v.length-1][j]=v[v.length-1];
			}
			System.out.print(m[v.length-1][j]+" ");
		}
		System.out.println();
		
		for(int i=v.length-2;i>=1;i--){
			for(int j=0;j<=capacity;j++){
				if(w[i] <= j){
					m[i][j]=Math.max(m[i+1][j], v[i]+m[i+1][j-w[i]]);
				}else{
					m[i][j]=m[i+1][j];
				}
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		
		
		return m[1][capacity];
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);

		System.out.println("请输入背包容量:");
		int capacity=in.nextInt();//10
		
		System.out.println("请输入物品数:");
		int num=in.nextInt();//5
		
		System.out.println("请依次次输入背包的价值:");//6 3 5 4 6
		int[] value=new int[num+1];
		for(int i=1;i<value.length;i++){
			value[i]=in.nextInt();
		}
			
		System.out.println("请以此输入物品的重量");//2 2 6 5 4
		int[] weight=new int[num+1];
		for(int i=1;i<weight.length;i++){
			weight[i]=in.nextInt();
		}
		
		System.out.println("背包的最大价值为:"+knapsackCal(value,weight,capacity));//15
	}
}
