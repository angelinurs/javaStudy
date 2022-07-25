package increpas_22_07_25_am;

import java.util.Scanner;

public class ExceptMain2 {
	
	public void test( int a, int b ) {
		int result = 0;
		
		try {
			result = a / b;
			System.out.println( "Not occured Error." );
			return; // 제어권을 호출한 곳으로 돌려보낸다.
		} catch (Exception e) {
			 b = 1;
			 result = a / b;
			 System.out.println( "Modify b value by 1.");
		} finally {
			System.out.println( "Done." );
		}
		
		System.out.println( result );
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner( System.in );
		
		int pre, post;
		int result = 0;
		
		System.out.println( "First number : " );
		pre = sc.nextInt();
		
		System.out.println( "Second number : " );
		post = sc.nextInt();
		
		// Case 1.
//		try {
//			result = pre / post;
//			
//			System.out.println( "에러 발생 없음." );
//		} catch ( Exception e ) {
//			if( post == 0 )	{
//				post = 1;
//			}
//			result = pre / post;
////			e.printStackTrace();
//		} finally {
//			System.out.println( "Done." );
//		}
//		
//		System.out.println( result );
		
		// Case 2.
		ExceptMain2 ex = new ExceptMain2();
		
		ex.test( pre, post );
		
	}
}
