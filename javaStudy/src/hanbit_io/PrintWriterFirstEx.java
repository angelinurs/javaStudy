package hanbit_io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterFirstEx {

	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter( "src/text/printWriterFirst_test.txt" );
			bw = new BufferedWriter( fw );
			pw = new PrintWriter( bw, true );
			
			pw.println( "안녕하세요." );
			pw.println( 1000 );
			pw.println( new Integer( "1000" ) );
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if( pw != null ) pw.close();
					if( bw != null ) bw.close();
					if( fw != null ) fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
