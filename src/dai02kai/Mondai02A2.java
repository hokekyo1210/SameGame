package dai02kai;

import java.util.Scanner;

public class Mondai02A2 {
	
	public Mondai02A2(){
		
	}
	
	public void solve(Scanner scan){
		int at = 0;
		while(true){
			int n = scan.nextInt();
			System.out.println("現在 マス"+at+"です.出たサイコロの目(1から6): "+n);
			if(n <= 0 || n > 6)continue;
			at += n;
			if(at == 11){
				System.out.println("進んだ先のマス11が落とし穴なので5マス戻ります.");
				at -= 5;
			}
			if(at >= 15)break;
		}
		System.out.println("ゴールのマス15に到達したか越えました.");
	}

}
