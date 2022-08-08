package increpas_22_07_20_am;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ArrangeButtonEx extends JFrame 
							 implements ActionListener {
	JButton left_b, center_b, right_b;
	JPanel top_p;
	
	public ArrangeButtonEx() {
		super( "ArrangeButton Test." );
		
		top_p = new JPanel( new FlowLayout( FlowLayout.CENTER) );
		
		left_b   = new JButton( "Left" );
		center_b = new JButton( "Center" );
		right_b  = new JButton( "Right" );
		
		top_p.add( left_b );
		top_p.add( center_b );
		top_p.add( right_b );
		
		add( top_p, BorderLayout.NORTH );
		
		left_b.addActionListener( this );
		center_b.addActionListener( this );
		right_b.addActionListener( this );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}

	public static void main(String[] args) {
		new ArrangeButtonEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if( o == left_b )	{
//			top_p.setAlignmentX( Component.LEFT_ALIGNMENT );
			top_p.setLayout( new FlowLayout( FlowLayout.LEFT) );
		} else if( o == center_b )	{
//			top_p.setAlignmentX( Component.CENTER_ALIGNMENT );
			top_p.setLayout( new FlowLayout( FlowLayout.CENTER ) );
		} else if( o == right_b )	{
//			top_p.setAlignmentX( Component.RIGHT_ALIGNMENT );
			top_p.setLayout( new FlowLayout( FlowLayout.RIGHT) );
		}
		
		System.out.println( e.getActionCommand() );
		top_p.updateUI();
	}
}
