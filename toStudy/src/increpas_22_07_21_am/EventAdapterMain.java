package increpas_22_07_21_am;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EventAdapterMain extends JFrame 
							  implements WindowListener {
	
	public EventAdapterMain()	{
		super( "EventAdapter test" );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
//		setDefaultCloseOperation( EXIT_ON_CLOSE );
		
		// quit event listener
		addWindowListener( this );
	}

	public static void main(String[] args) {
		new EventAdapterMain();

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int cmd = JOptionPane.showConfirmDialog( this, "Confirm to quit?", "Alert Message",JOptionPane.YES_NO_OPTION );
		System.out.println( cmd );
		
//		if( cmd == JOptionPane.YES_OPTION ) System.exit( 0 );
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
