package increpas_22_08_04_pm_IOStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PostZipCode_ReadLine {
	
	String[] cities = { "강원도", "경기도", 
						"경상남도", "경상북도",
						"광주광역시", "대구광역시" };

	public static void main(String[] args) {
		String city = "서울특별시";
		String path = String.format( "src/ZIPCODE_DB/%s.txt", city );
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader( new FileReader( new File( path ) ) );
			
			String line = null;
			
			while( ( line = br.readLine() ) != null ) {
				
				// 메타문자 ( ?, +, (, ), [, ], {, }, | } -> regex 특수문자
				// `\\` 사용해서 escape 함.
				String[] tokens =  line.split( "\\|" );
				
//				System.out.println( Arrays.toString( tokens ) );
				System.out.println( tokens[ 8 ] );
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if( br != null ) br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
