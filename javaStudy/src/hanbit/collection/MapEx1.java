package hanbit.collection;

import java.util.*;
import static java.lang.System.out;

public class MapEx1 {

	public static void main(String[] args) {
		String[] msg = { "Berlin", "Dortmund", "Frankfurt",
						 "Gelsenkirchen", "Hamburg" };
		HashMap< Integer, String > map = 
				new HashMap<Integer, String>(); 
		for( int i = 0; i < msg.length; i++ )
			map.put( i,  msg[i] );
		
		
		
		Set<Integer> keys = map.keySet();
		
		for( Integer key : keys )
			out.println( "key : " + key + ", value : " + map.get( key ) );
	}

}
