package jump_thread;

public class Sample2 extends Thread {
	
	int seq;
	
	public Sample2( int seq ) {
		this.seq = seq;
	}
	
	public void run() {
		System.out.println( this.seq + " Thread Start." );
		
		try {
			Thread.sleep( 1000 );
		} catch ( Exception e ) { }
		
		System.out.println( this.seq + " Thread End." );
	}

	public static void main(String[] args) {
		
		for( int idx = 0; idx < 10; idx++ )	{
			Thread t = new Sample2( idx );
			t.start();
		}
		
		System.out.println( "Main end." );
	}

}
