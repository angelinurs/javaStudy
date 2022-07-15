package increpas_22_07_14_pm;

public class ObjectString {

	public static void main(String[] args) {
		String s1 = new String("increpas");
		String s2 = new String("increpas");
		
		System.out.println( ( s1 == s2 )? "true" : "false" );
		System.out.println( s1.equals(s2)? "true" : "false" );
		
		String s3 = "increpas";
		String s4 = "increpas";
		
		System.out.println( ( s3 == s4 )? "true" : "false" );
		System.out.println( s3.equals(s4)? "true" : "false" );
		
		String s5 = new String("JAVA");
		String s6 = new String("Java");
		
		System.out.println( ( s5 == s6 )? "true" : "false" );
		System.out.println( s5.equals(s6)? "true" : "false" );
		System.out.println( s5.equalsIgnoreCase(s6)? "true" : "false" );
		
		System.out.println( s6.indexOf( 'v' ) );
		
		System.out.println( s6.length() );
		
		System.out.println( s5.startsWith("Ja")? "true" : "false" );
		
		System.out.println( s5.toLowerCase().startsWith( "Ja".toLowerCase() )? "true" : "false" );
		
		System.out.println( s5.substring(1, 3) );
		System.out.println( s5.substring(1) );
		
		String s7 = "    java     ";
		
		System.out.printf( "[%s]\n", s7 );
		System.out.printf( "[%s]\n", s7.trim() );
	}

}
