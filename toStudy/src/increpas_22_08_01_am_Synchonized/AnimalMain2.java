package increpas_22_08_01_am_Synchonized;

/*
 * ( 공유 객체 )
 * Thread 들이 해야할 일을 모다둔 객체
 */
class Animal2	{
	String sound = null;
	
	// Case 1. A-synchronized
//	public void shout( String sound )	{
	// Case 2. synchronized
	public synchronized void shout( String sound )	{
		for( int idx = 0; idx < 10; idx++ ) {
			System.out.printf( "[ %d ] : %s - %s\n", idx, sound, Thread.currentThread().getName() );
			
			try {
				int waitTime = (int)( Math.random() * 1000 );
				
				Thread.sleep( waitTime );
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
};

class AnimalThread2	extends Thread {
	
	int birdType;
	String[] sounds = { "삐약~삐약", "멍~멍~", "어~흥~" };
	
	// 각 Thread 가 같이 사용할, 공유 객체
	// - thread 가 여러개 생성 되어도, 같은 객체이어야 한다.
	Animal2 animal;
	
	public AnimalThread2( int birdType, Animal2 animal )	{
		this.animal = animal;
		this.birdType = birdType;
	}

	@Override public void run() {
		animal.shout( sounds[ birdType ] );
	}
};

public class AnimalMain2 {

	public static void main(String[] args) {
		// 여러 쓰레드가 같이 쓸 공용 객체이므로,
		// 미리 Object 를 만들고 각 Thread 를 실행할때 마다 실어 준다.
		Animal2 animal = new Animal2();
		
		for( int idx = 0; idx < 3; idx++ )
			new AnimalThread2( idx, animal ).start();
		
	}

}
