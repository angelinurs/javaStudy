package hanbit_class;

public class StaticInitialize {
	static {
		System.out.println( "Static init_1" );
	}
	
	static String s = echo( "String" );
	
	static {
		System.out.println( "Static init_2" );
	}
	
	static String echo( String s ){
		System.out.println( "Static init" );
		
		return s;
	}

	public static void main(String[] args) {
		
		System.out.println( "main" );
		
		StaticInitialize st = new StaticInitialize();
		
		System.out.println( s );
	}

}
