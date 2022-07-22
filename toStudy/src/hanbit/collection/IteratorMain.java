package hanbit.collection;

import java.util.Iterator;
import java.util.Vector;

public class IteratorMain {

	public static void main(String[] args) {
		Vector<String> v = new Vector<>( 2, 5 );
		
		v.add( "kii" );
		v.add( "son" );
		v.add( "koo" );
		
		System.out.println( v.size() );
		
		Iterator<String> it = v.iterator();
		
		while( it.hasNext() ) {
			String temp = it.next();
			System.out.println( temp );
			
			// 원본 컬랙션에서 요소 삭제
			it.remove(); 
		}
		
		System.out.println( v.size() );
		System.out.println( v.toString() );
	}

}
