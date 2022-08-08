package hanbit_io;

import java.util.Scanner;

public class ScannerRegEx {

	public static void main(String[] args) {
		
		String text = "1 and 2 and animal and lion and tiger";
		
		Scanner sc = new Scanner( text );
		
		sc = sc.useDelimiter( "\\s*and\\s*" );
		
		int firstToken = sc.nextInt();
		int secondToken = sc.nextInt();
		String thirdToken = sc.next();
		String fourthToken = sc.next();
		String fifthToken = sc.next();
		
		System.out.printf( "%d, %d, %s, %s, %s\n", firstToken, secondToken, thirdToken, fourthToken, fifthToken );
		
		sc.close();
	}

}
