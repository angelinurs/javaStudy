package hanbit_thread;

class MyRunnableOne implements Runnable {

	@Override
	public void run() {
		System.out.println( "run" );
		first();
		
	}
	
	public void first()	{
		System.out.println( "First" );
		second();
	}
	
	public void second()	{
		System.out.println( "Second" );
	}		
}

public class UncertainThreadEx {

	public static void main(String[] args) {
		System.out.println( "Main start" );
		
		Runnable r = new MyRunnableOne();
		Thread myThread = new Thread( r );
		
		myThread.start();
		
		System.out.println( "main end" );

	}
}
