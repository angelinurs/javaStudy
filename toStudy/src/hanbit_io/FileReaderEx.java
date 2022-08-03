package hanbit_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {

	public static void main(String[] args) {
		FileReader fr = null;
		
		try {
			fr = new FileReader( "src/text/readfile.txt" );
			int readChar;
			
			while( ( readChar = fr.read() ) != -1 ) {
				System.out.print( (char) readChar );
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if( fr != null ) fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
