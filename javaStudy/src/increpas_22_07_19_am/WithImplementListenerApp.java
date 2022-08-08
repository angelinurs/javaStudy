package increpas_22_07_19_am;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WithImplementListenerApp extends JFrame 
											  implements ActionListener, KeyListener {
	final int size = 9;
	ArrayList<JButton> btns;
	ArrayList<JButton> selBtns;
	ArrayList<JButton> ballBtns;
	
	
	String[] gameType = { "구구단", "야구게임" };
	
	JPanel topPanel;
	JPanel botPanel;
	
	GridLayout grid;
	
	JTextArea ta;
	
	public WithImplementListenerApp() {
		
		super( "Abstract test" );	
		
//		topPanel = new JPanel( new GridLayout( 1, 2 ) );
//		
//		selBtns = new ArrayList<>();
//		for( int idx = 0; idx < 2; idx++ ) {
//			selBtns.add( new JButton( gameType[ idx ] ) );
//			topPanel.add( selBtns.get(idx) );
//			
//			// 설정한 actionListener Object assign 
//			// ** Object -> this 사용.
//			selBtns.get( idx ).addActionListener( this );
//		}
//		
//		add( topPanel, BorderLayout.NORTH );
		
		ta = new JTextArea();
		
		ta.addKeyListener( this );
		
		add( new JScrollPane( ta ) );
		
		// default side panel
		createPanel( "구구단" );
		add( botPanel, BorderLayout.WEST );
		
		pack();
		
		setBounds( 300, 300, 500, 500 );
		setVisible( true );
		
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	/* getActionPerformed button click
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
	*/
	
	public void actionPerformed(ActionEvent e) {
		
		String tmp = e.getActionCommand();		
		
		if( tmp == "구구단" )	{
			botPanel.removeAll();
			botPanel.updateUI();
			createPanel( tmp );
		}
		
		// 구구단이 선택되었을때,
		if( tmp.length() == 1  ) {
			if( 9 >= Integer.parseInt( tmp ) && 2 <= Integer.parseInt( tmp ) )
				ta.setText( appGugu( Integer.parseInt( tmp ) ) );
		}
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
	
	
	// select panel reset and draw
	public void createPanel( String panelTitle ) {
		if( panelTitle == "구구단" )	{
			
//			grid = new GridLayout( 1, 4 );		
//			botPanel = new JPanel( grid );
			
			botPanel = new JPanel( new GridLayout( size+2, 1 ) );
//			botPanel = new JPanel( new GridLayout( 1, 4 ) );
//			midPanel.setSize(200, 200);
			
			btns = new ArrayList<>();
			
			botPanel.add( new JLabel( "Dan" ) );
			for( int idx = 0; idx < size-1; idx++ ) {
				btns.add( new JButton( String.valueOf( idx + 2 ) ) );
				botPanel.add( btns.get(idx) );
				
				// 설정한 actionListener Object assign 
				// ** Object -> this 사용.
				btns.get( idx ).addActionListener( this );
			}
		}
	}
	
	public String appGugu( int dan ) {
		StringBuffer sb = new StringBuffer();
		
		sb.append( String.format("=== %2d 단 ===\n", dan ) );
		for( int idx = 0; idx < size; idx++ )	{
			sb.append( String.format("%2d x%2d =%3d\n",dan, idx + 1, dan*(idx+1) ) );
		}
		
		return sb.toString(); 
	}	

	public static void main(String[] args) {
		new WithImplementListenerApp();
	}
}
