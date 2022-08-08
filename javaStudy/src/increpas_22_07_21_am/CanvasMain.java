package increpas_22_07_21_am;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

class CanvasEx extends Canvas {
	
	int posX, posY;

	@Override
	public void paint(Graphics g) {
		
		StringBuffer sbAxis = new StringBuffer();		
		
//		g.setColor( Color.BLACK );
		g.setColor( new Color( posX % 256, posY % 256, ( posX + posY ) % 256) );
		
		sbAxis.append( String.format( "x : %d, y : %d", posX, posY ) );
		
		g.drawString( sbAxis.toString(), posX, posY );
	}

	@Override
	public void update(Graphics g) {
		paint( g );
	}
}

public class CanvasMain extends JFrame  
					    implements MouseListener {
	CanvasEx cv;
	
	public CanvasMain()	{
		super( "Draw String test" );
		cv = new CanvasEx();
		add( cv );
		
		cv.setBackground( Color.WHITE );
		
		cv.addMouseListener( this );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}

	public static void main(String[] args) {
		new CanvasMain();
	}

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) { 
		cv.posX = e.getX();
		cv.posY = e.getY();
		
		cv.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
}
