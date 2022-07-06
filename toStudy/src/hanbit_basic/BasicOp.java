package hanbit_basic;

import static java.lang.System.out;

public class BasicOp {
	public static void show(String st) {
		out.println();
		out.println( "==============" );
		out.println( st + " op ex" );
		out.println( "==============" );
		
	}

	public static void main(String[] args) {
		show("basic");
		
		out.println( "2 + 5 = " + ( 2 + 5 ) );
		out.println( "13 + 89 = " + ( 13 + 89 ) );
		out.println( "34 - 20 = " + ( 34 - 20 ) );
		out.println( "45 - 90 = " + ( 45 - 90 ) );
		out.println( "2 + 5 = " + ( 2 + 5 ) );
		out.println( "2 + 5 = " + ( 2 + 5 ) );
		out.println( "2 + 5 = " + ( 2 + 5 ) );
		out.println( "2 + 5 = " + ( 2 + 5 ) );
		out.println( "2 + 5 = " + ( 2 + 5 ) );
		
		show( "increase" );
		int x = 5;
		
		out.println( "x = " + x );
		out.println( "x/2 + ++x = " + ( x/2 + ++x ));
		
		x = 5;
		out.println( "-x + x++ = " + ( -x + x++ ));
		
		x = 5;
		out.println( "x + ++x + x = " + ( x + ++x + x ));
		
		show("logical");
		
		int a = 10, b = 7;
		
		int c = a&b;
		int d = a|b;
		int e = a^b;
		
		out.println("a AND b -> " + c + ", byte ->" + (byte)c );
		out.println("a OR b -> " + d + ", byte ->" + (byte)d );
		out.println("a XOR b -> " + e + ", byte ->" + (byte)e );
		
		out.println();
		out.println( "==============" );
		out.println( "bitwise op ex" );
		out.println( "==============" );
		
		int i, j, k = 3;
		
		i = 10;
		j = 11;
		
		out.println( "i : " + i + ", j : " + j + ", k : " + k);
		
		if( i <  j ) out.println("i <  j");
		if( i <= j ) out.println("i <= j");
		if( i != j ) out.println("i != j");
		if( i == j ) out.println("not");
		if( i >= j ) out.println("not");
		if( i >  j ) out.println("not");

		boolean boo;
		boo = i<j && j<k;
		out.println("\n i<j && j<k : "+boo);
		
		boo = i==j || j<k && j>k;
		out.println(" i==j || j<k && j>k : "+boo); 
		out.println();
		
		byte value = 1;
		
		value = (byte)( value + 1 );
		
		out.println( value );
		
		// ternary 
		show( "ternary");
		
		int size = 31;
		
		for( int n = 1; n <= size; n++ )
			out.print( n + (( n % 5 == 0 || n == size ) ? "\n" :
							( n < 10 )                  ? "  " : " " ) );		
		out.println();
		
		// increase / decrease op
		show("increase / decrease op");
		
		int pre = 10, post = 20;
		
		out.println("pre = " + pre + ", post = " + post );
		out.println("++pre = " + ++pre );
		out.println("++pre + post++ = " + (++pre + post++) );
		out.println("(++pre%3) + ( pre*++post) = " + ((++pre%3) + ( pre*++post)) );
		
	}

}
