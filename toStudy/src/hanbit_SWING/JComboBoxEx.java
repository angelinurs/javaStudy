package hanbit_SWING;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;

public class JComboBoxEx extends JFrame {
	public JComboBoxEx()	{
		super( "JComboBox Test" );
		
		setLayout( new FlowLayout( ) );
		
		String[] listData = { "ONE", "TWO", "THREE", "FOUR", "FIVE" };
		JComboBox combo = new JComboBox( listData );
		
		add( combo );
		
		DefaultComboBoxModel cmodel = new DefaultComboBoxModel(  );
		
		pack();
		
		setBounds( 300, 300, 300, 300 );
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JComboBoxEx();
	}

}
