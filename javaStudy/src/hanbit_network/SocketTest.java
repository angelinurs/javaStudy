package hanbit_network;

import java.io.IOException;
import java.net.Socket;

public class SocketTest {
	static public String ip = "192.168.0.58";
	
	static public void doScan() { 
		Socket s = null; 
		for (int i = 1; i < 65536; i++) { 
			try { 
				s = new Socket(ip, i);
				System.out.println( i + " 번 포트가 사용중입니다" );
			} catch (IOException e) { 
				System.out.println( i + " 번 포트를 사용하지 않습니다." );
			} 
		} 
	}

	public static void main(String[] args) {
		doScan();
	}
}
