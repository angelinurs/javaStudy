package increpas_22_07_21_am;

import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class InnerCanvasMain extends JFrame implements WindowListener {
	
	public InnerCanvasMain()	{
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
//		setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		addWindowListener( this );
	}

	public static void main(String[] args) {
		new InnerCanvasMain();
	}

}
