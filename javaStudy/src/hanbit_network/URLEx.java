package hanbit_network;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URLEx {

	public static void main(String[] args) {
		try {
			URL url = new URL( "https", 
							   "search.daum.net", 
							   443, 
							   "search?q=강남+날씨" );
//			URL url = new URL( "https", "java.sun.com", 443, 
//								"index.jsp?name=syh1011#content" );
			
			String protocol = url.getProtocol();
			String host = url.getHost();
			int port = url.getPort();
			int defaultPort = url.getDefaultPort();
			
			String path = url.getPath();
			String query = url.getQuery();
			String ref = url.getRef();
			String _url = url.toExternalForm();
			
			String mixUrl = null;
			
			if( port == -1 ) {
				mixUrl = protocol + "://" + host + "/" +
						path + "?" + query + "#" + ref;
			} else {
				mixUrl = protocol + "://" + host + ":" + port + "/" +
						path + "?" + query + "#" + ref;
			}
			
			if( port == -1 ) {
				port = url.getDefaultPort();
			}
			
			System.out.printf( "protocol : %s %n", protocol );
			System.out.printf( "host : %s %n", host );
			System.out.printf( "port : %s %n", port );
			System.out.printf( "path : %s %n", path );
			System.out.printf( "query : %s %n", query );
			System.out.printf( "ref : %s %n", ref );
			System.out.printf( "mixURL : %s %n", mixUrl );
			System.out.printf( "URL : %s %n", _url );
			
			url = new URL( mixUrl );
			
			InputStream is = null; 
			try {
				is = url.openStream();
				int readByte;
				
				System.out.println( "=== context ===" );
				
				while( ( readByte = is.read() ) != -1 ) {
					System.out.print( (char) readByte );
				}
				
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				try {
					if( is != null ) is.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		}

	}

}
