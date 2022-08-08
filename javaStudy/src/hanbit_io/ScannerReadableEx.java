package hanbit_io;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScannerReadableEx {

	public static void main(String[] args) {

		FileReader fr = null;
		Scanner sc = null;
		
		try {
			
			fr = new FileReader( "src/TEXT/scan.txt" );
			
			sc = new Scanner( fr );
			
			while( sc.hasNextDouble() ) {
				System.out.printf( "Scan double : %,.2f \n", sc.nextDouble() );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
				try {
					if( fr != null ) fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				if( sc != null ) sc.close();
		}
	}
}
