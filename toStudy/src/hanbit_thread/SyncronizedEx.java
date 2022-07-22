package hanbit_thread;

class ATM implements Runnable {
	private long depositeMoney = 10000;

	@Override
	public void run() {
		synchronized( this ) {
			for( int idx = 0; idx < 10; idx++ ) {
				try	{
					Thread.sleep( 1000 );
				} catch ( InterruptedException e ) {
					e.printStackTrace();
				}
				
				if( getDepositeMoney() <= 0 ) break;
				
				withDraw( 1000 );
			}
		}
	}
	
	public void withDraw( long howMuch ) {
		if( getDepositeMoney() > 0 )	{
			depositeMoney -= howMuch;
			
			System.out.print( Thread.currentThread().getName() + ", " );
			System.out.printf( "잔액 : %,d 원 \n", getDepositeMoney() );
			
		} else {
			System.out.print( Thread.currentThread().getName() + ", " );
			System.out.printf( "잔액이 부족합니다." );
		}
	}
	
	public long getDepositeMoney() {
		return depositeMoney;
	}
}

public class SyncronizedEx {

	public static void main(String[] args) {
		ATM atm = new ATM();
		
		Thread mother = new Thread(atm, "mother" );
		Thread son = new Thread(atm, "son" );
		
		mother.start();
		son.start();
	}
}
