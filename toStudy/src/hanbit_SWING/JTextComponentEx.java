package hanbit_SWING;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*; // import PlainDocument

public class JTextComponentEx extends JFrame {
	public JTextComponentEx()	{
		super( "JTextComponent Test" );
		
		JPanel panel1 = new JPanel();
		
		JTextField field = new JTextField( 5 );
		
		// declare inner class NumberDocument
		class NumberDocument extends PlainDocument {
			
			public void inserSting( int offset, String value, AttributeSet a ) 
					         throws BadLocationException {
				
				char[] valueArr = value.toCharArray();
				
				for( int idx = 0; idx < valueArr.length; idx++ ) {
					if( !Character.isDigit(  valueArr[idx] ) ) {
						getToolkit().beep();
						return;
					}
				}
				
				super.insertString(offset, value, a);
			}
		}
		
		JTextField numberField = new JTextField( 2 );
		numberField.setDocument( new NumberDocument() );
		
		JPasswordField passField = new JPasswordField( 5 );
		
		panel1.add( new JLabel( "Name : " ) );
		panel1.add( field );
		panel1.add( new JLabel( "Age : " ) );
		panel1.add( numberField );
		panel1.add( new JLabel( "Password : " ) );
		panel1.add( passField );
		
		JPanel panel2 = new JPanel( new BorderLayout() );
		
		JTextArea textArea = new JTextArea( 5, 10 );
		textArea.setLineWrap( true );
		JScrollPane tscroll = new JScrollPane( textArea, 
											   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
											   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		
		panel2.add( "North", new JLabel( "자기소개" ) );
		panel2.add( "Center", tscroll );
		
		add( "North", panel1 );
		add( "Center", panel2 );
				
		pack();
		
		setBounds( 300, 300, 350, 300 );
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTextComponentEx();
	}

}
