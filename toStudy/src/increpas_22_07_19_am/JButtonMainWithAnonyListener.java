package increpas_22_07_19_am;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JButtonMainWithAnonyListener extends JFrame {
	
	ArrayList<JButton> btns;
	JPanel botPanel;
//	JPanel midPanel;
	GridLayout grid;
	
	public JButtonMainWithAnonyListener() {
		
		super( "Abstract test" );		
		
//		grid = new GridLayout( 1, 4 );		
//		botPanel = new JPanel( grid );
		
		botPanel = new JPanel( new GridLayout( 6, 1 ) );
//		botPanel = new JPanel( new GridLayout( 1, 4 ) );
//		midPanel = new JPanel();
//		midPanel.setSize(200, 200);
		
		// declare and binding implemented action listener 
		ActionListener act = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setTitle( e.getActionCommand() );
			}
		};
		
		btns = new ArrayList<>();
		
		botPanel.add( new JLabel() );
		for( int idx = 0; idx < 4; idx++ ) {
			btns.add( new JButton( String.valueOf( idx + 1 ) ) );
			botPanel.add( btns.get(idx) );
			
			// 설정한 actionListener Object assign
			btns.get( idx ).addActionListener(act);
		}
		
//		add( midPanel );
//		add( botPanel, BorderLayout.SOUTH );
		add( botPanel, BorderLayout.WEST );
		pack();
		
		setBounds( 300, 300, 500, 500 );
		setVisible( true );
		
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}

	public static void main(String[] args) {
		new JButtonMainWithAnonyListener();
	}
}
