package hanbit_SWING;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.text.*;
import javax.swing.*;

// 창 크기가 작게 나오는 문제.
// 버튼 아이콘이 안나오는 문제.

public class JTextPaneEx extends JFrame {
	
	public JTextPaneEx() {
		JTextPane textPane = createTextPane();
		
		JScrollPane sp = new JScrollPane( textPane );
		
		sp.setPreferredSize( new Dimension( 250, 250 ) );
		add( sp );
		
		setTitle( "JTextPaneEx" );
		setLocation( 300, 200 );
		setSize(300, 300);
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	private JTextPane createTextPane()	{
		String newline = "\n";
		
		String[] initString = {
				"This is Regular" + newline,
				"This is Italic" + newline,
				"This is Bold"   + newline,
				" " + newline,
				" " + newline,
			};
		
		String[] initStyles = { "Regular", "Italic", "Bold", 
								"Button", "Icon" };
		
		JTextPane textPane = new JTextPane();
		
		StyledDocument sdoc = textPane.getStyledDocument();

		addStyleToDocument(sdoc);
		
		try {
			for( int i = 0; i < initString.length; i++ ) {
				sdoc.insertString( 
								   sdoc.getLength(), 
								   initString[i], 
								   sdoc.getStyle( initStyles[i] ) 
								 );
			}
		} catch ( Exception ble ) {
			ble.printStackTrace();
		}
		
		return textPane;
	}
	
	protected void addStyleToDocument( StyledDocument sdoc ) {
		// initialize some styles.
		Style style = StyleContext.getDefaultStyleContext().
								   getStyle( StyleContext.DEFAULT_STYLE );
		
		Style regular = sdoc.addStyle("regular", style);
		StyleConstants.setFontFamily( style, "SansSerif" );
		
		Style s = sdoc.addStyle( "Italic", regular );
		StyleConstants.setItalic( s, true );
		
		s = sdoc.addStyle( "bold", regular );
		StyleConstants.setBold(s, true );
		
		s = sdoc.addStyle( "Icon", regular );
		StyleConstants.setAlignment(s, StyleConstants.ALIGN_CENTER );
		
		ImageIcon pigIcon = new ImageIcon( "IMAGES/icon.png" );
		
		if( pigIcon != null ) {
			StyleConstants.setIcon(s, pigIcon);
		} 
		
		// 하단의 버튼 아이콘 안보임.
		
		s = sdoc.addStyle("button", regular );
		StyleConstants.setAlignment( s, StyleConstants.ALIGN_CENTER );
		
		ImageIcon soundIcon = new ImageIcon( "IMAGES/icon2.jpg" );
		
		JButton button = new JButton(soundIcon);
		
		if( button != null )	{
			button.setIcon( soundIcon );
		} else	{
			button.setText( "BEEP" );
		}
		
		button.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				Toolkit.getDefaultToolkit().beep();
			}
		});
		
		StyleConstants.setComponent( s, button );
	}
	public static void main(String[] args) throws IOException {
		new JTextPaneEx();
	}
}
