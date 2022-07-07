package hanbit_AWT_2;

import java.awt.*;

public class GridLayoutEx {
	
	public static void main(String[] args) {
		
		Frame f = new Frame(" BorderLayout Test");
		
		// frame 에 바로 연결
		Panel p = new Panel();
		
		Button[] btns = new Button[5];
		
		for( int idx = 0; idx < btns.length; idx++)	{
			btns[ idx ]= new Button("Button_"+(idx+1));
		}		
		
		f.add(btns[0], BorderLayout.EAST);
		f.add(btns[1], BorderLayout.WEST);
		f.add(btns[2], BorderLayout.CENTER);
		f.add(btns[3], BorderLayout.SOUTH);
		f.add(btns[4], BorderLayout.NORTH);
		
		f.setLocation(300, 300);
		f.setSize(300, 300);
		f.setVisible(true);
	}

}
