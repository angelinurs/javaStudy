package increpas_22_07_15_pm;

import javax.swing.*;

public class JButtonEX extends JFrame{
	JButton[] bts;
	JPanel jp;
	
	public JButtonEX()	{
		super( "JButton & JPanel test");
		
		bts = new JButton[3];
		jp = new JPanel();
		
		for( int idx = 0; idx < bts.length; idx++ ) {
			bts[ idx ] = new JButton( "Button_" + String.valueOf( idx+1 ) );
			jp.add( bts[ idx ] );
		}
		
		add("South", jp );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}

	public static void main(String[] args) {
		new JButtonEX();

	}

}
