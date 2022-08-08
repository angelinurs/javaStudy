package hanbit_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InOutStreamReaderEx {
	public static String consoleInput( String input ) {
		
		System.out.print( input + " : " );
		
		InputStreamReader isr = null; 
		BufferedReader br = null;
		
		isr = new InputStreamReader( System.in );
		br = new BufferedReader( isr );
		
		String msg = null;
		try {
			msg = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		// System.in 은 임의 생성 객체가 아닌, 표준 객체 ( 표준 입력 -> 키보드 ) 이므로
		// System.in 객체의 reference 를 받은 InputStreamReader 를 종료하면,
		// reference 된 System.in 도 종료 되어 이후에 새롭게 생성된 method 에서도
		// System.in 객체를 reference 할 수 없게 된다.
//		finally {
//				try {
//					if( br != null ) br.close();
//					if( isr != null ) isr.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//		}
		
		return msg;
	}

	public static void main(String[] args) {
		String id = consoleInput( " id " );
		
		String passwd = consoleInput( " passWord : " );
		
		OutputStreamWriter out = null;
		
		out = new OutputStreamWriter( System.out );
		
		try {
			out.write( "id : " + id + ", password : " + passwd );
//			out.write( passwd );
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if( out != null ) out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
