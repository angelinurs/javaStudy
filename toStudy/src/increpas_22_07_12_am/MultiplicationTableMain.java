package increpas_22_07_12_am;

import java.util.Scanner;

public class MultiplicationTableMain {

	public static void main(String[] args) {
		new MultiplicationTable( 1 );
		
		Scanner sc = new Scanner( System.in );
		
		System.out.println( "원하는 단을 입력하세요."  );		
		new MultiplicationTable( sc.nextInt() );
	}
}
