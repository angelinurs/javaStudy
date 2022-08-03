package increpas_22_08_02_pm_IOStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileSaveMain {
	
	// Stream 을 console 로 화면에 출력하기
	public static void consoleStream() {
		
		String text = "대한민국 화이딭 !! ";
		
		// 모니터 콘솔에 연결된 스트림 준비하기
		PrintStream ps = System.out;
		
		// 쓰기할 문자열을 byte[] 로 변환해야 쓰기할 수 있다.
		byte[] bytes = text.getBytes();
		
//		ps.writeBytes( bytes );
		
		ps.write(bytes, 0,  bytes.length );
		ps.flush();
		
	}
	
	// stream 을 file 로 저장하기
	public static void fileOutputStreamTest() {
		
		// 저장할 파일 이름
		String path = "src/TEXT/writeTest.txt";
		
		// 파일에 쓰기할 내용
		String text = "대한민국 화이딩 !!";
		
		File file = new File( path );
		
		if( file.exists() ) {
			System.out.println( file + " 은 현재 존재합니다." );
			return;
		}
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream( file );
			
			fos.write( text.getBytes() );
//			fos.write( text.getBytes(), 0, text.getBytes().length );
			
			// 기존 FileOutputStream 에 있던 buffer 내용을 지운다.
			fos.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if( fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// stream 을 file 로 저장하기
	public static void bufferedOutputStreamTest() {
		
		// 저장할 파일 이름
		String path = "src/TEXT/writeBufferedTest.txt";
		
		// 파일에 쓰기할 내용
		String text = "대한민국 화이딩 !!";
		
		File file = new File( path );
		
		if( file.exists() ) {
			System.out.println( file + " 은 현재 존재합니다." );
			return;
		}
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream( file );
			
			bos = new BufferedOutputStream( fos );
			
			bos.write( text.getBytes() );
//			bos.write( text.getBytes(), 0, text.getBytes().length );
			
			// 기존 FileOutputStream 에 있던 buffer 내용을 지운다.
			fos.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if( bos != null) bos.close();
				if( fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		// Stream 을 console 로 화면에 출력하기
//		consoleStream();
		
		// stream 을 file 로 저장하기
//		fileOutputStreamTest();
		
		bufferedOutputStreamTest();
		
	}
}
