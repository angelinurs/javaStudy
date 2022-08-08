package increpas_22_08_02_pm_IOStream;

import java.io.File;
import java.io.FileInputStream;

public class ReadBufferImplement_Throw_Exception {
	
	public static void main(String[] args) throws Exception {
		String path = "src/TEXT/readfile.txt";
		
		File file = new File( path );
		FileInputStream fis = null;
		
		StringBuffer sb = new StringBuffer();
		
		fis = new FileInputStream( file );
		
		byte[] buf = new byte[ 2048 ];
		
		int readCount = 0;

		// Throw Exception
		
		while( ( readCount = fis.read( buf ) ) != -1 ) {
//				sb.append( new String( buf ) );
			sb.append( new String( buf, 0, readCount ) );
		}
		
		if( fis != null) fis.close();
		
		System.out.println( sb.toString() );
	}
}
