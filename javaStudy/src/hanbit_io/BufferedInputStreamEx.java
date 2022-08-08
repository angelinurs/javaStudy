package hanbit_io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamEx {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		BufferedInputStream bis = null;
		
		try {
			
			fis = new FileInputStream( "c:\\Test\\bufferIn.txt" );
			bis = new BufferedInputStream( fis );
			
			int readByte = 0;
			
			while( ( readByte = bis.read() ) != -1 ) {
				System.out.print( (char)readByte );
			}
			
		} catch ( IOException ioe ) {
			ioe.printStackTrace();
		} finally {
			
			try {
				if( fis != null ) fis.close();
				if( bis != null ) bis.close();
				
			} catch (  IOException ioe ) {
				
				ioe.printStackTrace();
			}
			
		}
	}

}
