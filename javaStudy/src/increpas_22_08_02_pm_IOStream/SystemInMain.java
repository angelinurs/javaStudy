package increpas_22_08_02_pm_IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class SystemInMain {
	
	public static void ex_1() {
		
		// 키보드와 연결괸 스트림 객체 binding
		InputStream key = System.in;
		
		System.out.println( "Input :" );
		
		try {
			
			// InputStream method 를 사용할때는 반드시 
			// exception handling 해야함.
			// - 읿력을 못 받을 경우 상정해야함.
			int data = key.read();
			
			System.out.println( ( char ) data );
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	// 지정된 임의 글자수만 읽어오기
	public static void ex_2() {
		
		InputStream key = System.in;
		
		System.out.println( "Input :" );
		
		try {
			
			int count = 0;
			while( true ) {
				if( count++ == 3 ) break;
				
				int data = key.read();
				
				System.out.println( ( char ) data );
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	// file 을 읽어보기
	public static void ex_3() {
		
//		String path = "c:\\Test\\readfile.txt";
		String path = "src/TEXT/readfile.txt";
		
		File file = new File( path );
		
		// 아래의 코드는 try catch 에서 처리가 되었으므로,
		// 생략 가능.
		if( file.exists() && file.isFile() ) {
			
			// refer to java.io.FileInputStream
			
			FileInputStream fis = null;
			try {
				
				fis = new FileInputStream( file );
				
				// fis 에서 더이상 읽을 것이 없다면,
				// default value 를 -1 로 지정.
				int data = -1;
				while( ( data = fis.read() ) != -1 ) {
//					System.out.print( (char) data );
					// 한글 단위를 읽어야할때.
					System.out.write( data );
				}
				
			} catch ( FileNotFoundException fnfe ) {
				fnfe.printStackTrace();
			} catch ( IOException ioe) {
				ioe.printStackTrace();
			} finally {
				
				try {
					if( fis != null ) fis.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		
	}

	public static void main(String[] args) {
		
		// 키보드와 연결된 스트림 객체 활용하기
//		ex_1();
		
		// 지정된 임의 글자수만 읽어오기
//		ex_2();
		
		// file 을 읽어보기
		// 한글과 같은 문자 데이터 그대로 읽기.
		ex_3();
	}

}
