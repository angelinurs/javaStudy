package increpas_22_07_18_am;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class GenericTypeCollectionAsArrayList {

	public static void main(String[] args) {
		
		// Case 1. ArrayList to List 1		
		ArrayList<String> st = new ArrayList<>();
		
		st.add( "kim" );
		
		List<String> list = st;
		
		System.out.println( list.get(0) );
		
		// Case 2. ArrayList to List 2
		List<String> temp = new ArrayList<>();
		
		temp.add( "lee" );
		
		System.out.println( temp.get(0) );
		
		// Case 3. ArrayList to Object 1
		Object origin = new ArrayList<>();
		
		System.out.println( origin.toString() );
		
		st.add( "Alex" );
		
		// Case 4. ArrayList to Object 2
		Object obj = st;
		
		System.out.println( obj );
		
		Vector<String> vc = new Vector<>();
		
		vc.add( "kim" );
		vc.add( "pak" );
		
		List listMap =  vc;
		
		System.out.println( listMap.toString() );
		
		Object objVector = vc;
		
		System.out.println( objVector );
	}
}
