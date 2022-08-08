package increpas_22_08_01_am_Synchonized;

class RunnableTest implements Runnable {
	
	int type = 10;

	@Override public void run() {
		String name = Thread.currentThread().getName();
		
		while( true )	{
			synchronized ( this ) {
//				if( false )
					notify();
				
				type--;
				
				System.out.printf( "--[ %s ] 농심라면 : [ %d ]\n", name, type );
				
				try {
					wait();
					
					Thread.sleep( 500 );
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
};

public class RunnableTestMain {

	public static void main(String[] args) {
		RunnableTest rt = new RunnableTest();
		
		new Thread( rt, "Rt 1" ).start();
		new Thread( rt, "Rt 2" ).start();

	}

}