package hanbit_io;

import java.io.IOException;

public class InputStreamEX {

	public static void main(String[] args) throws IOException {
		System.out.println( "Input : " );
		
		int _byte;
		
		while( ( _byte = System.in.read() ) != -1 ) {
			if( _byte == 'r' || _byte == '\n' ) continue;
			
			if( _byte == 'q' || _byte == 'Q' ) break;
			
			char c = (char) _byte;
			
			System.out.printf( "%s ( %d )\n", c, _byte );
		}

	}

}
