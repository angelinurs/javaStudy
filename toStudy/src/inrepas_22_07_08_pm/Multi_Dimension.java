package inrepas_22_07_08_pm;

import static java.lang.System.out;

public class Multi_Dimension {
	
	// 1 dimension exercize
	public static void mkOneDimension()	{
		int[] ar = new int[4];
		
		for( int idx = 0; idx < ar.length; ar[idx] = ++idx *10 );
		
		for( int a : ar ) out.println(a);
	}
	
	// 1 dimension with Object exercize
	public static void mkOneDimension_object()	{
		String[] ar = new String[3];
		
		for( int idx = 0; idx < ar.length; idx++ )	{
//			ar[ idx ] = Integer.toString( ( idx+1 ) *10 );
			ar[ idx ] = String.valueOf( ( idx+1 ) *10 );
		}
		
		for( String st : ar ) out.println( st );
	}

	public static void main(String[] args) {
		
		int[] ar1 = new int[3];
		int[] ar2 = new int[3];
		int[] ar3 = new int[3];
		
		// 2차원 배열은 저장한 1 차원 배열이 몇개인가가 중요함.
		int[][] ar4 = new int[3][3];
		
		outer : for( int idx = 0; idx < ar4.length; idx++ )	{
			inner : for( int jdx = 0; jdx < ar4[ idx ].length; jdx++ ) {
				out.printf( "%3d", ar4[ idx ][ jdx ] );
			}
			out.println();
		}
		
		ar4[ 0 ] = ar1;
		ar4[ 1 ] = ar2;
		ar4[ 2 ] = ar3;
		
		// 1 dimension exercize
		mkOneDimension();
		
		// 1 dimension with Object exercize
		mkOneDimension_object();
		
	}

}
