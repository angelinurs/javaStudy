package hanbit_basic;

import java.util.Scanner;
import static java.lang.System.out;

public class Control_Flow {
	
	public static void switchTest() {
		Scanner sc = new Scanner(System.in);
		
		out.println( "input month" );
		
		int month;
		month = sc.nextInt();
		
		switch( month ) {
			case 12: case 1: case 2: 
				out.println(month + " is Winter");
				break;
			case 3: case 4: case 5: 
				out.println(month + " is Spring");
				break;
			case 6: case 7: case 8: 
				out.println(month + " is Summer");
				break;
			case 9: case 10: case 11: 
				out.println(month + " is Autumn");
				break;
			default: 
				out.println(month + " is wrong");
		}		
	}
	
	public static void nobodyWhile()	{
		int pre = 100, post = 200;
		
		while( ++pre < --post );
		
		out.printf("pre = %d, post = %d\n", pre, post );
	}
	
	public static void nestedWhile()	{
		int pre = 1, post;
		
		while( pre <= 9 )	{
			post = 2;
			while( post <=9 )	{
				out.printf( "%d * %d = %s%d ", 
						post, pre, ( ( pre * post < 10 ) ? " ": ""  ), pre*post  );
				++post;
			}
			++pre;
			out.println();
		}
	}
	
	public static void continueLabel()	{
		final int size = 10;
		outer: for( int idx = 0; idx < size; idx++ )	{
			inner: for( int jdx = 0; jdx < size; jdx++ ) {
				if( jdx > idx )	{
					out.println();
					continue outer;
				}
				out.print( " " + ( idx * jdx ) );
			}
		}
		out.println();
	}
	
	public static void diffDimension2dArray()	{
		// declare 2d array
		int twoArr[][] = new int[4][];
		
		// binding second array
		for( int idx = 0; idx < twoArr.length; idx++ ) {
			twoArr[idx] = new int[idx+1];
		}
		
		// assign value
		int val = 0;
		for( int idx = 0; idx < twoArr.length; idx++ ) {
			for( int jdx = 0; jdx < twoArr[idx].length; jdx++ ) {
				twoArr[idx][jdx] = val++;
			}
		}
		
		// view array's value
		for( int idx = 0; idx < twoArr.length; idx++ ) {
			for( int jdx = 0; jdx < twoArr[idx].length; jdx++ ) {
				out.printf("%d ", twoArr[idx][jdx]);
			}
			out.println();
		}
	}
	
	public static void ArgsElement(String[] args)	{
		StringBuffer sb = new StringBuffer();
		
		for( String arg : args )
			sb.append( arg ).append( " " );
		
		out.println( sb.toString() );
	}

	public static void main(String[] args) {
//		switchTest();
//		nobodyWhile();
//		nestedWhile();
//		continueLabel();
//		diffDimension2dArray();
		ArgsElement( args );
		
	}

}
