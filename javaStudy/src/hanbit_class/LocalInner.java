package hanbit_class;

public class LocalInner {
	int a = 100;
	
	public void innerTest( int k )	{
		int b = 200;
		final int c = k;
		
		// static int d = 300; // static variable 은 사용불가
		
		class inner {
			public void getData()	{
				System.out.println( "int a : " + a );
				System.out.println( "int b : " + b );
				System.out.println( "final int c : " + c );
			}
		}
		inner i = new inner();
		i.getData();
	}

	public static void main(String[] args) {
		LocalInner li = new LocalInner();
		li.innerTest(1000);

	}

}
