package increpas_22_07_18_am;

import java.util.HashMap;

public class GenericTypeCollectionAsHashMap {

	public static void main(String[] args) {
		HashMap< String, Integer > map = new HashMap<>();
		
		System.out.println( map.size() );
		
		map.put( "k1", 100 );
		map.put( "k2", 200 );
		map.put( "k3", 300 );

		System.out.println( map.size() );
		
		System.out.println( map.get( "k3" ) );
		
		System.out.println( map.keySet() );
		
		System.out.println( map.values() );
		
		for( String key : map.keySet() )	{
			System.out.printf( "%s key -> %d value\n", key, map.get( key ));
		}
		
		String number = "15";
		System.out.println( number.hashCode() );
		
		String name = "kim";
		System.out.println( name.hashCode() );
	}
}
