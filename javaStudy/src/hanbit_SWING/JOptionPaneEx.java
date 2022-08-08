package hanbit_SWING;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JOptionPaneEx extends JFrame
							  implements ActionListener {
	
	JButton[] btns = new JButton[4];
	String[] str = { "Log-In", "Sign-In" };
	
	String[] Dialog	 = {
							"MessegeDialog",
							"ConfirmDialog",
							"InputDialog",
							"OptionDialog"
						};
	
	public JOptionPaneEx()	{
		super( "JOptionPane test");

		setLayout( new FlowLayout() );
		
		for( int idx = 0; idx < btns.length; idx++ )	{
			btns[ idx ] = new JButton( Dialog[ idx ] );
			add( btns[ idx ] );
		}
		
		pack();
		
		for( int idx = 0; idx < btns.length; idx++ )	{
			btns[ idx ].addActionListener(this);
		}		
		
		
		setBounds( 300, 200, 500, 400 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == btns[0] ) JOptionPane.showMessageDialog( this, Dialog[ 0 ], "Message",
																	  JOptionPane.INFORMATION_MESSAGE );
		else if( e.getSource() == btns[1] ) JOptionPane.showConfirmDialog( this, Dialog[ 1 ], "Confirm",
																	  JOptionPane.YES_NO_CANCEL_OPTION );
		else if( e.getSource() == btns[2] ) JOptionPane.showInputDialog( this, Dialog[ 2 ], "Input",
																	  JOptionPane.YES_NO_OPTION );
		else if( e.getSource() == btns[3] ) JOptionPane.showOptionDialog( this, Dialog[ 3 ], "Option",
				  													  JOptionPane.YES_NO_CANCEL_OPTION,
				  													  JOptionPane.INFORMATION_MESSAGE,
				  													  null, str, str[ 0 ] );
	}

	public static void main(String[] args) {
		new JOptionPaneEx();

	}
}
