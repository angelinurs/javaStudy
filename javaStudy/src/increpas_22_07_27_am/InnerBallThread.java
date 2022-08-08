package increpas_22_07_27_am;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

class Ball extends Thread {
	int x, y, width = 50, height = 50;
	InnerBallThread frame;
	
	public Ball(int x, int y, InnerBallThread frame) {
		
		this.x = x;
		this.y = y;
		
		this.frame = frame;
	}

	@Override
	public void run() {
		while( true ) {
			
//			frame.buf = frame.createImage( frame.pane.getWidth(), frame.pane.getHeight() );
//			
//			Graphics buf_g = frame.buf.getGraphics();
			
			y += 5;
			
			if( y > frame.pane.getHeight() - height ) break;
			
//			for( int idx = 0; idx < frame.blist.size(); idx++ ) {
//				buf_g.fillOval( frame.blist.get(idx).x, frame.blist.get(idx).y, width, height );
//			}
			
//			buf_g.fillOval( x, y, width, height );
			
			frame.pane.repaint();
			
			try {
				Thread.sleep( 100 );
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
};

public class InnerBallThread extends JFrame {
	
	int w = 50, h = 50;
	Image buf;
	
	ArrayList<Ball> blist;
	
	JPanel pane = new JPanel() {

		@Override
		public void paint(Graphics g) {
//			Image buf = createImage( pane.getWidth(), pane.getHeight() );
			buf = createImage( this.getWidth(), this.getHeight() );
			Graphics buf_g = buf.getGraphics();
			
			for( int idx = 0; idx < blist.size(); idx++ ) {
				buf_g.setColor( new Color( 
						(int)(Math.random() * 256 ), 
						(int)(Math.random() * 256 ), 
						(int)(Math.random() * 256 ) ) );
				
				buf_g.fillOval( blist.get(idx).x, blist.get(idx).y, w, h );
				
				System.out.println( g.getColor() );
			}
//			buf_g.fillOval( x, y, w, h);
			
			g.drawImage( buf, 0, 0, this );
		}
	};
	
	public InnerBallThread() {
		super( "Mouse event." );
		
		blist = new ArrayList<>();
		
		add( pane );
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		
		this.addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
		});
		
		pane.addMouseListener( new MouseAdapter() {

			@Override public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				// 타원객체 생섯
				
				Ball b = new Ball(x, y, InnerBallThread.this );
				
				// 내부 클래스에서 바깥쪽 클래스를 참조하고 싶을때,
				// 바깥쪽 클래스 이름.this
				blist.add( b );
				b.start();
				
			}
		});
	}

	public static void main(String[] args) {
		new InnerBallThread();
	}

}
