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
	
	public static int // 曜日番号 0-6 曜日番号（日０、月１、火２、水３、木４、金５、土６、その他７）を返す
	GetDayOfWeek
		(
			int year,  // 年 西暦
			int month, // 月 1-12
			int day    // 日 1-31
		)
	{
		// １月 と ２月 を前年の 13月 と 14月 として扱う
		if ( month <= 2 )
		{
			year  -= 1;
			month += 12;
		}

		// 曜日番号を返す
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
