package hanbit_SWING;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class JEditorPaneEx extends JFrame {
	
	public JEditorPaneEx() throws IOException {
		super( "JEditorPane test" );
		
		JEditorPane editorPane = new JEditorPane();
//		editorPane.setEditable( false );
		editorPane.setEditable( true );
		
//		editorPane.setPage( "https://raw.githubusercontent.com/angelinurs/javaStudy/main/toStudy/src/hanbit_class/StaticInner.java" );
		editorPane.setPage( "http://www.hanbitbook.co.kr/" );
		
		JScrollPane sp = new JScrollPane( editorPane );
		sp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
		sp.setPreferredSize( new Dimension(800, 600) );
		
		add( sp );
		pack();
		
		setLocation( 300, 200 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public static void main(String[] args) throws IOException {
		new JEditorPaneEx();
	}
}
