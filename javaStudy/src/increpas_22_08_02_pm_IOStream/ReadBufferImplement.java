package increpas_22_08_02_pm_IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadBufferImplement {
	
	public static void main(String[] args) {
		String path = "src/TEXT/readfile.txt";
		
		File file = new File( path );
		FileInputStream fis = null;
		
		StringBuffer sb = new StringBuffer();
		
		try {
			
			fis = new FileInputStream( file );
			
			byte[] buf = new byte[ 2048 ];
			
			int readCount = 0;
			
			while( ( readCount = fis.read( buf ) ) != -1 ) {
//				sb.append( new String( buf ) );
				sb.append( new String( buf, 0, readCount ) );
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// fis read
			e.printStackTrace();
		} finally {
			
			try {
				if( fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println( sb.toString() );
	}
}
