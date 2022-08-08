package hanbit_util;

import java.util.Arrays;
import static java.lang.System.out;

public class ArraysEx1 {
	
	public static void arraysTest1( String[] ar )	{
		out.println("-------------------");
		Arrays.fill(ar, "Hana" );
		for( String st : ar )
			out.print( st + ", ");		
		out.println();
		
		out.println("-------------------");
		
		Arrays.fill(ar,  1, 3, "*" );
		for( String st : ar )
			out.print( st + ", ");		
		out.println();
	}
	public static void arraysTest2( String[] ar1, String[] ar2 )	{
		if( !Arrays.equals(ar1,  ar2))
			out.println( "not same");
		
		Arrays.fill( ar2, 2, 3, "the");
		
		if( !Arrays.equals(ar1,  ar2))
			out.println( "not same");
		else
			out.println( "same" );		
	}

	public static void main(String[] args) {
		String[] ar = { "fill()", "in", "the", "Arrays" };
		
//		arraysTest1( ar );
		
		String[] ar1 = { "fill()", "in", "", "Arrays" };
		
//		arraysTest2( ar, ar1 );
		
		
	}

}
