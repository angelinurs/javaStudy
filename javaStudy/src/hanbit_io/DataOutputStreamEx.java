package hanbit_io;

import java.io.*;

public class DataOutputStreamEx {

	public static void main(String[] args) {
		
		FileInputStream  fis = null;
		DataInputStream  dis = null;
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			
			fos = new FileOutputStream( "c:\\Test\\dataOut.txt" );
			dos = new DataOutputStream( fos );
			
			dos.writeBoolean( false );
			dos.writeInt( 20000 );
			dos.writeChar( 'T' );
			dos.writeDouble( 290.45 );
			
			fis = new FileInputStream( "c:\\Test\\dataOut.txt" );
			dis = new DataInputStream( fis );
			
			System.out.println( dis.readBoolean() );
			System.out.println( dis.readInt() );
			System.out.println( dis.readChar() );
			System.out.println( dis.readDouble() );
			
		} catch ( IOException ioe) {
			ioe.printStackTrace();
		} finally {
			
			try {
				
				if( fis != null ) fis.close();
				if( dis != null ) dis.close();
				if( fos != null ) fos.close();
				if( dos != null ) dos.close();
				
			} catch ( IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
