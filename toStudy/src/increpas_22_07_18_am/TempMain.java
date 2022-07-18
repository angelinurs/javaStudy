package increpas_22_07_18_am;

class Temp {
	public void print() {
		System.out.println("hh");
	}
};

public class TempMain extends Temp {
	
	int a = 10;
	
	public void print()	{
		System.out.println( a );
	}

	public static void main(String[] args) {
		
		TempMain tm = new TempMain();
		Temp t = tm;
		
		t.print();
	}
}
