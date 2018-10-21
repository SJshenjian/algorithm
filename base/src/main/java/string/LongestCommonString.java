package string;

/**求最长公共子串大小**/
public class LongestCommonString {

	public static void main(String[] args) {
		char[] x={'A','B','C','B','D','A','B'};
		char[] y={'B','D','C','A','B','A'};
		//预期结果为4	
		int[][] c=new int[x.length][y.length];
		
		for(int i=0;i<x.length;i++){
			if(x[i] == y[0]){
				c[i][0]=1;
			}
		}
		
		for(int i=0;i<y.length;i++){
			if(y[i] == x[0]){
				c[0][i]=1;
			}
		}
		
		for(int i=1;i<x.length;i++){
			for(int j=1;j<y.length;j++){
				if(x[i] == y[j]){
					c[i][j]=c[i-1][j-1]+1;
				}else{
					c[i][j]=Math.max(c[i-1][j],c[i][j-1]);
				}
			}
		}
		
		System.out.println("最长的公共子串为:"+c[x.length-1][y.length-1]);
	}
}
