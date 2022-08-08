package hanbit_class;

import java.util.StringTokenizer;

public class String_Split_String_Tokenizer {

	public static void main(String[] args) {
		System.out.println( "# Split Test # =============");
		
		String date = "2005/08//15/";
		String[] sp = date.split( "/" );
		
		for( String st : sp )	{
			System.out.println( st );
		}
		
		System.out.println( "# String Tokenizer Test # =============");
		
		StringTokenizer st = new StringTokenizer( date, "/" );
		
		while( st.hasMoreElements() )
			System.out.println( st.nextToken() );
		
	}

}
