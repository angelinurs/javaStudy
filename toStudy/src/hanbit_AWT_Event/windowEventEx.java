package hanbit_AWT_Event;

import java.awt.*;
import java.awt.event.*;

public class windowEventEx extends Frame 
						   implements WindowListener {
	
	public windowEventEx()	{
		super("windowEvent test");
		
		Label exit = new Label("press to exit button");
		
		add( exit );
		
		setBounds( 300, 100, 500, 600);
		setVisible( true );
		
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new windowEventEx();

	}

	@Override
	public void windowOpened(WindowEvent e) { }

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) { }

	@Override
	public void windowIconified(WindowEvent e) { }

	@Override
	public void windowDeiconified(WindowEvent e) { }

	@Override
	public void windowActivated(WindowEvent e) { }

	@Override
	public void windowDeactivated(WindowEvent e) { }
}
