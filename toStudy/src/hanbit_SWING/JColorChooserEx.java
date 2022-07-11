package hanbit_SWING;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class JColorChooserEx extends JFrame
							implements ActionListener {
	
	JMenuBar mb = new JMenuBar();
	JMenu mnuselect = new JMenu( "Select" );
	JMenuItem mnucolor = new JMenuItem( "Color" );
	JLabel l = new JLabel( "Print Window" );
	JTextArea ta = new JTextArea();
	
	public JColorChooserEx()	{
		super( "JColorChooser test" );
		
		mnuselect.add( mnucolor );
		
		mb.add( mnuselect );
		
		setJMenuBar( mb );
		
		add( "North", l );
		add( "Center", ta );
		
		setBounds( 300, 300, 300, 200 );
		setVisible( true );
		
		mnucolor.addActionListener( this );
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == mnucolor )	{
			JColorChooser chooser = new JColorChooser();
			
			Color col = chooser.showDialog(this, "Choose Color", Color.BLUE );
			l.setText( "선택한 색상은 " + col );
			ta.setBackground( col );
		}
	}

	public static void main(String[] args) {
		new JColorChooserEx();

	}
}
