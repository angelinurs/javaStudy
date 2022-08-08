package hanbit_SWING;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTabbedPaneEx extends JFrame {
	
	ImageIcon icon1, icon2, tabicon;
	JButton b1,b2, b3;
	JTabbedPane jp;
	
	public JTabbedPaneEx()	{
		super( "JTabbedPane test");
		
		icon1 = new ImageIcon("IMAGE/icon.png");
		icon2 = new ImageIcon("IMAGE/icon2.jpg");
		
		tabicon = new ImageIcon("IMAGE/icon3.jpg");
		
		b1 = new JButton("picture_1", icon1);
		b2 = new JButton("picture_2", icon2);
		
		jp = new JTabbedPane();
		
		jp.addTab( "Tab_1", new ImageIcon(""), b1 );
		jp.addTab( "Tab_2", new JPanel().add( new JTextArea(7, 20) ) );
		jp.addTab( "Tab_3", tabicon, b2, "add tab_picture" );
		
		add( jp );
		
		setBounds( 300, 300, 300, 300 );
		setVisible(true);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	

	public static void main(String[] args) {
		new JTabbedPaneEx();

	}

}
