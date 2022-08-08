package hanbit_io;

import java.io.File;
import java.io.IOException;

public class FileEx {

	public static void main(String[] args) 
				throws IOException {
		String filePath = "c:\\";
		File file = new File( filePath );
		
		String[] list = file.list();
		
		for( int idx = 0; idx < list.length; idx++ )	{
			File file2 = new File( filePath, list[ idx ] );
			
			if( file2.isDirectory() ) {
				System.out.printf( "%s : directory\n", list[ idx ]);
			} else {
				System.out.printf( "%s : file ( %, dbyte)\n", list[ idx ], file2.length() );
				
			}
		}
		
		
	}

}
