package hanbit_thread2;

public class ProducerCustomerTest {

	public static void main(String[] args) {
		Car c = new Car();
		
		// Car type object 를 받는, Runnable interface 구현 된 object binding.
		Producer producer = new Producer( c );
		// Runnable interface 가 구현된 object 를 인자로 하는 Thread 생성.
		Thread tProducer = new Thread( producer );
		
		// Car type object 를 받는, Runnable interface 구현 된 object binding.
		Customer customer = new Customer( c );
		// Runnable interface 가 구현된 object 를 인자로 하는 Thread 생성.
		Thread tCustomer = new Thread( customer );
		
		// 각 생성된 thread start
		tProducer.start();
		tCustomer.start();
	}

}
