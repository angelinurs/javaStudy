package hanbit_SWING;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JToolBarEx extends JFrame {
	
	public JToolBarEx()	{
		super( "JToolBar Test" );
		
		JToolBar tbar = new JToolBar("Exercise");
		tbar.setMargin( new Insets( 5,  5,  5,  5 ) );
		
		JPanel p = new JPanel( new GridLayout( 1, 0 ) );
		
		JButton bt1 = new JButton( "JAVA" );
		JButton bt2 = new JButton( "Windows" );
		JButton bt3 = new JButton( "Motif" );
		
		p.add( bt1 );
		p.add( bt2 );
		p.add( bt3 );
		
		tbar.add( p );
		
		add( "North", tbar );
			
		pack();
		
		setBounds( 300, 300, 600, 300 );
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JToolBarEx();
	}

}
