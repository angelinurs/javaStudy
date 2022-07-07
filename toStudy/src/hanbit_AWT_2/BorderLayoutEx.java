package hanbit_AWT_2;

import java.awt.*;

public class BorderLayoutEx {
	
	public static void main(String[] args) {
		
		Frame f = new Frame(" GridLayout Test");
		
		// frame 에 바로 연결
		Panel p = new Panel();
		
		// <-- this line is very important
		f.setLayout(new GridLayout(2,3));
		
		Button[][] btns = new Button[2][4];
		
		for( int idx = 0; idx < btns.length; idx++)	{
			for( int jdx = 0; jdx < btns[idx].length; jdx++)	{
				btns[ idx ][ jdx ]= new Button((idx+1) + ", " + (jdx+1));
				f.add(btns[ idx ][ jdx ]);
			}
		}
		
		f.setLocation(300, 300);
		f.setSize(300, 300);
		f.setVisible(true);

	}

}
