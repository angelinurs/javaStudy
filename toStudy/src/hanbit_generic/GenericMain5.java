package hanbit_generic;

class GGen1	{
	
	String msg = "Gen";
	
	public String getMsg() { return msg; }
}

class GGen2	extends GGen1 {
	String msg = "Gen2";
	
	public String getMsg() { return msg; }
}

class GGen3	extends GGen2 {
	String msg = "Gen3";
	
	public String getMsg() { return msg; }
}

public class GenericMain5<T> {
	
	T v;
	
	public GenericMain5( T v )	{ this.v = v; }

	/**
	 * @return the v
	 */
	public T getV() { return v; }

	/**
	 * @param v the v to set
	 */
	public void setV(T v) { this.v = v; }

	public static void main(String[] args) {
		GGen3 g3 = new GGen3();
		
		GenericMain5< ? extends GGen2> g5 = new GenericMain5< GGen3 >( g3 );
		
		GGen2 test = g5.getV();
		
		// 하위 호환
//		Gen3 test2 = g5.getV();
		
		System.out.println( "Result of g5 : "+ test.msg + " , "+ test.getMsg() );
	}

}
