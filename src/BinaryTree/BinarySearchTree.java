package BinaryTree;

import java.util.Scanner;

public class BinarySearchTree {
	//9
	//38 45 42 24 58 30 67 12 51
	/*
	 * 用数组进行存储二叉树，根据前n个数是否值为0判断是否为完全二叉树
	 */
	static int[] a=new int[2200000];

	public static void main(String[] args) {
	   BinarySearchTree m=new BinarySearchTree();
       Scanner in=new Scanner(System.in);
       int n=in.nextInt();
       for(int i=0;i<n;i++){
    	   int data=in.nextInt();
    	   m.insert(1,data);
       }
       boolean flag=true;
       for(int i=1;i<=n;i++){
    	   if(a[i]==0){//判断是否为完全二叉树
    		   flag=false;
    		   break;
    	   }
       }
       int r=1;
       int i=1;
       while(r<=n){//用于输出
    	   if(a[i]!=0){
    		   System.out.print(a[i]);
    		   r++;
    		   if(r<=n){
    			   System.out.print(" ");
    		   }
    	   }
    	   i++;
       }
       System.out.println();
    
       System.out.println(flag==true?"YES":"NO");
      
	}

	private void insert(int i, int data) {
		if(a[i]==0){
			a[i]=data;
		}else{
			if(data>a[i]){
				insert(2*i,data);
			}else{
				insert(2*i+1,data);
			}
		}	
	}
}
