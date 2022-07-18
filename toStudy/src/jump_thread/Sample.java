package jump_thread;

public class Sample extends Thread {
	
	public void run() {
		System.out.println( "Tread Run ===");
	}

	public static void main(String[] args) {
		Sample smp = new Sample();
		smp.start();
	}

}
