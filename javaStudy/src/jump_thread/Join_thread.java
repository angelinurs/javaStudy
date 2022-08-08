package jump_thread;

import java.util.ArrayList;

public class Join_thread extends Thread {
	
	int seq;
	
	public Join_thread( int seq )	{
		this.seq = seq;
	}
	
	public void run() {
		System.out.println( seq + " Thread Start." );
		
		try	{
			Thread.sleep( 1000 );
		} catch ( Exception e) {}
		
		System.out.println( seq + " Thread End." );
	}

	public static void main(String[] args) {
		
		ArrayList<Thread> threads = new ArrayList<>();
		
		for( int idx = 0; idx < 10; idx++ ) {
			Thread t = new Join_thread( idx );
			t.start();
			
			threads.add( t );
		}
		
		for( int idx = 0; idx < threads.size(); idx++ ) {
			Thread t = threads.get( idx );
			
			try {
				t.join();
			} catch ( Exception e ) { }
		}
		
		System.out.println( "Main End." );
	}

}
