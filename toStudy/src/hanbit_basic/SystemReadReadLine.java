package hanbit_basic;

import java.io.*;

//compare ./NumericScanner.java

public class SystemReadReadLine {

	public static void main(String[] args) 
			throws java.io.IOException {
		int i;
		char ch;
		
		System.out.println("input digit and character > ");
		
		i = System.in.read() - 48;
		
		ch = (char)System.in.read();
		
		System.out.println("input digit : " + i);
		System.out.println("input character : " + ch);
		System.out.println( );
		
		ch = (char)System.in.read();
		
		BufferedReader in  = new BufferedReader( new InputStreamReader( System.in ) );
		
		String enter1 = in.readLine();
		
		System.out.println("Input name -> ");
		String name = in.readLine();
		System.out.println("Inputed name -> " + name );
		System.out.println();

	}

}
