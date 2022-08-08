package hanbit_generic;

public class GenericTest1 {

	public static void main(String[] args) {
		GenericEx1<String> t = new GenericEx1<String>();
		
		String[] ss = { "am", "pm", "am/pm" };
		
		t.set(ss);
		t.print();

	}

}
