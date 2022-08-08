package increpas_22_07_08_pm;

import static java.lang.System.out;

public class ArrayEx {

	public static void main(String[] args) {
		// declare and binding
		long[] arr = new long[4];
		
		// assign value
		for( int idx = 0; idx < arr.length; idx++ )
			arr[ idx ] = (arr.length - idx)*100;
		
		// print each element
		for( int idx = arr.length-1; idx >= 0; idx-- )
			out.print( arr[ idx ] + " " );
		out.println();
		
		// declare and binding
		StringBuffer sb = new StringBuffer();
		
		// append String buffer
		for( long i : arr )
			sb.append( String.valueOf( i ) + " " );
		
		// print String buffer
		out.println( sb.toString() );
	}
}
