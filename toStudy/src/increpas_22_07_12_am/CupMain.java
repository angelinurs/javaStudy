package increpas_22_07_12_am;

import java.text.DecimalFormat;

public class CupMain {

	public static void main(String[] args) {
		Cup mug = new Cup("name", 350, "Whlite", 1000 );
		
		System.out.println( mug.toString() );
		
		int price = mug.getPrice();
		DecimalFormat df = new  DecimalFormat( "0,000" );
		
		System.out.printf( "price : %s\n", df.format( price ) );
		
		final int size = 10;
		Cup[] cups = new Cup[ size ];
		
		for( int idx = 0; idx < cups.length; idx++ )
			cups[ idx ] = new Cup();
	}
}
