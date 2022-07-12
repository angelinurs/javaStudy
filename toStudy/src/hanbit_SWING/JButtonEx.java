package hanbit_SWING;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JButtonEx extends JFrame {
	public JButtonEx()	{
		super( "Swing Button Test" );
		
		setLayout( new GridLayout( 0, 1 ) );
		
		// 1st Panel -> button
		JPanel buttonPanel = new JPanel();
		
		JButton b1 = new JButton( "Button" );
		JButton b2 = new JButton( "Action" );
		
		b2.setMnemonic( 'a' );
		
		ImageIcon icon1 = new ImageIcon( "IMAGES/icon2.jpg" );
		ImageIcon icon2 = new ImageIcon( "IMAGES/icon.png" );
		
		JButton b3 = new JButton( icon1 );
		
		b3.setPressedIcon( icon2 );
		b3.setMnemonic( 'b' );
		
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(b3);
		
		// 2nd Panel -> toggle
		JPanel togglePanel = new JPanel();
		
		togglePanel.setBorder( new TitledBorder( new EtchedBorder( EtchedBorder.RAISED ) ) );
		
		JToggleButton tbutton1 = new JToggleButton( "ONE" );
		JToggleButton tbutton2 = new JToggleButton( "TWO" );
		JToggleButton tbutton3 = new JToggleButton( "THREE" );
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(tbutton1);
		group.add(tbutton2);
		group.add(tbutton3);
		
		tbutton1.setSelected(true);
		
		togglePanel.add(tbutton1);
		togglePanel.add(tbutton2);
		togglePanel.add(tbutton3);
		
		// 3rd Panel -> select
		JPanel selectPanel = new JPanel();
		JCheckBox check = new JCheckBox( "checkbox" );
		JRadioButton rb = new JRadioButton( "radio" );
		
		selectPanel.add( check );
		selectPanel.add( rb );
		
		// 4th Panel -> radio
		JPanel radioPanel = new JPanel();
		
		radioPanel.setBorder( new TitledBorder( 
							  	new LineBorder( Color.black, 3 ), "Radio Group" )
				             );
		
		ButtonGroup radioGroup = new ButtonGroup();
		
		JRadioButton rb1 = new JRadioButton( "ONE" );
		JRadioButton rb2 = new JRadioButton( "TWO" );
		JRadioButton rb3 = new JRadioButton( "THREE" );
		
		radioGroup.add(rb1);
		radioGroup.add(rb2);
		radioGroup.add(rb3);
		radioPanel.add(rb1);
		radioPanel.add(rb2);
		radioPanel.add(rb3);
		
		rb1.setSelected( true );
		
		// 5th Panel -> textarea
		JPanel textareaPanel = new JPanel();
		
		textareaPanel.setBorder( new TitledBorder( 
							  	new LineBorder( Color.black, 3 ), "Textarea" )
				             );
		JTextArea ta = new JTextArea(5, 22);
		textareaPanel.add(ta);
		
		add( buttonPanel );
		add( togglePanel );
		add( selectPanel );
		add( radioPanel );
		add( textareaPanel );
		
		pack();
		
		setBounds( 300, 300, 300, 600 );
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JButtonEx();
	}

}
