package hanbit_class;

public class StaticInitialize_2 {
	
	int a = 100;
	static int b = 200;
	
	static {
		b = 5000;
		c = 10000;
	}

	public static void main(String[] args) {
				
//		System.out.println( a );
		System.out.println( b );
		System.out.println( c );
		
		StaticInitialize_2 st = new StaticInitialize_2();
		
		System.out.println( st.a );
	}
	
	static int c;

}
