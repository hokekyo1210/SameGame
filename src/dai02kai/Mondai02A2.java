package dai02kai;

import java.util.Scanner;

public class Mondai02A2 {
	
	public Mondai02A2(){
		
	}
	
	public void solve(Scanner scan){
		int at = 0;
		while(true){
			int n = scan.nextInt();
			System.out.println("���� �}�X"+at+"�ł�.�o���T�C�R���̖�(1����6): "+n);
			if(n <= 0 || n > 6)continue;
			at += n;
			if(at == 11){
				System.out.println("�i�񂾐�̃}�X11�����Ƃ����Ȃ̂�5�}�X�߂�܂�.");
				at -= 5;
			}
			if(at >= 15)break;
		}
		System.out.println("�S�[���̃}�X15�ɓ��B�������z���܂���.");
	}

}
