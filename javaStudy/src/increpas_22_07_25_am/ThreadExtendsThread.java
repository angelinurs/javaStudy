package increpas_22_07_25_am;

class ThreadBasic extends Thread {
	public void run() {
		
		for( int idx = 0; idx < 10; idx++ )	{
			System.out.println( "Thread " + idx );
			
			try	{
				Thread.sleep( 500 );
			} catch (Exception e) { 
				e.printStackTrace();
			}
			
		}
	}
}

public class ThreadExtendsThread extends ThreadBasic {

	public static void main(String[] args) {
		
		// Case 01. class ThreadBasic
		// - When was it Called start() method, it call run() mehtod.
		new ThreadBasic().start();
		
		new ThreadExtendsThread().start();
	}

}
