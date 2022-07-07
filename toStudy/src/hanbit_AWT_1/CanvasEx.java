package hanbit_AWT_1;

import java.awt.*;

class MyCanvas extends Canvas	{
	public void paint( Graphics g)	{
		g.setColor(Color.RED);
		g.drawRect(20,  20,  100,  100 );
	}
};

public class CanvasEx {
	
	public static void main(String[] args) {
		
		Frame f = new Frame("Canvas Test");
		
		Panel p = new Panel();
		
		MyCanvas canvas = new MyCanvas();
		
		canvas.setBackground(Color.YELLOW);

//		p.add( canvas );
//
//		f.add(p);
		
		f.add(canvas);
		
		f.setLocation(300, 300);
		f.setSize(200, 200);
		f.setVisible(true);

	}

}
