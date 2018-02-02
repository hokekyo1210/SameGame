package dai19kai;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HitAndBlow {
	
	private final static int NONSENSE = -9999;
	
	
	private static class HitBlow{
		
		private int hit = NONSENSE, blow = NONSENSE;
		
		HitBlow(int hit,int blow){
			this.hit = hit;
			this.blow = blow;
		}
		
		boolean guessSuccessful(){
			return hit == 4;
		}
		
		boolean equals(HitBlow y){
			return (y.hit == hit) && (y.blow == blow);
		}
		
		@Override
		public String toString(){
			return hit+" hit "+blow+" blow";
		}
	}
	
	private static class Digits{
		private final static int KETASUU = 4;
		private byte[] digitsA = null;
		private static Random rand = null;
		
		private static boolean isValidDigits(byte[] dA){
			for(int i = 0;i < KETASUU;i++){
				for(int j = 0;j < KETASUU;j++){
					if(i != j && dA[i] == dA[j])return false;
				}
			}
			return true;
		}
		
		Digits(byte[] digitsA){
			this.digitsA = digitsA;
		}
		
		static Digits toDigits(int x){
			byte[] dA = new byte[KETASUU];
			String buffer = String.valueOf(x);
			while(buffer.length()!=KETASUU){
				buffer = "0"+buffer;
			}
			for(int i = 0;i < KETASUU;i++){
				dA[i] = (byte) (buffer.charAt(i) - '0');
			}
			
			return isValidDigits(dA) ? new Digits(dA) : null;
		}
		
		static Digits makeRandomDigits(){
			if(rand == null)rand = new Random();
			Digits ret;
			do{
				ret = toDigits(rand.nextInt(10000));
			}while(ret == null);
			
			return ret;
		}
		
		private byte[] getDigitsA(){
			return digitsA;
		}
		
		HitBlow getHitBlow(Digits y){
			byte[] yDigitsA = y.getDigitsA();
			int hit = 0, blow = 0;
			System.out.println(this+" "+y);
			for(int i = 0;i < KETASUU;i++){
				for(int j = 0;j < KETASUU;j++){
					if(digitsA[i] != yDigitsA[j])continue;
					if(i == j)hit++;
					else blow++;
				}
			}
			
			return new HitBlow(hit,blow);
		}
		
		@Override
		public String toString(){
			StringBuffer sb = new StringBuffer();
			for(int i = KETASUU - 1;0 <= i;i--){
				sb.append(digitsA[i]);
			}
			return sb.toString();
		}
	}
	
	private static class DigitsHitBlow{
		private Digits digits = null;
		private HitBlow hitBlow = null;
		
		DigitsHitBlow(Digits digits, HitBlow hitBlow){
			this.digits = digits;
			this.hitBlow = hitBlow;
		}
		
		boolean isConsistentWith(Digits yDigits){
			HitBlow yHitBlow = digits.getHitBlow(yDigits);
			return hitBlow.equals(yHitBlow);
		}
	}
	
	private static class GuessHistory{
		ArrayList<DigitsHitBlow> digitsHitBlowAL = new ArrayList<DigitsHitBlow>();
		
		void add(Digits guessDigits, HitBlow hitBlow){
			digitsHitBlowAL.add(new DigitsHitBlow(guessDigits,hitBlow));
		}
		
		boolean isConsistentWith(Digits yDigits){
			for(DigitsHitBlow dhb : digitsHitBlowAL){
				if(!dhb.isConsistentWith(yDigits))return false;
			}
			return true;
		}
	}
	
	public static void main(String[] args){
		Digits questionDigits = Digits.makeRandomDigits();
		
		System.out.println("questionDigits = " + questionDigits);
		
		Scanner stdIn = new Scanner(System.in);
		GuessHistory guessHistory = new GuessHistory();
		
		for(int guess = 123;guess <= 9876;guess++){
			Digits guessDigits = Digits.toDigits(guess);
			if(guessDigits == null)continue;
			if(!guessHistory.isConsistentWith(guessDigits))continue;
			
			Digits humanGuessDigits;
			do{
				System.out.print("‚ ‚È‚½‚Ì”ÔA„‘ª‚µ‚½”Žš—ñ? ");
				humanGuessDigits = Digits.toDigits(stdIn.nextInt());
			}while(humanGuessDigits == null);
			HitBlow humanHitBlow = humanGuessDigits.getHitBlow(questionDigits);
			System.out.println(humanHitBlow+" ‚Å‚·.");
			if(humanHitBlow.guessSuccessful()){
				System.out.println("‚ ‚È‚½‚ÌŸ‚¿‚Å‚·.");
				System.exit(0);
			}
			
			System.out.print("Ž„‚Ì”Ô."+guessDigits+" ‚Å‚·‚©?Hit‚Æblow‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢");
			int hit = stdIn.nextInt();
			int blow = stdIn.nextInt();
			HitBlow hitBlow = new HitBlow(hit,blow);
			if(hitBlow.guessSuccessful()){
				System.out.println("Ž„‚ÌŸ‚¿‚Å‚·.");
				System.exit(0);
			}
			guessHistory.add(guessDigits, hitBlow);
		}
		System.out.println("ðŒ‚É‡‚¤‰ð‚ª‚ ‚è‚Ü‚¹‚ñ.");
		stdIn.close();
	}

}
