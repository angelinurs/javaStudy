package hanbit_generic;

class Gen	{
	
	String msg = "Gen";
	
	public String genMsg() { return msg; }
}

class Gen2	extends Gen {
	String msg = "Gen2";
	
	public String genMsg() { return msg; }
}

class Gen3	extends Gen2 {
	String msg = "Gen3";
	
	public String genMsg() { return msg; }
}

public class GenericMain4<T> {
	T v;
	
	public GenericMain<T>( T t ) { v = t; }

	public static void main(String[] args) {

	}

}
