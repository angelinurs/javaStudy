package hanbit_thread2;

public class Customer implements Runnable {
	
	private Car car;
	
	public Customer(Car car) {
		this.car = car;
	}

	/*
	 * Customer class 에서의 Runnable 구현은 ?
	 * - 임의의 시간 간격을 두고 Car 클래스의 pop() method 를 통해
	 *   임의의 Car type data 20 개를 pop 한다..
	 */
	@Override
	public void run() {
		String carName = null;
		
		for( int idx = 0; idx < 20; idx++ ) {
			carName = car.pop();
			
			try	{
				Thread.sleep( ( int )( Math.random() * 200 ) );
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
		}
	}
}
