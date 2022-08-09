package hanbit_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class StreamTokenizerEx {
	final static String path = "src/TEXT/streamToken.txt";

	public static void main(String[] args) {
		
		// wrtie file 
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		// raad file
		BufferedReader br = null;
		StreamTokenizer st = null;
		
		try {
			// write file
			fw = new FileWriter( path );
			bw = new BufferedWriter( fw );
			pw = new PrintWriter( bw, true );
			
			pw.println( 10000 );
			pw.println( "안녕하세요." );
			pw.println( "kiwi@korea.com" );
			pw.println( "I am a sealion" );
			pw.println( "~!@#" );
			
			// read file
			br = new BufferedReader( new FileReader( path ) );
			st = new StreamTokenizer( br );
			
			while( st.nextToken() != StreamTokenizer.TT_EOF ) {
				
				switch( st.ttype ) {
				
					case StreamTokenizer.TT_WORD :
						System.out.println( "Word -> " + st.sval );
						break;
						
					case StreamTokenizer.TT_NUMBER :
						System.out.println( "Number -> " + (int) st.nval );
						break;
						
					default :
						System.out.println( "No word, No number -> " + (char) st.ttype );
						break;
				}
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
				try {
					if( fw != null ) fw.close();
					if( bw != null ) bw.close();
					if( pw != null ) pw.close();
					if( br != null ) br.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
		}
	}
}
