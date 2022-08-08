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
		
		// First ComboBox create
		// - list
		String[] listData = { "ONE", "TWO", "THREE", "FOUR", "FIVE" };
		JComboBox combo = new JComboBox( listData );
		
		add( combo );
		
		// Second ComboBox create
		// - ComboBoxModel
		DefaultComboBoxModel cmodel = new DefaultComboBoxModel(  );
		
		cmodel.addElement( "Chicken" );
		cmodel.addElement( "Potato" );
		
		combo = new JComboBox();
		combo.setModel(cmodel);
		
		add( combo );
		
		// Third ComboBox create
		// - another ComboBoxModel
		DefaultComboBoxModel cxmodel = new DefaultComboBoxModel(  );
		
		cxmodel.addElement( "Coke" );
		cxmodel.addElement( "Coffee" );
		cxmodel.addElement( "Juisce" );
		
		combo = new JComboBox();
		combo.setModel(cxmodel);
		
		add( combo );
		
		pack();
		
		setBounds( 300, 300, 300, 300 );
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JComboBoxEx();
	}

}
