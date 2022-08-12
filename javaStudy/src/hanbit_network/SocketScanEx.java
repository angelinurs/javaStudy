package hanbit_network;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SocketScanEx extends JFrame
						  implements Runnable {
	
	private JList resultList;
	private DefaultListModel listModel;
	
	private int index;
	private String ip;

	JPanel southPane;
	
	private JLabel ipLabel;
	private JTextField ipTextField;
	private JButton scanBtn;
	
	static private String mesg = " port open.";
	
	public SocketScanEx() {
		super( "Port scanner" );
		
		setLayout( new BorderLayout() );
		setResultView();
		setControlview();
		pack();
		
		setVisible( true );
		setBounds( 300, 300, 300, 300);
		
		addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
		});
		
		scanBtn.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				
				if( obj == scanBtn ) {
					ip = ipTextField.getText().trim();
					
					if( ip == null || ip.length() == 0 ) {
						
						ipTextField.requestFocusInWindow();
						ipTextField.setText( "" );
						
						return;
						
					} else {
						
						listModel.insertElementAt( ip, index );
						resultList.setSelectedIndex( index );
						index++;
						
						Thread t = new Thread( SocketScanEx.this );
						t.start();
					}
				}
			}
		});
	}

	private void setResultView() {
		
		add( new JScrollPane( resultList ), BorderLayout.CENTER );
		
		listModel = new DefaultListModel<>();
		resultList = new JList<>( listModel );
		resultList.setVisibleRowCount( 10 );
		
	}

	private void setControlview() {
		
		add( southPane = new JPanel(), BorderLayout.SOUTH );
		
		southPane.add( ipLabel = new JLabel( "IP address : " ) );
		southPane.add( ipTextField = new JTextField( 10 ) );
		southPane.add( scanBtn = new JButton( "Scan" ) );
	}
	
	
	@Override public void run() {
		Socket s = null;
		
		for( int port = 1; port < 65536; port++ ) {
			
			try {
				s = new Socket( ip, index );
				listModel.insertElementAt( port + mesg, index );
				resultList.setSelectedIndex( index );
				
				
			} catch (UnknownHostException ukhe) {
				System.out.println( "address is not exist." );
//				ukhe.printStackTrace();
			} catch (IOException ioe) {
				listModel.setElementAt(  port + " is  not exist." , index);
				resultList.setSelectedIndex( index );
				
//				ioe.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new SocketScanEx();

	}

}
