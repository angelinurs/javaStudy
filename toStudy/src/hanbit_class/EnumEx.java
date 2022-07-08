package hanbit_class;

public class EnumEx {
	public enum Lesson	{
		JAVA, XML, EJB
	}
	public enum Item	{
		Add, Del, Search, Cancel
	}
	
	public static void testEnum() {
		Lesson le = Lesson.JAVA;
		
		System.out.println("Lesson : " + le);
		System.out.println("XML : " + Lesson.XML);
	}

	public static void main(String[] args) {
//		testEnum();
		Item a1 = Item.Search;
		
		if( a1 instanceof Object ) {
			System.out.println( a1.toString() );
			System.out.println( "OK!! instanceof Object" );
			System.out.println( "stored real value : " + a1.ordinal() );
		}
		
		System.out.println( "==========================" );
		
		Item[] items = Item.values();
		
		System.out.println( "Items length : " + items.length );
		
		for( Item val : items ) {
			System.out.println( val + " : " + val.ordinal() );
		}
		
		
		
	}

}
