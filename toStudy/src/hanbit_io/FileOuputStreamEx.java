package hanbit_io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOuputStreamEx {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = null;
		
		try {
			File f = new File( "c:\\Test" );
			
			if( !f.exists() )
				f.mkdirs();
			
			fos = new FileOutputStream( "c:\\Test\\fileout.txt" );
			
			String msg = "Hello, FileOutputStream!!";
			
			fos.write( msg.getBytes() );
			
		} catch ( FileNotFoundException fnfe ) {
			fnfe.printStackTrace();
		} catch ( IOException ioe) {
			ioe.printStackTrace();
		} finally {
			
			try {
				if(  fos != null ) fos.close();
			} catch ( IOException ioe ) {
				ioe.printStackTrace();
			}
		}
		
		// read and check
		
		File file = new File( "c:\\Test\\fileout.txt" );
		FileInputStream fis = new FileInputStream( file );
		BufferedInputStream bis = new BufferedInputStream( fis );
		
		int b;
		
		while( ( b = bis.read() ) != -1 )	{
			System.out.printf( "%c", (char)b );
		}
		System.out.println();

	}

}
