package hanbit_class;

import static java.lang.System.out;

public class OverloadingGetLength {
	public int getLength( int i ) {
		String st = String.valueOf(i);
		
		return getLength( st );
	}
	
	public int getLength( float f ) {
		String st = String.valueOf(f);
		
		return getLength( st );
	}
	
	private int getLength( String st ) {
		return st.length();
	}

	public static void main(String[] args) {
		OverloadingGetLength ot = new OverloadingGetLength();
		
		out.println( 1000 + " -> " + ot.getLength(1000) );
		out.println( 3.14f + " -> " + ot.getLength(3.14f) );
		out.println( "10000" + " -> " + ot.getLength("10000") );

	}

}
