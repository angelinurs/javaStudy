package increpas_22_07_18_am;

public class GenericTypeMain {

	public static void main(String[] args) {
		
		// Case 1. String type
		GenericType<String> gtString = new GenericType<>();
		
		gtString.setValue( "100" );
		
		System.out.println( gtString.getValue() );		
		System.out.println( gtString.getValue().getClass().getName() );		
		
		// Case 2. Integer type
		GenericType<Integer> gtInteger = new GenericType<>();
		
		gtInteger.setValue( 100 );
		
		System.out.println( gtInteger.getValue() );
		System.out.println( gtInteger.getValue().getClass().getName() );
		
		// Case 3. Generic type test 1
		GenericType obj = new GenericType();
		
		obj.setValue( 100 );
		
		System.out.println( obj.getValue() );
		System.out.println( obj.getValue().getClass().getName() );
		
		// Case 4. Generic type test 2
		GenericType obj_2 = new GenericType();
		
		obj_2.setValue( "100" );
		
		System.out.println( obj_2.getValue() );
		System.out.println( obj_2.getValue().getClass().getName() );
	}

}
