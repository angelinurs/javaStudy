package hanbit_class;

public class EnumEx3 {
	
	public enum Item	{
		Add( 5 ), Del( 11 ), Search( 2 ), Cancel( 22 );
		
		// 내부에서 스스로 constructing 을 하기 때문에 값이 binding 된다.
		private final int var;
		
		Item( int v )	{ var = v; }
		public int getVar()	{ return var; }
	}

	public static void main(String[] args) {
		for( Item n : Item.values() ) {
			System.out.println( n + " : " + n.getVar() );
		}
	}

}
