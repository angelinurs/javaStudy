package hanbit_io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderEx {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader( "src/text/readfile.txt" );
			br = new BufferedReader( fr );
			
			String msg;
			
			while( ( msg = br.readLine() ) != null ) {
				System.out.println( msg );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( br != null ) br.close();
				if( fr != null ) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
