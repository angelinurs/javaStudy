package hanbit_class2;

public class StasticInner {
	
	int a = 10;
	private int b = 100;
	static int c = 200;
	
	static class Inner {
		
		static int d = 1000;
		
		public void printData() {
			System.out.println( "static int c : " + c );
			System.out.println( "static int d : " + d );
			/*
			 * static 으로 선언된 클래스는 저장 영역이 static 에 잡힌다.
			 * static 으로 선언된 변수에 접근 하기위한 클래스를 만들기 위해서는 static 으로 선언된 클래스를 사용해야만한다.
			 * static 으로 선언된 클래스는 inner class 라 할지라도 top level 이므로,
			 * outer class 를 생성하지 않고 단독으로 생성가능하다. 
			 */
//			System.out.println( "private int b : " + b );
//			System.out.println( "int a : " + a );
		}
	}

	public static void main(String[] args) {
//		StasticInner.Inner inner = new StasticInner.Inner();
//		inner.printData();
		
		// 
		Inner inner = new Inner();
		inner.printData();
	}

}
