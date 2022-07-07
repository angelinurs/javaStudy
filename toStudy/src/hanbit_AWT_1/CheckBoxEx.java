package hanbit_AWT_1;

import java.awt.*;

public class CheckBoxEx {
	
	public static void main(String[] args) {
		
		Frame f = new Frame(" Button Test");
		
		Panel p = new Panel();
		
		Button b1 = new Button();
		Button b2 = new Button("output");
		Button b3 = new Button("sort");
		Button b4 = new Button("priority");
		
		b1.setLabel("Input");
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		
		f.add(p);
		
		f.setLocation(300, 300);
		f.setSize(300, 100);
		f.setVisible(true);

	}

}
