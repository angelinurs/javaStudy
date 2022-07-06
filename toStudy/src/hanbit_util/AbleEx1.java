package hanbit_util;

import java.util.*;
import static java.lang.System.out;

public class AbleEx1 {

	public static void main(String[] args) {
		Vector<Able> v = new Vector<Able>(2, 5);
		
		Able a1 = new Able( "B123", 90, 75, 70 ); 
		Able a2 = new Able( "T123", 60, 75, 70 );
		Able a3 = new Able( "Z123", 90, 55, 70 );
		Able a4 = new Able( "V123", 33, 75, 70 );
		
		v.addElement(a1);
		v.addElement(a2);
		v.addElement(a3);
		v.addElement(a4);
		
		out.println("----------- before -------");
		
		for( Able al : v)
			out.println( al.empno + ", " + al.getTotal());
		
		Able[] a = new Able[ v.size() ];
		
		v.copyInto(a);
		AbleComp comp = new AbleComp();
		
		Arrays.sort( a, comp );

		out.println("----------- after -------");
		
		for( Able al : a )
			out.println( al.empno + ", " + al.getTotal());

		out.println("----------- after 2. -------");
		
		Vector<Able> new_v = new Vector<Able>( Arrays.asList(a) );
		
		for( Able al : new_v)
			out.println( al.empno + ", " + al.getTotal());

	}

}
