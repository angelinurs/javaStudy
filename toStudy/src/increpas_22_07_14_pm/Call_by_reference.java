package increpas_22_07_14_pm;

class Calling	{
	public Calling() {;}
	
	public void testValue( int value ) {
		value++;
	}
	
	public void testRefer( int[] arr )	{
		arr[0]++;
	}
}

public class Call_by_reference {

	public static void main(String[] args) {
		int value = 10;
		
		Calling ex = new Calling();
		
		ex.testValue( value );
		
		System.out.println( value );
		
		
		int[] ar = new int[1];
		
		ar[0] = 10;
		
		ex.testRefer( ar );
		
		System.out.println( ar[0] );
		
	}

}
