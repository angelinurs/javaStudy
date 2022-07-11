package hanbit_SWING;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JInternalFrameEx extends JFrame
							  implements ActionListener {
	
	JDesktopPane desktop = new JDesktopPane();

	JMenuItem openItem  = new JMenuItem( "New" );
	JMenuItem closeItem = new JMenuItem( "Close" );
	JMenuItem exitItem  = new JMenuItem( "Exit" );
	
	int cnt = 1;
	
	public JInternalFrameEx()	{
		super( "JInternalFrame test");
		
		buildGUI();
		
		setBounds( 300, 200, 500, 400 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	public void buildGUI()	{
		add( desktop, BorderLayout.CENTER );
		
		JMenuBar menubar = new JMenuBar();
		JFrame f = new JFrame();
		setJMenuBar( menubar );
		
		JMenu fileMenu = new JMenu( "File" );
		menubar.add( fileMenu );
		
		fileMenu.add( openItem );
		fileMenu.add( closeItem );
		fileMenu.addSeparator();
		fileMenu.add( exitItem );
		
		openItem.addActionListener( this );
		closeItem.addActionListener( this );
		exitItem.addActionListener( this );
	}
	
	public void openFrame()	{
		JInternalFrame frame = new JInternalFrame( "New Document"+cnt, true, true, true, true );
		
		JLabel imageLabel = new JLabel("New Document" );
		frame.getContentPane().setBackground( Color.white );
		frame.getContentPane().add( imageLabel );
		
		if( cnt == 1 )
			frame.setSize( 200, 200 );
		else
			frame.setBounds( ( cnt -1 )*20, 
							 ( cnt -1 )*20,
							 200, 200 );		
		cnt++;
		
		desktop.add( frame );
		frame.setVisible( true );
	}
	
	public void closeFrame()	{
		JInternalFrame frame = desktop.getSelectedFrame();
		
		if( frame == null ) return;
		
		frame.setVisible( false );
		frame.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if( obj == openItem ) openFrame();
		else if( obj == closeItem ) closeFrame();
		else if( obj == exitItem ) {
			setVisible( false );
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new JInternalFrameEx();

	}
}
