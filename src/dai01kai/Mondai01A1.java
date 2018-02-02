package dai01kai;

import java.util.Scanner;

public class Mondai01A1 {
	
	public Mondai01A1(){
	}
	
	public int solve(int x){
		if(x==1)return 0;
		if(x%2==1)return solve(3*x+1) + 1;
		return solve(x/2) + 1;
	}
	
	public String solve2(int l){
		StringBuffer ret = new StringBuffer("");
		for(int i = 0;i < l;i++){
			for(int k=i; k!=0; k--){
				ret.append(k+"");
			}
			for(int k=0; k < (l-i); k++){
				ret.append(k+"");
			}
			ret.append("\n");
		}
		return ret.toString();
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt();
		int ans = new Mondai01A1().solve(x);
		System.out.println(ans);
		
		int l = scan.nextInt();
		String ans2 = new Mondai01A1().solve2(l);
		System.out.println(ans2);
		
		scan.close();
	}

}
