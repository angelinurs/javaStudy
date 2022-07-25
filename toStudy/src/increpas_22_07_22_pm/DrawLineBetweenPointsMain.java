package increpas_22_07_22_pm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* ******************************
 * override WindowAdapter class
 */
class WindowAdapterOverride extends WindowAdapter {
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
};

/* ******************************
 * override MouseAdapter class
 */
class MouseAdapterOverride extends MouseAdapter	{
	
	DrawLineBetweenPointsMain frame;
	
	public MouseAdapterOverride( DrawLineBetweenPointsMain frame ) {
		this.frame = frame;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {	
		
		frame.cv.flag = ( frame.cv.flag  )? false : true;

		frame.cv.x = e.getX();
		frame.cv.y = e.getY();
		frame.cv.pressX = e.getX();
		frame.cv.pressY = e.getY();
		
		frame.cv.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {		
		frame.cv.relX = e.getX();
		frame.cv.relY = e.getY();
		
		frame.cv.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		frame.centerPane.setBackground( Color.ORANGE );
	}

	@Override
	public void mouseExited(MouseEvent e) {
		frame.centerPane.setBackground( Color.GRAY );
	}
	
};

/* ******************************
 * override Mouse.Motion.Adapter class
 */
class MouseMotionAdapterOverride extends MouseMotionAdapter	{

	DrawLineBetweenPointsMain frame;
	
	public MouseMotionAdapterOverride( DrawLineBetweenPointsMain frame ) {
		this.frame = frame;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		frame.cv.dragFlag = true;
		
	}
};

/* ******************************
 * override Canvas class
 */
class DrawCircleCanvas extends Canvas {
	Color c;
	
	int x = -1, y = -1;
	int beforeX , beforeY;
	int width = 10, height = 10;
	
	int pressX, pressY;
	int relX, relY;
	
	static int count = 0;
	
	boolean flag = false;
	boolean dragFlag = false;

	@Override
	public void paint(Graphics g) {
		
		int red, green, blue;
		red = (int)( Math.random()*256 );
		green = (int)( Math.random()*256 );
		blue = (int)( Math.random()*256 ); 
		
		g.setColor( c = new Color( red, green, blue ) );
		
		if( count != 0 ) {
			g.fillOval( x - ( width /2 ), y - ( height /2), width, height );
		}
			
		if( count > 2 ) {
			g.drawLine( beforeX, beforeY, x, y );
			
		} 
		if( count > 1) 	{
			beforeX = x;
			beforeY = y;
		}
		
		count++;
		
		if( dragFlag ) {
			g.drawLine( pressX, pressY, relX, relY );
			dragFlag = false;
		}
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}
}

/* ******************************
 * main Class
 */
public class DrawLineBetweenPointsMain extends JFrame {
	
	JPanel centerPane;
	DrawCircleCanvas cv;
	
	public DrawLineBetweenPointsMain()	{
		super( "EventAdapter test" );
		
		add( cv = new DrawCircleCanvas() );
		
		centerPane = new JPanel();
		centerPane.setBackground( Color.CYAN );		
		
		add( centerPane, BorderLayout.WEST );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
//		setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		// quit event listener
		addWindowListener( new WindowAdapterOverride() );
		
		// frame mouse event
		centerPane.addMouseListener( new MouseAdapterOverride( this ) );
		
		cv.addMouseMotionListener( new MouseMotionAdapterOverride( this ) );
		cv.addMouseListener( new MouseAdapterOverride( this ) );
	}

	public static void main(String[] args) {
		new DrawLineBetweenPointsMain();
	}
};