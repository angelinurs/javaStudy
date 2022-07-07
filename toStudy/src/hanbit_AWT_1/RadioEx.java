package hanbit_AWT_1;

import java.awt.*;

public class RadioEx {
	
	public static void main(String[] args) {
		
		Frame f = new Frame(" Button Test");
		
		Panel p = new Panel();
		
		CheckboxGroup group = new CheckboxGroup();
		
		Checkbox radio1 = new Checkbox( "movie", group, false );
		Checkbox radio2 = new Checkbox( "sports", group, false );
		Checkbox radio3 = new Checkbox( "travle", group, true );
		
		p.add(radio1);
		p.add(radio2);
		p.add(radio3);
		
		f.add(p);
		
		f.setLocation(300, 300);
		f.setSize(300, 100);
		f.setVisible(true);

	}

}
