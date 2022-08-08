package hanbit_generic;

public class GenericMain<T> {
	
	T v;
	
	public GenericMain( T n ) { v = n; }

	public T get() { return v; }

	public void set(T v) { this.v = v; }

	public static void main(String[] args) {
		
		// 교재내용
		GenericMain<?> g = new GenericMain<String>( "String Object" );
		
		/*
		 * <?> 와이드 카드를 선언시에 사용하면
		 * 특정 class type이 아닌 Object 로 선언되므로,
		 * 다른 Object 타입으로 바인딩이 가능하나, 
		 * 사용시 type casting 을 해주어야 한다.
		 */
		String s = (String) g.get();
		
		System.out.println( "g result : " + s );
		
		GenericMain<?> g2 = new GenericMain<Integer>(10000);

		System.out.println( "g2 result : " + g2.get().toString() );
		
		// ?
		GenericMain<String> c = new GenericMain<>( "String Object C" );
		
		/* 
		 * 선언시에 class type 을 직접 명시했으므로 
		 * 사용시에 type casting 을 안해주어도 된다.
		 */
		String s2 = c.get();
		
		System.out.println( "c result : " + s2 );
		
		GenericMain<Integer> c2 = new GenericMain<>(10000);
		
		System.out.println( "c2 result : " + c2.get().toString() );
		
	}

}
