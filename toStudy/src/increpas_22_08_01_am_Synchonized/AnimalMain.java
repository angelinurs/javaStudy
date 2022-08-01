package increpas_22_08_01_am_Synchonized;

/*
 * ( 공유 객체 )
 * Thread 들이 해야할 일을 모다둔 객체
 */
class Animal	{
	
//	public synchronized void shout_1()	{
	public void shout_1()	{
		for( int idx = 0; idx < 10; idx++ ) {
			System.out.printf( "[ %d ] : KUKUkuku\n", idx );
			
			try {
				int waitTime = (int)( Math.random() * 1000 );
				
				Thread.sleep( waitTime );
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void shout_2()	{
		for( int idx = 0; idx < 10; idx++ ) {
			System.out.printf( "[ %d ] : PPi~ppi\n", idx );
			
			try {
				int waitTime = (int)( Math.random() * 1000 );
				
				Thread.sleep( waitTime );
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void shout_3()	{
		for( int idx = 0; idx < 10; idx++ ) {
			System.out.printf( "[ %d ] : whoo~~~\n", idx );
			
			try {
				int waitTime = (int)( Math.random() * 1000 );
				
				Thread.sleep( waitTime );
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
};

class AnimalThread	extends Thread {
	
	int birdType;
	
	// 각 Thread 가 같이 사용할, 공유 객체
	// - thread 가 여러개 생성 되어도, 같은 객체이어야 한다.
	Animal animal;
	
	public AnimalThread( int birdType, Animal animal )	{
		this.animal = animal;
		this.birdType = birdType;
	}

	@Override public void run() {
		
		switch( birdType )	{
			case 0: 
					animal.shout_1();
					break;
			case 1: 
					animal.shout_2();
					break;
			case 2: 
					animal.shout_3();
					break;
		}
	}
};

public class AnimalMain {

	public static void main(String[] args) {
		// 여러 쓰레드가 같이 쓸 공용 객체이므로,
		// 미리 Object 를 만들고 각 Thread 를 실행할때 마다 실어 준다.
		Animal animal = new Animal();
		
		for( int idx = 0; idx < 3; idx++ )
			new AnimalThread( idx, animal ).start();
		
		new AnimalThread( 0, animal ).start();
		
		
		
	}

}
