package increpas_22_07_18_am;

interface Inter1	{
	public int getA();
}

interface Inter2	{
	public int getA();
}

interface Inter3 extends Inter1, Inter2	{
	public int getData();
}

public class InterfaceEx implements Inter3 {
	
	int a = 100;
	
	public int getA()	{
		return a;
	}
	
	public int getData()	{
		return a + 10;
	}

	public static void main(String[] args) {
		InterfaceEx it = new InterfaceEx();
		
		Inter1 it1 = it;
		Inter2 it2 = it;
		Inter3 it3 = it;
		
		System.out.println( it1.getA() );
		System.out.println( it2.getA() );
		System.out.println( it3.getA() );
		System.out.println( it3.getData() );
		System.out.println( it.toString() );
	}
}
