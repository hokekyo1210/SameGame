package dai02kai;

import java.util.Scanner;

public class Mondai02A1 {
	
	public Mondai02A1(){
		
	}
	
	public void solve(Scanner scan){
		int a = scan.nextInt(),b = scan.nextInt();
		if(a < b){
			while(a <= b)System.out.print(a++ +" ");
		}else{
			while(b <= a)System.out.print(a-- +" ");
		}
	}
}
