package hanbit_io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEX {

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		
		byte[] _read = new byte[ 100 ];
		byte[] consol = new byte[ 100 ];
		
		try {
			System.out.println( "Filename : " );
			System.in.read( consol );
			
			String file = new String( consol ).trim();
			
			fis = new FileInputStream( file );
			
			fis.read( _read, 0, _read.length );
			
			System.out.println( new String( _read ).trim() );
			
		} catch ( FileNotFoundException fnfe ) {
			fnfe.printStackTrace();
		} catch ( IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if( fis != null ) fis.close();
			} catch ( IOException ioe )	{
				ioe.printStackTrace();
			}
		}
	}

}
