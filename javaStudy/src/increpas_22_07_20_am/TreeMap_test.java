package increpas_22_07_20_am;

import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMap_test {

	public static void main(String[] args) {
		TreeMap<String, Integer> map = new TreeMap<>();
		
		map.put("kiwi", 100 );
		map.put("kiwi", 200 );
		
		System.out.println( map.size() );
		System.out.println( map.get( "kiwi") );
		
		if( map.containsKey( "kiwi" ) ) {
			System.out.println( true );
		}
		map.put("alex", 300 );
		map.put("koalah", 400 );
		map.put("penguin", 500 );
		
		for( Entry<String, Integer> entry : map.entrySet() ) {
			System.out.println( entry.getKey() );
			System.out.println( entry.getValue() );
		}
		
		System.out.println( map );
		

	}

}
