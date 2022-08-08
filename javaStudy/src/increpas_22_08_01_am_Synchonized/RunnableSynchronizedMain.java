package increpas_22_08_01_am_Synchonized;


// 동일한 목표를 수행하기 위해서 Thread 를 실행해야 하는 경우,
// Runnable interface 를 가지고 Thread 를 구현해야 한다.
class RunnableSynchronized	implements Runnable {
	
	int idx; // default value is 0
	int count;

	// Case 01. A-synchronized
//	@Override public void run() {
//		// 모든 Thread 가 공유하는 영역
//		String name = Thread.currentThread().getName();
//		
//		for( ; ; )	{
//			if( count > 9 )	{
//				count = 0;
//				break;
//			}
//			
//			System.out.printf( "%-3d -> [ Thread - %s ]\n", count++, name );
//			
//			try {
//				Thread.sleep( 500 );
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			
//		}
//	}
	
	// Case 02. synchronized
	@Override public synchronized void run() {
		// 모든 Thread 가 공유하는 영역
		String name = Thread.currentThread().getName();
		
		for( ; ; )	{
			if( count > 9 )	{
				count = 0;
				break;
			}
			
			System.out.printf( "%-3d -> [ Thread - %s ]\n", count++, name );
			
			try {
				Thread.sleep( 500 );
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
	
	// Case 03. synchronized block
//	@Override public void run() {
//		// 모든 Thread 가 공유하는 영역
//		String name = Thread.currentThread().getName();
//		
//		synchronized ( this ) {
//			for( ; ; )	{
//				if( count > 9 )	{
//					count = 0;
//					break;
//				}
//				
//				System.out.printf( "%-3d -> [ Thread - %s ]\n", count++, name );
//				
//				try {
//					Thread.sleep( 500 );
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//			}
//		} // end synchronized block
//	}
	
};

public class RunnableSynchronizedMain {

	public static void main(String[] args) {
		RunnableSynchronized rs =  new RunnableSynchronized();
		for( int idx = 0; idx < 3; idx++ )
			new Thread( rs, "thread - " + idx ).start();

	}

}
