package dai22kai;

import java.util.Calendar;
import java.util.Scanner;

public class Mondai22A1 {
	
	public static String[] dayStr = {"Sun","Mon","Tue","Wed","Thi","Fri","Stu"};
	public static int[] maxDay = {31,28,31,30,31,30,31,31,30,31,30,31};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int year = scan.nextInt();
		int month = scan.nextInt();
		int max = maxDay[month-1];
		if(month == 2 && isUru(year)){
			max++;
		}
		for(int i = 0;i < 7;i++){
			System.out.printf(" "+dayStr[i]+" ");
		}
		System.out.println();
		int at = GetDayOfWeek(year,month,1);
		for(int i = 0;i < at;i++)System.out.print("     ");
		for(int i = 1;i <= max;i++){
			System.out.printf(" %2d  ",i);
			at++;
			if(at == 7){
				at = 0;
				System.out.println();
			}
		}
		scan.close();
	}
	
//	public static void main(String[] args){
//		Scanner scan = new Scanner(System.in);
//		int year = scan.nextInt();
//		int month = scan.nextInt();
//		int max = maxDay[month-1];
//		if(month == 2 && isUru(year)){
//			max++;
//		}
//		Calendar cal = Calendar.getInstance();
//	}
	
	public static boolean isUru(int year){
		if(year%400 == 0)return true;
		if(year%100 == 0)return false;
		if(year%4 == 0)return true;
		return false;
	}
	
	public static int // —j“ú”Ô† 0-6 —j“ú”Ô†i“ú‚OAŒŽ‚PA‰Î‚QA…‚RA–Ø‚SA‹à‚TA“y‚UA‚»‚Ì‘¼‚Vj‚ð•Ô‚·
	GetDayOfWeek
		(
			int year,  // ”N ¼—ï
			int month, // ŒŽ 1-12
			int day    // “ú 1-31
		)
	{
		// ‚PŒŽ ‚Æ ‚QŒŽ ‚ð‘O”N‚Ì 13ŒŽ ‚Æ 14ŒŽ ‚Æ‚µ‚Äˆµ‚¤
		if ( month <= 2 )
		{
			year  -= 1;
			month += 12;
		}

		// —j“ú”Ô†‚ð•Ô‚·
		return 
			(
				day
				+
				((8 + (13 * month)) / 5)
				+
				(year + (year / 4) - (year / 100) + (year / 400))
			)
			%
			7;
	}//GetDayOfWeek

}
