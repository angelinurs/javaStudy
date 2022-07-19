package increpas_22_07_19_am;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JButtonMainWithImplementListener extends JFrame 
											  implements ActionListener, KeyListener {
	
	ArrayList<JButton> btns;
	JPanel botPanel;
//	JPanel midPanel;
	GridLayout grid;
	JTextArea ta;
	
	public JButtonMainWithImplementListener() {
		
		super( "Abstract test" );		
		
//		grid = new GridLayout( 1, 4 );		
//		botPanel = new JPanel( grid );
		
		botPanel = new JPanel( new GridLayout( 6, 1 ) );
//		botPanel = new JPanel( new GridLayout( 1, 4 ) );
//		midPanel = new JPanel();
//		midPanel.setSize(200, 200);
		
		btns = new ArrayList<>();
		
		botPanel.add( new JLabel() );
		for( int idx = 0; idx < 4; idx++ ) {
			btns.add( new JButton( String.valueOf( idx + 1 ) ) );
			botPanel.add( btns.get(idx) );
			
			// 설정한 actionListener Object assign 
			// ** Object -> this 사용.
			btns.get( idx ).addActionListener( this );
		}
		
//		add( midPanel );
//		add( botPanel, BorderLayout.SOUTH );
		add( botPanel, BorderLayout.WEST );
		
		ta = new JTextArea();
		
		ta.addKeyListener( this );
		
		add( new JScrollPane( ta ) );
		pack();
		
		setBounds( 300, 300, 500, 500 );
		setVisible( true );
		
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String tmp = e.getActionCommand();
		
		setTitle( tmp );
		
		ta.append(tmp);
		
//		ta.setText(tmp);
		
		String line = ta.getText();
//		System.out.println( line );
		
		if( line.length() != 0 && line.length() % 20 == 0 ) {
			
			ta.append( "\n\r" );
		}
	}

	public static void main(String[] args) {
		new JButtonMainWithImplementListener();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		String line = ta.getText();
//		System.out.println( line );
		
		if( line.length() != 0 && line.length() % 20 == 0 ) {
			
			ta.append( "\n\r" );
		}
	}

	@Override
	public void keyPressed(KeyEvent e) { }

	@Override
	public void keyReleased(KeyEvent e) { }
}
