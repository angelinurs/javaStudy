package hanbit_basic;

import static java.lang.System.out;

public class VarTest {
	public void argTest( String ... n)	{
		for( int idx = 0; idx < n.length; idx++ ) {
			out.println( "n["+idx+"] -> "+ n[ idx ] );
		}
		out.println("--------------------");
	}

	public static void main(String[] args) {
		VarTest vt = new VarTest();
		
		vt.argTest("JAVA", "JSP");
		
		vt.argTest("100", "200", "300");
	}

}
