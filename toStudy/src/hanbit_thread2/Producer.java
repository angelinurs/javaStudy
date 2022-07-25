package hanbit_thread2;

public class Producer implements Runnable {
	private Car car;
	
	public Producer( Car car ) {
		this.car = car;
	}

	/*
	 * Producer class 에서의 Runnable 구현은 ?
	 * - 임의의 시간 간격을 두고 Car 클래스의 getCar() method 를 통해
	 *   임의의 Car type data 20 개를 push 함
	 */
	@Override
	public void run() {
		
		String CarName = null;
		
		for( int idx = 0; idx < 20; idx++ )	{
			CarName = car.getCar();
			car.push( CarName );
			
			try	{
				Thread.sleep( ( int )( Math.random() * 200 ) );
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
		}
	}
}
