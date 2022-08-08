package hanbit_basic;

public class TypeCheckAndVargs {
	
	public static void checkType( Object...vargs )	{
		for( int idx = 0; idx < vargs.length; idx++ ) {
			System.out.println( vargs[ idx ] );
		}
		System.out.println(vargs.getClass().getName() );
	}

	public static void main(String[] args) {
		
		checkType( 1, 2, 3 );

	}

}
