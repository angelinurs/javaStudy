package increpas_22_08_04_pm_IOStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author alex
 * @contents 문자 기반 스트림 활용
 *
 */
public class Buffered_ReadLine {
	
	// BufferedReader 를 이용한 line 으로 읽기
	public static void ex1() {
		// 키보드와 연결된 스트림 준비
		
		InputStream key = null;
		key = System.in;
		
		// bufferedReader 는 reader object 가 필요
		InputStreamReader isr = null;
		isr = new InputStreamReader( key );
		
		// 한줄 단위로처리하기 위한 처리
		BufferedReader br = null;
		br = new BufferedReader( isr );
		
		System.out.println( "Input : " );
		
		try {
			String line  = br.readLine();
			
			System.out.println( line );
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( isr != null ) isr.close();
				if( br != null ) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// BufferedReader 를 이용한 line 으로 file 읽기
	public static void ex2() {
		
		// BufferedReader 를 이용한 line 으로 file 읽기
		FileInputStream fis = null;
		BufferedReader br = null;
		
		try {
			fis = new FileInputStream( new File( "src/TEXT/readfile.txt" ) );
			br = new BufferedReader( new InputStreamReader( fis ) );
			
			String line = null;
			
			while( ( line = br.readLine() ) != null ) {
				System.out.println( line );
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if( br != null ) br.close();
					if( fis != null ) fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static void main(String[] args) {
		// BufferedReader 를 이용한 line 으로 읽기
//		ex1();
		
		// BufferedReader 를 이용한 line 으로 file 읽기
		ex2();

	}

}
