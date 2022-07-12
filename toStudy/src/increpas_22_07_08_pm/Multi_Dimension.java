package increpas_22_07_08_pm;

import static java.lang.System.out;

import java.util.Scanner;

public class Multi_Dimension {
	
	// 1 dimension exercize
	public static void mkOneDimension()	{
		int[] ar = new int[4];
		
		for( int idx = 0; idx < ar.length; ar[idx] = ++idx *10 );
		
		for( int a : ar ) out.println(a);
		
		out.println();
	}
	
	// 1 dimension with Object exercize
	public static void mkOneDimension_object()	{
		String[] ar = new String[3];
		
		for( int idx = 0; idx < ar.length; idx++ )	{
//			ar[ idx ] = Integer.toString( ( idx+1 ) *10 );
			ar[ idx ] = String.valueOf( ( idx+1 ) *10 );
		}
		
		for( String st : ar ) out.println( st );
		
		out.println();
	}
	
	public static void mkTwoDimension()	{
		int[][] ar = new int[2][4];
		
		outer : for( int idx = 0; idx < ar.length; idx++ ) {
					ar[ idx ] = new int[4];
			inner : for( int jdx = 0; jdx < ar[idx].length; jdx++ ) {
						ar[ idx ][ jdx ] = idx * 4 + 1 + jdx;
			}
		}
		
		outloop : for( int[] arr : ar )
			innerloop : for( int digit : arr )
							out.println( digit );
		
		out.println();
	}
	
	/* ***********************
	 * solve 1. assign value like below lines
	 * 1 0 0 0 
	 * 0 1 0 0 
	 * 0 0 1 0 
	 * 0 0 0 1 
	 * ***********************
	 */
	public static void mkTwoDimension_pic()	{
		int[][] ar = new int[4][4];
		
		outer : for( int idx = 0; idx < ar.length; idx++ ) {
					ar[ idx ] = new int[4];
			inner : for( int jdx = 0; jdx < ar[idx].length; jdx++ ) {
						if( idx == jdx )
							ar[ idx ][ jdx ] = 1;
			}
		}
		
		outloop : for( int[] arr : ar ) {
			innerloop : for( int digit : arr )	{
							out.printf( "%-2d", digit );
			}
			out.println();
		}
		
		out.println();
		
	}

	/* ***********************
	 * solve 2. assign random array value
	 * ***********************
	 */
	public static void randomArrayValue() {
		int[][] ar = new int[4][4];
		
		outer : for( int idx = 0; idx < ar.length; idx++ ) {
					ar[ idx ] = new int[4];
			inner : for( int jdx = 0; jdx < ar[idx].length; jdx++ ) {
						ar[ idx ][ jdx ] = (int)( Math.random() * 8 );
			}
		}
		
		outloop : for( int[] arr : ar ) {
			innerloop : for( int digit : arr )	{
							out.printf( "%-2d", digit );
			}
			out.println();
		}
		
		out.println();
		
	}
	
	public static void randomTest() {
		int score = (int)( Math.random() * 101 );
		
		String label = ( score > 80 ) ? "하산" :		
					   ( score >= 60 && score <= 80 ) ? "우수" : "탈락";
		
		out.printf("score -> %d, Label -> %s\n", score, label);
		
		out.println();
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
		
		mkTwoDimension();
		
		/* ***********************
		 * solve 1. assign value like below lines
		 * 1 0 0 0 
		 * 0 1 0 0 
		 * 0 0 1 0 
		 * 0 0 0 1 
		 * ***********************
		 */
		mkTwoDimension_pic();
		/* ***********************
		 * solve 2. assign random array value
		 * ***********************
		 */
		randomArrayValue();
		
		randomTest();
	}

}
