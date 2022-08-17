package hanbit_network;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ServerSocketScanEx extends JFrame 
								implements Runnable {
	
	private JPanel southPane;
	private JScrollPane centerScrollPane;
	
	private JLabel ipLabel;
	private JTextField ipTextField;
	private JButton scanBtn;
	
	private JList resultList;
	private DefaultListModel listmodel;
	private int index;
	private String ip;
	
	public ServerSocketScanEx()	{
		super( "Server Socket Scan." );
		
		setSouthPane();
		setCenterScrollPane();
		pack();
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		
		addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
		});
		
	}

	private void setSouthPane() {
		add( southPane = new JPanel() );
		
		southPane.add( ipLabel = new JLabel( "IP : " ) );
		southPane.add( ipTextField = new JTextField( 10 ) );
		southPane.add( scanBtn = new JButton( "Scan" ) );
	}
	
	private void setCenterScrollPane() {
		
	}

	public static void main(String[] args) {
		new ServerSocketScanEx();
	}

}
