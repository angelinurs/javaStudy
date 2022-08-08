package hanbit_thread;

public class SingleRunnableEx implements Runnable {
	private int[] temp;
	
	public SingleRunnableEx() {
		temp = new int[ 10 ];
		
		for( int idx = 0; idx < temp.length; idx++ ) 
			temp[ idx ] = idx;
	}

	@Override
	public void run() {
		for( int start : temp )	{
			try	{
				Thread.sleep( 1000 );
			} catch ( InterruptedException ie )	{
				ie.printStackTrace();
			}
			
			System.out.printf( "Thread name : %s ,",
					Thread.currentThread().getName() );
			System.out.printf( "temp value : %d \n", start);
		}
	}
	
	public static void main(String[] args) {
		SingleRunnableEx srt = new SingleRunnableEx();
		
		Thread t = new Thread( srt, "First" );
//		t.start();
		t.run();
	}
}
