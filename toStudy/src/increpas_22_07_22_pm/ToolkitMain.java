package increpas_22_07_22_pm;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;

import javax.swing.*;

class MouseAdapterCustom extends MouseAdapter {
	ToolkitMain tk;
	
	public MouseAdapterCustom(ToolkitMain tk) {
		this.tk = tk;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		tk.cv.pressFlag = true;
		
		tk.cv.x = e.getX();
		tk.cv.y = e.getY();
		
		tk.cv.repaint();
	}
}

/* ******************************
 * main Class
 */
class ToolkitWithCanvas extends Canvas 	{
	int x, y;
	int width, height;
	boolean pressFlag = false;
	Toolkit tk;
	String filename;

	@Override
	public void paint(Graphics g) {
		tk  = Toolkit.getDefaultToolkit();
		
//		String filename = "src/images/kakao.jpg";
		String filename = "src/imageLottos/" + (int)(Math.random()*45 + 1) +".jpg";
		
		System.out.println( filename );
		
		Image img = tk.getImage( filename );
		
		g.drawImage( img,  x - ( img.getWidth(this) / 2 ), y - ( img.getHeight(this) / 2 ), width, height, this ); // observer -> this
		
		pressFlag = false;
	}

	@Override
	public void update(Graphics g) {
		paint( g );
	}
}

/* ******************************
 * main Class
 */
public class ToolkitMain extends JFrame {
	
	ToolkitWithCanvas cv;
	
	public ToolkitMain()	{
		super( "ToolkitWithCanvas test" );
		
		add( cv = new ToolkitWithCanvas() );
		
		cv.width = 30;
		cv.height = 30;
		cv.setBackground( Color.WHITE );
		
		setBounds( 300, 300, 700, 700 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		cv.addMouseListener( new MouseAdapterCustom( this ) );
	}

	public static void main(String[] args) {
		new ToolkitMain();
	}
};