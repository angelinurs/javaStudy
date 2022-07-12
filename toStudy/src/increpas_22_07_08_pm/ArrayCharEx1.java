package increpas_22_07_08_pm;

import static java.lang.System.out;

public class ArrayCharEx1 {
	
	public static void main(String[] args) {

		/* ==============================================================================
		 * Array at char
		 * 
		 * 1. array name is on stack
		 * 2. array value is on heap
		 * ==============================================================================
		 */
		char[] ar1 = new char[3];
		
		// array name is vm memory id ( not address )
		out.println( "array name value -> " + ar1 );
		
		for( int idx = 0; idx < ar1.length; idx++ ) {
			out.println( ar1[ idx ] + "_");
			
		}
		
		for( char ch : ar1 ) {
			out.printf( "[%c]_\n", ch );
		}
		
		for( int idx = 0, start = 'A'; idx < ar1.length; ar1[ idx++ ] = (char) (start++) );

		for( char ch : ar1 ) {
			out.printf( "[%c]_\n", ch );
		}
		out.println();
		
		/* ============================================================================== 
		 * Array at String
		 * 
		 * 1. array name is on stack
		 * 2. array value is 'null' on heap
		 * ==============================================================================
		 */
		String[] ar2 = new String[3];
		
		for( int idx = 0; idx < ar2.length; ar2[ idx ] = "문자열_"+ ++idx  );
		
		for( String str : ar2 ) {
			out.printf( "[%s]\n", str );
		}
		
		
	}

}
