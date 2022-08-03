package hanbit_io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {

	public static void main(String[] args) {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter( "src/text/fileWriterTest.txt" );
			
			fw.write( "File Writer test." );
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( fw != null ) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
