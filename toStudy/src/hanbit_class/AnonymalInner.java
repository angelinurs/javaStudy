package hanbit_class;

abstract class TestAbst	{
	int data = 10000;
	public abstract void printData();
};

public class AnonymalInner {
	
	// class inner 부분에서 미구현된 method printData 를 anonymous 로 구현함.
	TestAbst inn = new TestAbst()	{
		public void printData()	{
			System.out.println("data -> " + data );
		}
	};

	public static void main(String[] args) {
		AnonymalInner ai = new AnonymalInner();
		
		ai.inn.printData();
	}
}