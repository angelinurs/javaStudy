package increpas_22_07_20_am;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Hashset_to_Iterator {
	
	// 정렬이 필요할 경우 HashSet 대신 TreeSet 쓴다.
	public static String treeSet_iterator() {
		TreeSet<Integer> ts = new TreeSet<>();
		
		while( ts.size() < 6 )	{
			ts.add( (int)( Math.random() * 45 + 1 ) );
		}
		
		ArrayList<Integer> ar = new ArrayList<>();
		
		Iterator<Integer> it = ts.iterator();
		
		while( it.hasNext() ) {
			int n = it.next();
			ar.add( n );
		}
		
		return ar.toString();
	}
	
	public static String createLotto() {
		HashSet<Integer> lottos = new HashSet<>();
		ArrayList<Integer> ar = new ArrayList<>();
		
		while( lottos.size() < 6 )	{
			lottos.add( (int)( Math.random() * 45 + 1 ) );
		}
		
		Iterator<Integer> it = lottos.iterator();
		
		while( it.hasNext() ) {
			int n = it.next();
			ar.add( n );
		}
		
//		ar.sort(null);
		return ar.toString();
	}
	
	public static void manualHashSet() {
		HashSet<Integer> hs = new HashSet<>();
		
		hs.add( 40 );
		hs.add( 1 );
		hs.add( 23 );
		hs.add( 9 );
		
		Iterator<Integer> it = hs.iterator();
		
		while( it.hasNext() ) {
			int n = it.next();
			System.out.println( n );
		}
		
	}
	
	public static void main( String[] args ) {
		HashSet<Integer> s1 = new HashSet<>();
		
		while( s1.size() < 3 )	{
			s1.add( (int)( Math.random() * 9 + 1 ) );
		}
		
		System.out.println( "s1.size() : " + s1.toString() );
		
		Iterator<Integer> it = s1.iterator();
		
		while( it.hasNext() ) {
			int n = it.next();
			System.out.println( n );
		}
		
		System.out.println( createLotto() );
		System.out.println( treeSet_iterator() );
		
		manualHashSet();
	}
}
