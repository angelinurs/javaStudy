package hanbit_util;

import java.util.*;
import static java.lang.System.out;

class Able {
	String empno;
	int net, ejb, xml, total;
	
	public Able( int total ) { this.total = total; }
	
	public Able( String no, int n, int e, int x ) {
		this.empno = no;
		this.net = n;
		this.ejb = e;
		this.xml = x;
		
		this.total = n + e + x;
	}
	public int getTotal() { return this.total; }

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append( "empno : " ).append( empno );
		sb.append( ", net : " ).append( net );
		sb.append( ", ejb : " ).append( ejb );
		sb.append( ", xml : " ).append( xml );
		sb.append( "\n" );
		
		
		return sb.toString(); 
	}
}

class AbleComp implements Comparator<Able> {

	@Override
	public int compare(Able o1, Able o2) {
		int var = 0;
		
		var = ( o1.getTotal() > o2.getTotal() ) ?  1 : 
			  ( o1.getTotal() < o2.getTotal() ) ? -1 : 0;
		
		return var;
	}

}

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
		
		int index = Arrays.binarySearch(a, new Able( 235 ), comp );
		
		System.out.println( "240 이 검색된 index : " + index );
		System.out.println( new_v.get( index ) );

	}

}
