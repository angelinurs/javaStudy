package hanbit_class2;

interface TestInter	{
	int data = 10000;
	public void printData();
}

public class AnonyInner {
	
	public void test()	{
		new TestInter() {
			
			@Override
			public void printData() {
				System.out.println( "data : " + data );
			}
		}.printData();
	}

	public static void main(String[] args) {
		AnonyInner ai = new AnonyInner();
		ai.test();
	}
}
