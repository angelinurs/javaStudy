package hanbit_class;

public class StaticInner {
	int a = 10;
	private int b = 100;
	static int c = 200;
	
	static class Inner	{
		static int d = 1000;
		
		public void printData()	{
			// static inner class 의 경우에는 static 으로 선언된 variable 만 접근 가능하다.
//			System.out.println( "int a : " + a );
//			System.out.println( "private int b : " + b );
			System.out.println( "static int c : " + c );
			System.out.println( "static int d : " + d );
		}
	}

	public static void main(String[] args) {
		// case 01.
		StaticInner.Inner inner = new StaticInner.Inner();
		
		inner.printData();
		// case 02.
//		Inner inner = new Inner();
//		inner.printData();

	}

}
