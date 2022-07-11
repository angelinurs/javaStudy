package inrepas_22_07_08_pm;
/*
 * mkLotto number
 */

public class LottoEx6 {

	public static void main(String[] args) {
		int[] lotto = new int[6];
		boolean dup = false;
		
		// setter
		lotto[ 0 ] = (int)( Math.random() * 46 );
		
		for( int idx = 1; idx < lotto.length;  )	{
			
			int ball = (int)( Math.random() * 45 + 1 );
			
			for( int jdx = 0; jdx < idx; jdx++  ) {
				if ( lotto[ jdx ] == ball )	{
					dup = true;					
					break;
				}
			}
			
			if( dup ) dup = false;
			else lotto[ idx++ ] = ball;
		}
		
		// viewer
		for( int digit : lotto )
			System.out.println( digit );
	}

}
