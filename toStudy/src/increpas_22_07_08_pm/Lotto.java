package increpas_22_07_08_pm;

import java.text.DecimalFormat;

/*
 * mkLotto number
 */
class LottoMachine {
	int[] numbers;
	boolean dup;
	
	public LottoMachine()	{		
		dup = false;
	}
	
	public void insert( int price )	{
		if( price < 1000 )	{
			System.out.println( "** 결재 금액이 부족합니다. **" );
		} else {
			System.out.println( "== 구매 해주셔서 감사합니다. ==" );
//			System.out.printf( "- 결재 후 잔액 -> [ %s 원 ]\n", price - 1000 );
			// comma seperate version.
			System.out.printf( "- 결재 후 잔액 -> [ %s 원 ]\n", this.moneyCount( price - 1000 ) );
			this.setNumbers();
			
			System.out.print( "- 추첨번호 -> " );
			this.print_numbers();
		}
	}
	
	// Case 1. 
	// - Traditional logic
	public String moneyCount( int money )	{
		String str = String.valueOf( money );
		String buffer = "";
		
		for( int idx = str.length() - 1; idx >= 0; idx-- )	{
			if(    idx < str.length() -1 
			    && idx % 3 == 0 
			    && ( idx <= str.length() / 3 * 3 ) ) {
				
				buffer = "," + buffer;
			}

			buffer = str.charAt(idx) + buffer;
		}
		System.out.println( buffer );
		
		return buffer;
	}
	
	// Case 2.
	// - Use class
	public void moneyCount2( int money )	{
		
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println( df.format(money) );
		
	}
	
	public void setNumbers() {
		numbers = new int[6];
		numbers[ 0 ] = (int)( Math.random() * 45 + 1);
		
		for( int idx = 1; idx < numbers.length;  )	{
			
			int ball = (int)( Math.random() * 45 + 1 );
			
			for( int jdx = 0; jdx < idx; jdx++  ) {
				if ( numbers[ jdx ] == ball )	{
					dup = true;
					break;
				}
			}
			
			if( dup ) dup = false;
			else numbers[ idx++ ] = ball;
		}
	}
	
	public int[] getNumbers() { return numbers; }
	
	public void print_numbers()	{
		for( int num : this.getNumbers() )
			System.out.printf( "%-3d", num );
		System.out.println();
	}
};

public class Lotto {

	public static void main(String[] args) {
		LottoMachine number = new LottoMachine();
		
		number.insert( 1000 );
		System.out.println();
		
		number.insert( 990 );
		System.out.println();
		
		number.insert( 5000 );
		System.out.println();
	}

}
