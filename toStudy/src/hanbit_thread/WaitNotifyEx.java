package hanbit_thread;

class ATMtwo implements Runnable	{
	private long depositeMoney = 10000;
	
	public void run() {
		synchronized( this ) {
			for( int idx = 0; idx < 10; idx++ ) {
				if( getDepositeMoney() <= 0 ) break;
				
				withDraw( 1000 );
				
				if( getDepositeMoney() == 2000  ||
						getDepositeMoney() == 4000  ||
						getDepositeMoney() == 6000  ||
						getDepositeMoney() == 8000 )	{
					
					// 임의의 지연 상황 만들어 보기
					try	{
						this.wait();
					} catch ( InterruptedException e )	{
						e.printStackTrace();
					}
					
				} else {
					// 공유된 자원에 다른 Thread 가 접근 할 수 있도록 알림.
					this.notify();
				}
			}
		}
	}
	
	public void withDraw( long howMuch )	{
		if( getDepositeMoney() > 0 )	{
			depositeMoney -= howMuch;
			System.out.println( Thread.currentThread().getName() + ", " );
			System.out.printf( "잔랙 : %,d 원 \n", getDepositeMoney() );
		} else {
			System.out.println( Thread.currentThread().getName() + ", " );
			System.out.println( "잔랙이 부족합니다.");
		}
	}
	
	public long getDepositeMoney()	{
		return depositeMoney;
	}
}

public class WaitNotifyEx {

	public static void main(String[] args) {
		ATMtwo atm = new ATMtwo();
		
		Thread mother = new Thread( atm, "mother" );
		Thread son = new Thread( atm, "son" );
		
		mother.start();
		son.start();
	}
}
