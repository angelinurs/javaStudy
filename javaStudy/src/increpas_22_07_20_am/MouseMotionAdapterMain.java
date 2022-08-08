package increpas_22_07_20_am;

import java.awt.Canvas;

import javax.swing.JFrame;

public class MouseMotionAdapterMain extends JFrame {
	
	
	CanvasOverride can;
	
	public MouseMotionAdapterMain()	{
		super( "MouseMotionAdapter Test." );
		
		add( can = new CanvasOverride() );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}

	public static void main(String[] args) {
		new MouseMotionAdapterMain();
	}

}
