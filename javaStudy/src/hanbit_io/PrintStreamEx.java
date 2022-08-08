package hanbit_io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamEx {

	public static void main(String[] args) {
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		PrintStream ps = null;
		
		try {
			fos = new FileOutputStream( "c:\\test\\printStream.txt" );
			bos = new BufferedOutputStream( fos );
			ps = new PrintStream( fos, true );
			
			ps.print( "Hong-gil-dong" );
			ps.print( 1234 );
			ps.print( true );
			ps.print( 'a' );
			
		} catch ( IOException ioe) {
			ioe.printStackTrace();
		} finally {
			
			try {
				if( fos != null ) fos.close();
				if( bos != null ) bos.close();
				if( ps != null ) ps.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}