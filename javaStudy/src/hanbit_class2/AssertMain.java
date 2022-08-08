package hanbit_class2;

public class AssertMain {
	
	public static void assertEx() {
		String st = "";
		
		assert st.length() > 0 : "have no arguments";
		
		System.out.println( st );
	}
	
	public static void assertEx2() {
		AssertMain am = new AssertMain();
		
		try	{
			am.gugu( 10 );
		} catch( Exception e )	{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		assertEx();
//		assertEx2();
		
	}
	
	public void gugu( int dan ) {
		assert dan > 1 && dan < 10 : "input 2~9.";
		
		System.out.println( dan + " dan" );
		System.out.println( "-------------------------------" );
		
		StringBuffer sb = new StringBuffer();
		
		for( int idx = 0; idx < 9; idx++ )	{
			sb.delete(0, sb.length() );
			sb.append( dan ).append( " * " );
			sb.append( idx + 1).append( " = ");
			sb.append( dan * ( idx + 1 ) );
			
			System.out.println( sb.toString() );
		}
	}
}
