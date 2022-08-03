package hanbit_io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterEx {

	public static void main(String[] args) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter( "src/text/fileWriter_buffered_test.txt" );
			bw = new BufferedWriter( fw );
			
			bw.write( "메롱." );
			bw.newLine();
			bw.write( "메롱." );
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( bw != null ) bw.close();
				if( fw != null ) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
