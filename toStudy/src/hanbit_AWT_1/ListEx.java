package hanbit_AWT_1;

import java.awt.*;

public class ListEx {
	
	public static void main(String[] args) {
		
		Frame f = new Frame(" list Test");
		
		Panel p = new Panel();
		
		List list1 = new List(3, true);
		
		String[] cities = { "Berlin", "London", "Paris" };
		
		for( String city : cities )
			list1.add(city);

		p.add( list1 );

		f.add(p);
		
		f.setLocation(300, 300);
		f.setSize(300, 100);
		f.setVisible(true);

	}

}
