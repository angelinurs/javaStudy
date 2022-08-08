package increpas_22_07_21_am;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

class moveCanvas extends Canvas {
	int x = 0, y = 0;
	int width = 50, height = 50;

	@Override
	public void paint(Graphics g) {
		g.fillRect(x, y, width, height);
	}	
}

class KeyAdapterEX extends KeyAdapter	{
	KeyboardEvent frame;
	
	public KeyAdapterEX( KeyboardEvent frame )	{
		this.frame = frame;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		frame.f_width  = frame.getContentPane().getWidth();
		frame.f_height = frame.getContentPane().getHeight();
		
		int keyCode = e.getKeyCode();
		
		switch (keyCode) {
		case KeyEvent.VK_UP:
			frame.cv.y += ( frame.cv.y -10 < 0 )? 0 : -10;
//			frame.cv.y -= 10;
			
			break;
		case KeyEvent.VK_DOWN:
			frame.cv.y = ( frame.cv.y +10 > frame.f_height - frame.cv.height )? 
					     frame.f_height - frame.cv.height : frame.cv.y + 10;
//			frame.cv.y += 10;
			break;
		case KeyEvent.VK_LEFT: 
			frame.cv.x += ( frame.cv.x -10 < 0 )? 0 : -10;
//			frame.cv.x -= 10;
			break;
		case KeyEvent.VK_RIGHT: 
			frame.cv.x = ( frame.cv.x +10 > frame.f_width - frame.cv.width )? 
						 frame.f_width - frame.cv.width : frame.cv.x + 10;
//			frame.cv.x += 10;
			break;
		}
		
		frame.cv.repaint();
	}
}

public class KeyboardEvent extends JFrame {
	moveCanvas cv;
	
	int f_width, f_height;
	
	public KeyboardEvent()	{
		super( "Move rectangle." );
		
		add( cv = new moveCanvas() );
		
		pack();
		
		// Case 1. implements interface keylistener
//		addKeyListener( this );
		
		// Case 2. anony override abstract adapter
//		cv.addKeyListener( new KeyAdapter() {
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				int keyCode = e.getKeyCode();
//				
//				switch (keyCode) {
//				case KeyEvent.VK_UP: 
//					cv.y -= 10;
//					break;
//				case KeyEvent.VK_DOWN: 
//					cv.y += 10;
//					break;
//				case KeyEvent.VK_LEFT: 
//					cv.x -= 10;
//					break;
//				case KeyEvent.VK_RIGHT: 
//					cv.x += 10;
//					break;
//				}
//				
//				cv.repaint();
//			}
//		});
		
		// Case 3. new class extends abstract adapter class
		cv.addKeyListener( new KeyAdapterEX( this ) );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		
//		f_width = getContentPane().getWidth();
//		f_height = getContentPane().getHeight();
		
		System.out.printf("w : %d, h : %d\n", f_width, f_height );
	}

	public static void main(String[] args) {
		new KeyboardEvent();
	}
	
	// Case 1. implements interface
//	@Override
//	public void keyTyped(KeyEvent e) { }
//
//	@Override
//	public void keyPressed(KeyEvent e) { 
//		int keyCode = e.getKeyCode();
//		
//		switch (keyCode) {
//		case KeyEvent.VK_UP: 
//			cv.y -= 10;
//			break;
//		case KeyEvent.VK_DOWN: 
//			cv.y += 10;
//			break;
//		case KeyEvent.VK_LEFT: 
//			cv.x -= 10;
//			break;
//		case KeyEvent.VK_RIGHT: 
//			cv.x += 10;
//			break;
//		}
//		
//		cv.repaint();
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) { }
}
