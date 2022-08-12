package hanbit_network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx {

	public static void main(String[] args) {
		InetAddress iaddr = null;
		
		try {
			iaddr =  InetAddress.getLocalHost();
			
			System.out.printf( "Host name : %s %n", iaddr.getHostName() );			
			System.out.printf( "Host IP address : %s %n", iaddr.getHostAddress() );
			
			iaddr = InetAddress.getByName( "java.sun.com" );
			
			System.out.printf( "Host name : %s %n", iaddr.getHostName() );
			System.out.printf( "Host IP address : %s %n", iaddr.getHostAddress() );
			
			InetAddress sw[] = InetAddress.getAllByName( "www.naver.com" );
			
			if( sw != null) {
				if( sw.length != 0 ) {
					for( InetAddress tmp : sw ) {
						System.out.printf( "Host name : %s %n", tmp.getHostName() );
						System.out.printf( "Host IP address : %s %n", tmp.getHostAddress() );
					}
				}
			}
			
		} catch (UnknownHostException ukhe) {
			ukhe.printStackTrace();
		} 
	}

}
