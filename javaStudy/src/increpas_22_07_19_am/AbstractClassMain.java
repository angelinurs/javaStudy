package increpas_22_07_19_am;

abstract class AbstractClass {
	int value;

	public int getValue() { return value; }

	public void setValue(int value) { this.value = value; }

	public abstract void print( String msg );
};

public class AbstractClassMain extends AbstractClass{

	// Case 2. inheritance
	@Override
	public void print(String msg) {
		
		// value 는 abstract class 에서 가지고 있는 맴버 변수
		System.out.println( "abstract inheritance : " + msg );
		System.out.println( "value : " + super.getValue() );
	}
	
	public static void output( AbstractClass abc ) {
		System.out.print( "output !!  " );
	}

	public static void main(String[] args) {
		
		// Case 1. anonyInner
		new AbstractClass() {

			@Override
			public void print(String msg) {
				setValue( 20 );
				System.out.println( "abstract AnonyInner : " + msg );
				System.out.println( "value : " + getValue() );
			}
			
		}.print( "merong" );
		
		// Case 2. inheritance - 1
		new AbstractClassMain().print( "1 - uhaha" );
		
		// Case 2. inheritance -2 
		AbstractClassMain abcMain = new AbstractClassMain();
		abcMain.print("2 - uhaha" );
		
		// Case 3. binding abstract class variable
		AbstractClass abc = new AbstractClassMain();
		abc.print( "abstract binding" );
		
		
		// Another Case 1. binding abstract class variable
		output( new AbstractClassMain() );
	}

}
