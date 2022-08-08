package hanbit_io;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerURLConnectionEx {

	public static void main(String[] args) {
		
		String url = "http://www.oracle.com/";
		
		URLConnection urlCon = null;
		Scanner sc = null;
		
		try {
			urlCon = new URL( url ).openConnection();
			
			sc = new Scanner( urlCon.getInputStream() );
			sc.useDelimiter( "\\Z" );
			
			String text = sc.next();
			
			System.out.println( text );
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch ( NoSuchElementException nsee){
			
			nsee.printStackTrace();
		} finally {
			
			if( sc != null )  sc.close();
		}
	}
}
