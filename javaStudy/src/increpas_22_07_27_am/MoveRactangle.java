package increpas_22_07_27_am;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Shot extends Thread {
	int x, y, width = 20, height = 20;
	MoveRactangle frame;
	
	public Shot(int x, int y, MoveRactangle frame) {
		
		this.x = x;
		this.y = y;
		
		this.frame = frame;
	}

	@Override
	public void run() {
		while( true ) {
			
			y -= 5;
			
			if( y < -20 ) break;
			
			frame.pane.repaint();
			
			try {
				Thread.sleep( 100 );
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
};

public class MoveRactangle extends JFrame{
	
	int rec_x = 145, rec_y = 250;
	int rec_width = 15, rec_height = 5;
	
	Image buf;
	
	ArrayList<Shot> slist;
	
	JPanel pane;
	
	public MoveRactangle() {
		super( "Move Rectangle." );
		
		slist = new ArrayList<>();
		
		pane = new JPanel() { 
			
			@Override public void paint(Graphics g) {
				
				buf = createImage( this.getWidth(), this.getHeight() );
				Graphics buf_g = buf.getGraphics();
				
				
				// Create board rectangle
				buf_g.fillRect( rec_x, rec_y, rec_width, rec_height );
				
				for( int idx = 0; idx < slist.size(); idx++ ) {
					buf_g.fillOval( 
								slist.get( idx ).x, 
								slist.get( idx ).y, 
								slist.get( idx ).width, 
								slist.get( idx ).height
							);
				}
				
				g.drawImage( buf, 0, 0, MoveRactangle.this );
			}
		};
		
		add( pane );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		
		addKeyListener( new KeyAdapter() {

			@Override public void keyPressed(KeyEvent e) {
				
				int key = e.getKeyCode();
				
				System.out.println( key );
				
				switch( key ) {
				case KeyEvent.VK_A:
					rec_x -= 5;
					break;
				case KeyEvent.VK_D:
					rec_x += 5;
					break;
				case KeyEvent.VK_SPACE:
					int x = rec_x;
					int y = rec_y;
					
					// 타원객체 생섯
					
					// 내부 클래스에서 바깥쪽 클래스를 참조하고 싶을때,
					// 바깥쪽 클래스 이름.this
					Shot s = new Shot(x, 250, MoveRactangle.this );
					
					slist.add( s );
					s.start();
					break;
				}
				
				pane.repaint();
			}
		});
		
		addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				System.exit( 0 );;
			}
		});
	}

	public static void main(String[] args) {
		new MoveRactangle();
	}
}
