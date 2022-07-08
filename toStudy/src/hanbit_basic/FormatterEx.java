package hanbit_basic;

import java.util.Formatter;
import static java.lang.System.out;

public class FormatterEx {

	public static void main(String[] args) {
		Formatter f = new Formatter();
		
		f.format("%1$b, %3$h, %2$5s", false, 500, 'A');
		
		out.println( f.toString() );

	}

}
