package increpas_22_07_15_pm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class NewsBoardEX extends JFrame{
	
	JPanel topP, midP, bottomP;
	
	public NewsBoardEX()	{
		super( "NewsBoard test");
		
		topP = new JPanel();
		midP = new JPanel();
		bottomP = new JPanel();
		
		// setup Windows Layout 
//		setLayout( new GridLayout( 0, 1 ) );
		
		/*******************
		 * Configure Top Panel
		 *******************/
		// make ComboBox
		String[] listData = { "Title", "Author", "content" };
		JComboBox<String> jcombo = new JComboBox<>( listData );
		
		// make ComboBox
		JTextField tf = new JTextField( 10 );
		
		// make ComboBox
		JButton findBtn = new JButton( "Find" );
		
		// add components to top panel
		topP.add( jcombo, BorderLayout.WEST );
		topP.add( tf );
		topP.add( findBtn, BorderLayout.EAST );
		
		/*******************
		 * Configure Middle Panel
		 *******************/
		// make ComboBox
		JTextArea ta = new JTextArea( 10, 25 );
		
		// add components to middle panel
		midP.add( ta, BorderLayout.CENTER );
		midP.setBorder( new TitledBorder( 
						new LineBorder( Color.BLACK, 3 ), "Text Area Contents" ));
		
		/*******************
		 * Configure Bottom Panel
		 *******************/
		// make type Label
		JLabel lb = new JLabel( "Type : " );
		
		// make CheckBox Data
		String[] typeData = { "Society", "Economy", "Sports" };
		
		bottomP.add( lb );		
		
		// make CheckBox data
		// Case 1. use simple array
//		JCheckBox[] typeCheckBox = new JCheckBox[ typeData.length ];
//		
//		for( int idx = 0; idx < typeCheckBox.length; idx++ )	{
//			typeCheckBox[ idx ] = new JCheckBox( typeData[ idx ] );
//			bottomP.add( typeCheckBox[ idx ] );
//		}
		
		// Case 2. use ArrayList
		ArrayList<JCheckBox> typeCheckBox = new ArrayList<>();
		
		for( String name : typeData )	{
			typeCheckBox.add( new JCheckBox( name ) );
			bottomP.add( typeCheckBox.get( typeCheckBox.size() - 1 ) );
		}
		
		/*******************
		 * Merging panels to frame 
		 *******************/
		add( topP, BorderLayout.NORTH );
		add( "Center", midP );
		add( bottomP, BorderLayout.SOUTH );
		
		pack();
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}

	public static void main(String[] args) {
		new NewsBoardEX();

	}

}
