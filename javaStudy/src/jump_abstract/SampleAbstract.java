package jump_abstract;

abstract class Predetor extends Animal	{
	abstract String getFood();
	static int LEG_COUNT = 4;
	
	public void printFood() {
		System.out.printf( "my food is %s \n", getFood() );
	}
	
	static int speed()	{
		return LEG_COUNT * 30;
	}
}

interface Barkable	{
	void Bark();
}

//interface BarkablePredetor extends Predetor, implements Barkable	{
//	
//}

class Animal	{
	String name;
	
	void setName( String name ) {
		this.name = name;
	}
}

class Tiger extends Predetor implements Barkable {

	@Override
	public String getFood() {
		return "apple";
	}

	@Override
	public void Bark() {
		System.out.println( "어흥" );
	}
}

class Lion extends Predetor implements Barkable {

	@Override
	public String getFood() {
		return "banana";
	}

	@Override
	public void Bark() {
		System.out.println( "으르렁" );
	}
	
}

class ZooKeeper	{
	void feed( Predetor predetor )	{
		System.out.println( "feed " + predetor.getFood() );
	}
}

class Bouncer	{
//	void barkAnimal( Animal animal ) {
//		if( animal instanceof Tiger ) {
//			System.out.println( "어흥" );
//		}
//		
//		if( animal instanceof Lion ) {
//			System.out.println( "으로릉" );
//		}
//		
//	}
	
	void barkAnimal( Barkable animal )	{
		animal.Bark();
	}
}

public class SampleAbstract {

	public static void main(String[] args) {
		ZooKeeper zookeeper = new ZooKeeper();
		
		Tiger tiger = new Tiger();
		Lion lion = new Lion();
		
		zookeeper.feed( tiger );
		zookeeper.feed( lion );
		
		tiger.printFood();
		lion.printFood();
		
		Bouncer bouncer = new Bouncer();
		
		bouncer.barkAnimal( tiger );
		bouncer.barkAnimal( lion );
	}

}
