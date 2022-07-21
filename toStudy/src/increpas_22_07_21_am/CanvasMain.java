package increpas_22_07_21_am;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

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
