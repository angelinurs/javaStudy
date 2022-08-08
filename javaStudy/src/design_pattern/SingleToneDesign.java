package design_pattern;

class SingleTone	{
	private static SingleTone one;
	
	private SingleTone()	{}
	
	public static SingleTone getInstance()	{
		if( one == null )	{
			one = new SingleTone();
		}
		return one;
	}
}

public class SingleToneDesign {

	public static void main(String[] args) {
		SingleTone singleton1 = SingleTone.getInstance();
		SingleTone singleton2 = SingleTone.getInstance();
		
		System.out.println( singleton1 == singleton2 );
	}
}
