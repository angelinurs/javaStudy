package hanbit_basic;

import static java.lang.System.out;

public class CastOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("(int)(7.9) = " + (int)(7.9));
		
		out.println("(int)(3.9) = " + (int)(3.9));
		
		out.println("(int)( 7.8 + (double)( 15 / 2 )) = " 
					+ (int)( 7.8 + (double)( 15 / 2 )));
		
		out.println("15 / 2 = " + 15 / 2); // -> int
		
		out.println("(int)( 7.8 + ( (double)15 / 2 )) = " 
					+ (int)( 7.8 + ( (double)15 / 2 )));

	}

}
