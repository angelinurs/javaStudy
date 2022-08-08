package hanbit_thread;

class SuperThreadPriority extends Thread	{

	public SuperThreadPriority(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.printf( "Thread name : %s \n",
				Thread.currentThread().getName() );
	}
}

public class PriorityChangeEx extends SuperThreadPriority {

	public PriorityChangeEx(String name) {
		super(name);
	}

	public static void main(String[] args) {
		Thread t1 = new SuperThreadPriority( "- First Thread" );
		t1.setPriority( Thread.MIN_PRIORITY );
		t1.start();
		
		Thread t2 = new SuperThreadPriority( "- Second Thread" );
		t2.start();
	}
}