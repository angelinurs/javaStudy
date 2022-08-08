package jump_thread;

import java.util.ArrayList;

public class Sample_runnable implements Runnable {
	
	int seq;
	
	public Sample_runnable( int seq )	{ this.seq = seq; }
	
	public void run()	{
		System.out.println( seq + " Thread Start." );
		
		try	{
			Thread.sleep( 1000 );
		} catch ( Exception e ) {}
		
		System.out.println( seq + " Thread End." );
	}

	public static void main(String[] args) {
		
		ArrayList<Thread> threads = new ArrayList<>();
		final int size = 10;
		
		for( int idx = 0; idx < size; idx++ )	{
			Thread t = new Thread( new Sample_runnable(idx) );
			t.start();
			
			threads.add( t );
		}

		for( int idx = 0; idx < size; idx++ )	{
			Thread t = threads.get( idx );
			
			try	{
				t.join();
			} catch (Exception e) { }
		}
		
		System.out.println( "Main End." );
	}

}
