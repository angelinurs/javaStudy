package hanbit_thread;

public class MultiThreadEx implements Runnable {

	@Override
	public void run() {
		int first = 0;
		int second = 0;
		
		for( int idx = 0; idx < 20; idx++ ) {
			first++;
			second++;
			System.out.printf( "first : %d, ", first );
			System.out.printf( "second : %d, ", second );
			System.out.printf( "Thread name : %s\n", 
					Thread.currentThread().getName() );
		}
	}
	
	public static void main(String[] args) {
		MultiThreadEx srtl = new MultiThreadEx();
		
		Thread firstThread = new Thread( srtl, "- First Thread");
//		firstThread.setPriority( Thread.MAX_PRIORITY );
		firstThread.start();
		
		
		MultiThreadEx srt2 = new MultiThreadEx();
		
		Thread secondThread = new Thread( srt2, "- Second Thread");
		secondThread.start();
	}
}
