package hanbit_basic;

// compare ./SystemReadReadLine.java

import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class NumericScanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		out.println(" input decimal" );		
		int x = sc.nextInt();
		out.println(" number is : " + x );
		
		out.println();
		
		out.println(" input float" );		
		double d = sc.nextDouble();
		out.println(" number is : " + d );
		
		String st = new String();
		
		st = sc.next();
		
		out.println( st );
		
		
	}

}
