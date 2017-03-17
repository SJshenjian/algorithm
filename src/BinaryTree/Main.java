package BinaryTree;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n+1];
		for(int i=1;i<=n;i++){
			a[i]=in.nextInt();
		}
		int number1=in.nextInt();
		int number2=in.nextInt();
		
		if(a[number1]==0){
			System.out.println("ERROR: T["+number1+"] is NULL");
		}else if(a[number2]==0){
			System.out.println("ERROR: T["+number2+"] is NULL");
		}else{
			while(number1!=number2){
				while(number1<number2){
					number2/=2;
				}
				while(number2<number1){
					number1/=2;
				}
			}
			System.out.println(number1+" "+a[number1]);
		}
	}
}
