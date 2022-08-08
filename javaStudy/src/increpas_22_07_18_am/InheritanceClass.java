package increpas_22_07_18_am;

class Parent	{
	String str = "Parent";

	public String getStr() { return str; }

	public void setStr(String str) { this.str = str; }
}

class Son extends Parent	{
	String str = "Son";

	@Override //annotation 은 일반적 comment 와 달리 어떤 기능을 가지는 기능성 주석
	public String getStr() { return str; }

	@Override
	public void setStr(String str) { this.str = str; }
	
}

class Daughter extends Parent	{
	String str = "Duaghter";

	@Override
	public String getStr() { return str; }

	@Override
	public void setStr(String str) { this.str = str; }
}

public class InheritanceClass {
	
	// inheritance 의 overriding 을 이용한 객체에 따른 메소드 호출
	public static void testInstance( Parent p ) {
		System.out.println( p.getStr() );
	}

	public static void main(String[] args) {
		Parent p1 = new Son();
		Parent p2 = new Daughter();
		
		// 상위 클래스에 하위 Object를 바인딩 할 때, 자식 클래스의 속성이 우선이다.
		System.out.printf( "son's str Value : %s\n", p1.getStr() );
		System.out.printf( "daughter's str Value : %s\n", p2.getStr() );
	
		testInstance( new Son() );
		testInstance( new Daughter() );
	}
}
