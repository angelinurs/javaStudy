package hanbit_util;

import java.util.Random;
import static java.lang.System.out;

public class RandomEx1 {

	public static void main(String[] args) {
		String[] lesson = {"java", "jsp", "xml/java", "ejb"};
		
		Random r1 = new Random();
		
		int index = r1.nextInt( lesson.length );
		
		out.println( lesson[ index ] );

	}

}
