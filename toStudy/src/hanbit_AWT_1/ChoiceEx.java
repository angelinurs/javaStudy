package hanbit_AWT_1;

import java.awt.*;

public class ChoiceEx {
	
	public static void main(String[] args) {
		
		Frame f = new Frame(" Button Test");
		
		Panel p = new Panel();
		
		Choice ch = new Choice();
		
		ch.addItem( "apple" );
		ch.addItem("banana");
		
		p.add( ch );

		f.add(p);
		
		f.setLocation(300, 300);
		f.setSize(300, 100);
		f.setVisible(true);

	}

}
