package hanbit_class2;

public class LocalInner {
	
	int a = 100;
	
	public void innerTest( int k ) {
		int b = 200;
		final int c = k;
		
		class Inner	{
			public void getData()	{
				System.out.println( "Int a : " + a );
				
				System.out.println( "Int b : " + b );
				System.out.println( "Final Int c : " + c );
			}
		}
		Inner i = new Inner();
		i.getData();
	}

	public static void main(String[] args) {
		
		LocalInner outer = new LocalInner();
		outer.innerTest( 1000 );
	}
}
