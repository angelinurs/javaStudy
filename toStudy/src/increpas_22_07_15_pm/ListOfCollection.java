package increpas_22_07_15_pm;

import java.util.ArrayList;
import java.util.Vector;

public class ListOfCollection {

	public static void main(String[] args) {
		// List, Set, Map

		// list 는 가변적 길이를 가짐.
		Vector<String> list1 = new Vector<>();
		
		list1.add( "Merong" );
		list1.add( "Merong" );
		list1.add( "Merong" );
		
		System.out.println( "list1.size() -> " + list1.size() );
		System.out.println( list1.firstElement() );
		
		list1.add( "Merong1" );
		list1.add( "Merong" );
		list1.add( "Merong" );
		System.out.println( "list1.size() -> " + list1.size() );
		
		list1.removeElement( "Merong1" );
		System.out.println( "list1.size() -> " + list1.size() );
		
		System.out.println( list1.get( list1.size() -1 ) );
//		System.out.println( list1.get(5) );
		
		for( int idx = 0; idx < list1.size(); idx++ )	{
			System.out.println( list1.get(idx));
		}
		
		ArrayList<String> list2 = new ArrayList<>();
		
		list2.add( "A1" );
		list2.add( "A2" );
		list2.add( "A3" );
		
		// Vector 와 ArrayList 는 
		// 같은 list interface 를 구현하여 호환이 가능함.
		list1.addAll( list2 );
		
		for( String temp : list1 )	{
			System.out.println( temp );
		}
	}
}
