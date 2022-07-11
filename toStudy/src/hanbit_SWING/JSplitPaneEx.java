package hanbit_SWING;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JSplitPaneEx extends JFrame {
	
	// ? splitPane1 이 왜 존재하는지 상당히 의문스러음.
	JSplitPane splitPane, splitPane1;
	
	public JSplitPaneEx()	{
		super( "JsplitPane test" );
		
		JTextArea jta1 = new JTextArea( 20, 10 );
		JScrollPane jtalScrollpane = new JScrollPane( jta1 );
		
		JTextArea jta2 = new JTextArea( 20, 10 );
		JScrollPane jta2Scrollpane = new JScrollPane( jta2 );
		
		splitPane = new JSplitPane( JSplitPane.VERTICAL_SPLIT, 
									jtalScrollpane, jta2Scrollpane );
		
		JTextArea jta3 = new JTextArea( 20, 10 );
		JScrollPane jta3Scrollpane = new JScrollPane( jta3 );
		
		splitPane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, 
									splitPane, jta3Scrollpane );
		
		splitPane.setOneTouchExpandable( true );
		splitPane.setDividerLocation( 100 );
		splitPane.setPreferredSize( new Dimension( 200, 200 ) );
//		splitPane1.setPreferredSize( new Dimension( 400, 200 ) );
		
		// 아래 주석처리 된 부분은 처리 되지 않으므로 자의적 코드 교환.
		// add( splitPane1 );
		add( splitPane );
		pack();
		setVisible( true );
	}

	public static void main(String[] args) {
		new JSplitPaneEx();
	}

}
