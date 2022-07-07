package hanbit_AWT_1;

import java.awt.*;

public class ButtonEx {
	
	public static void main(String[] args) {
		
		Frame f = new Frame(" Button Test");
		
		Panel p = new Panel();
		
		Checkbox ck1 = new Checkbox( "movie", true );
		Checkbox ck2 = new Checkbox( "sports" );
		Checkbox ck3 = new Checkbox( "travle" );
		
		p.add(ck1);
		p.add(ck2);
		p.add(ck3);		
		
		f.add(p);
		
		f.setLocation(300, 300);
		f.setSize(300, 100);
		f.setVisible(true);

	}

}
