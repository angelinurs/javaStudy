package hanbit_class2;

public class MemberInner {
	int a = 10;
	private int b = 100;
	static int c = 200;
	
	class Inner	{
		public void printData() {
			System.out.println( a );
			System.out.println( b );
			System.out.println( c );
		}
	}

	public static void main(String[] args) {
		MemberInner.Inner inner = new MemberInner().new Inner();
		
		inner.printData();
	}
}
