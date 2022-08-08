package increpas_22_07_21_am;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* ******************************
 * override WindowAdapter class
 */
class WindowAdapterClass extends WindowAdapter {
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
};

/* ******************************
 * override MouseAdapter class
 */
class MouseAdapterClass extends MouseAdapter	{
	
	EventAdapterMain frame;
	
	@Override
	public void mousePressed(MouseEvent e) {
		frame.cv.x = e.getX();
		frame.cv.y = e.getY();
		
		frame.cv.repaint();
	}

	public MouseAdapterClass( EventAdapterMain frame ) {
		this.frame = frame;
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
 * override Canvas class
 */
class DrawCircleCanvas extends Canvas {
	Color c;
	int x, y;
	int width = 10, height = 10;

	@Override
	public void paint(Graphics g) {
		
		int red, green, blue;
		red = (int)( Math.random()*256 );
		green = (int)( Math.random()*256 );
		blue = (int)( Math.random()*256 ); 
		
		g.setColor( c = new Color( red, green, blue ) );
		
		g.fillOval( x - ( width /2 ), y - ( height /2), width, height );
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
}

/* ******************************
 * main Class
 */
public class EventAdapterMain extends JFrame {
	
	JPanel centerPane;
	DrawCircleCanvas cv;
	
	public EventAdapterMain()	{
		super( "EventAdapter test" );
		
		add( cv = new DrawCircleCanvas() );
		
		centerPane = new JPanel();
		centerPane.setBackground( Color.CYAN );		
		
		add( centerPane, BorderLayout.WEST );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
//		setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		// quit event listener
		addWindowListener( new WindowAdapterClass() );
		
		// frame mouse event
		centerPane.addMouseListener( new MouseAdapterClass( this ) );
		cv.addMouseListener( new MouseAdapterClass( this ) );
	}

	public static void main(String[] args) {
		new EventAdapterMain();
	}
};