package hanbit_generic;

class Gen	{
	
	String msg = "Gen";
	
	public String genMsg() { return msg; }
}

class Gen2	extends Gen {
	String msg = "Gen2";
	
	public String genMsg() { return msg; }
}

class Gen3	extends Gen2 {
	String msg = "Gen3";
	
	public String genMsg() { return msg; }
}

public class GenericMain4<T> {
	T v;
	
	public GenericMain4( T t ) { v = t; }

	/**
	 * @return the v
	 */
	public T getV() { return v; }

	/**
	 * @param v the v to set
	 */
	public void setV(T v) { this.v = v; }

	public static void main(String[] args) {
		Gen3 g3 = new Gen3();
		
		GenericMain4<? super Gen2 > g4 = new GenericMain4<Gen>( g3 );
		
		Gen3 test = (Gen3) g4.getV();
		// error
//		Gen3 test2 = g4.getV();
		
		System.out.println( "Result of g4 : " + test.msg + ", " + test.genMsg() );
	}

}
