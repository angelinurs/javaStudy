package hanbit_basic;

import java.util.StringTokenizer;
import static java.lang.System.out;

public class StringTokenizerEx {
	StringTokenizer st;
	
	public StringTokenizerEx(String str) {
		out.println("Str : " + str );
		st = new StringTokenizer( str );
	}
	
	public StringTokenizerEx(String str, String delim ) {
		out.println("Str : " + str );
		st = new StringTokenizer( str, delim );
	}
	
	public void print()	{
		out.println( "counts : " + st.countTokens() );
		
		while( st.hasMoreTokens() ) {
			String token = st.nextToken();
			out.println(token);
		}
		
		out.println("============");
	}

	public static void main(String[] args) {
		StringTokenizerEx st = new StringTokenizerEx("Happy Day");
		
		st.print();
		
		StringTokenizerEx st_another = new StringTokenizerEx("08-07-22", "-");
		
		st_another.print();
	}
}
