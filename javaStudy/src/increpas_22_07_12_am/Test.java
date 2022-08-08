package increpas_22_07_12_am;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Test {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3 };
		
		System.out.println( Arrays.toString( ar ));
		
		Scanner sc = new Scanner( System.in );
		
		sc.findInLine("(\\d+) (\\d+) (\\d+)");
		
		MatchResult result = sc.match();
		
		System.out.println( result.groupCount() );
		
		if( result.groupCount() != 3 )	{
			System.out.println( "not match number count");
			System.out.println( "retry 3 number");
		}
		
		if( sc.hasNext() )
			System.out.println("T");
		else
			System.out.println("F");
	}

}
