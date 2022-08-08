package hanbit_generic;

public class GenericMain2<T> {
	
	T v;
	
	public GenericMain2( ) { }
	public GenericMain2( T n ) { v = n; }

	public T get() { return v; }

	public void set(T v) { this.v = v; }

	public static void main(String[] args) {
		
		// 교재내용
		GenericMain2<?> g = new GenericMain2<String>();
		
		g.set( "Sting Object." );
		
		String s = (String) g.get();
		
		System.out.println( "g result : " + s );
	}

}
