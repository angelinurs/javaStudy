package increpas_22_07_14_pm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class ObjectStringBuffer {

	public static void main(String[] args) {
		String s1 = "TEST";
		
		String s2 = s1.concat( "1234" );
		
		System.out.printf( "Address is -> %s \n", ( s1 == s2 )? "same": "not same" );
		System.out.printf( "value is -> %s \n", ( s1.equals(s2) )? "same": "not same" );
		System.out.printf( "%s, %s \n", s1, s2 );
		
		System.out.println();
		
		StringBuffer sb1 = new StringBuffer( "TEST" );
		StringBuffer sb2 = sb1.append( "1234" );
		
		System.out.printf( "Address is -> %s \n", ( sb1 == sb2 )? "same": "not same" );
		System.out.printf( "value is -> %s \n", ( sb1.equals(sb2) )? "same": "not same" );
		System.out.printf( "%s, %s \n", sb1, sb2 );
		System.out.printf( "%s, %s \n", sb1.toString(), sb2.toString() );
	}

}
