package hanbit_network;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class URLConnectionEx {

	public static void main(String[] args) {
//		String  address = "https://docs.oracle.com/javase/8/docs/api";
		String  address = "https://www.daum.net";
		
		URL url = null;
		URLConnection urlCon = null;
		try {
			url = new URL( address );
			
			urlCon = url.openConnection();
			
			urlCon.connect();
			
			Map< String, List< String > > map = urlCon.getHeaderFields();
			
			Set< String > s = map.keySet();
			
			Iterator< String > it = s.iterator();
			
			while( it.hasNext() ) {
				String name = it.next();
				System.out.print( name + " : ");
				
				List< String > value = map.get( name );
				for( String tmp : value ) {
					System.out.println( "-\t" + tmp );
				}
				
			}
			int len = urlCon.getContentLength();
			System.out.println( "length of context : " + len + " bytes." );
			
			if( len > 0 ) {
				InputStream is = urlCon.getInputStream();
				int readByte;
				
				System.out.println( "========== context =============");
				while( ( readByte = is.read() ) != -1 && ( --len > 0 ) ) {
					System.out.print( (char) readByte );
				}
				is.close();
			} else {
				System.out.println( "There is no context" );
			}
				
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
