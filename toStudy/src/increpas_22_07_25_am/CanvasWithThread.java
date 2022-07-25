package increpas_22_07_25_am;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MoveCanvas extends Canvas	{
	
	int x = 0, y = 100;
	int width = 200, height = 200;
	
	@Override
	public void paint(Graphics g) {
		g.fillOval(x, y, width, height);
	}
	
//	@Override
//	public void update(Graphics g) {
//		paint( g );
//	}
};

class CustomPanel extends JPanel {
	
	int x = 100, y = 0;
	int width = 150, height = 200;
	Image img = null;
	
	@Override
	public void paint(Graphics g) {
		// JComponent class 를 상속 받으로므로,
		// Jcomponent 의 method paint() 를 override 할 수 있다.
		
		g.drawImage(img, x, y, width, height, this );
	}
}

class NewMouseAdater extends MouseAdapter	{
	FrameBoard frame;

	public NewMouseAdater(FrameBoard frame) {
		this.frame = frame;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		frame.cPane.x = e.getX();
		frame.cPane.y = e.getY();
		frame.cPane.repaint();
	}
};

class FrameBoard extends JFrame {
	MoveCanvas cv;
	CustomPanel cPane;
	
	public FrameBoard()	{
//		add( cv = new MoveCanvas() );
		add( cPane = new CustomPanel() );
		
		String filename = "src/images/kakao.jpg";
		cPane.img = Toolkit.getDefaultToolkit().getImage( filename );
		
		setBounds( 300, 200, 600, 500 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		new CustomThread( this ).start();
		
		cPane.addMouseListener( new NewMouseAdater( this ) );
	}
};

class CustomThread extends Thread {
	
	FrameBoard frame;
	
	public CustomThread( FrameBoard frame )	{
		this.frame = frame;
	}

	// Case 01. 
	// - using Canvas
//	@Override
//	public void run() {
//		
//		while( true )	{
//			if( frame.cv.x < frame.getContentPane().getWidth() - frame.cv.width )	{
//				frame.cv.x += 5;
//			} else if( frame.cv.x > 0 )	{
//				frame.cv.x -= 5;
//			}
//			frame.cv.repaint();
//			
//			try {
//				Thread.sleep( 200 );
//			} catch( Exception e ) { }
//		}
//	}
	
	// Case 02. 
	// - using Jpanel
	@Override
	public void run() {
		
		while( true )	{
			System.out.println( frame.cPane.y );
			System.out.println( frame.cPane.img.getHeight( frame ) );
			if( frame.cPane.y < frame.cPane.getHeight() - frame.cPane.height )	{
				frame.cPane.y += 5;
			} 
			
			
			frame.cPane.repaint();
			
			try {
				Thread.sleep( 200 );
			} catch( Exception e ) { }
		}
	}
};

public class CanvasWithThread {

	public static void main(String[] args) {
		
		new FrameBoard();
//		FrameBoard frame = new FrameBoard();
//		CustomThread tFrame = new CustomThread(frame);
//		
//		tFrame.start();
	}

};
