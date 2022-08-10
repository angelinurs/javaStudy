package hanbit_io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx {

	public static void main(String[] args) {
		RandomAccessFile ra = null;
		
		try {
			ra = new RandomAccessFile( "./kiwi/random.txt", "rw" );
			
			// prepare write data
			String receive = "hello";
			
			// get file size
			System.out.println( ra.length() );
			// move end of file data
			ra.seek( ra.length() );
			// write data at end of file
			ra.write( receive.getBytes() );
			
			// prepare byte buffer
			// size is file size that it is present byte
			byte[] buf = new byte[ (int) ra.length() ];
			
			// mvoe first of file
			ra.seek( 0 );
			// read file data to byte buffer
			ra.read( buf );
			
			System.out.print( "Reading Data at first : " );
			System.out.println( new String( buf ) );
			
			// mvoe first of file
			ra.seek( 0 );
			// read file data to byte buffer
			ra.read( buf );
			
			System.out.print( "Reading data again : ");
			System.out.println( new String( buf ) );
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
				try {
					if( ra != null ) ra.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
		}

	}

}
