package increpas_22_07_19_am;

interface InterfaceClass {
	// 상수 또는 추상 메서드만 선언 가능
	// 변수 선언 불가능
	int a = 10; // 실제로는 상수로 들어간것 final 생략 된것.
	final int b = 20;
	
	// abstract method 만 선언가능
	abstract public int getA();
	
	// abstract keyword 생략 가능.
	public void setA( int val); 
};

interface InterfaceClass2	{
	public void view();
};

public class InterfaceClassMain	implements InterfaceClass, InterfaceClass2 {

	@Override
	public int getA() { return a; }

	@Override
	public void setA(int val) {
//		a = val; // final 이므로 다른 값으로 assign 불가능.
		System.out.println( val );
		
	}

	@Override
	public void view() {
		System.out.println( getA() );
	}
	
	public static void main( String[] args ) {
		InterfaceClassMain inter =  new InterfaceClassMain();
		
		inter.setA( 25 );
		inter.view();
		
		InterfaceClass ifc = new InterfaceClassMain();
		InterfaceClass2 ifc2 = new InterfaceClassMain();
		
		ifc.setA( 56 );
		ifc2.view();
	}
}