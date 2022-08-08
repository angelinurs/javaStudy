package increpas_22_07_27_am;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class InnerMain extends JFrame {
	
	int x, y, w = 50, h = 50;
	
	JPanel pane = new JPanel() {

		@Override
		public void paint(Graphics g) {
			Image buf = createImage( pane.getWidth(), pane.getHeight() );
			Graphics buf_g = buf.getGraphics();
			
			buf_g.fillOval( x, y, w, h);
			
			g.drawImage( buf, 0, 0, this );
		}
	};
	
	public InnerMain()	{
		super( "Create annonymous inner class." );
		
		add( pane );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		
		Thread t = new Thread() {

			@Override
			public void run() {
				
				while( true ) {
					y += 5;
					
					System.out.println( y + ", " + pane.getHeight() +  ", " + h );
					if( y > pane.getHeight() - h ) break;
					
					pane.repaint();
					
					try {
						Thread.sleep( 100 );
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		};
		
		t.start();
		
		/*
		WindowAdapter wa = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
			
		};
		
		this.addWindowListener( wa );
		*/
		
		this.addWindowListener( new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
		});
		
	}

	public static void main(String[] args) {
		new InnerMain();
	}

}
