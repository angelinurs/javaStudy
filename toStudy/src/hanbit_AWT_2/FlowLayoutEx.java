package hanbit_AWT_2;

import java.awt.*;

public class FlowLayoutEx {
	
	public static void main(String[] args) {
		
		Frame f = new Frame(" FlowLayout Test");
		
		Panel p = new Panel();
		
		Button[] btns = new Button[5];
		
		for( int idx = 0; idx < btns.length; idx++)	{
			btns[ idx ]= new Button("Button_"+(idx+1));
			p.add(btns[idx]);
		}		
		
		f.add(p);
		
		f.setLocation(300, 300);
		f.setSize(300, 100);
		f.setVisible(true);

	}

}
