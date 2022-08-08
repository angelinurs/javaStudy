package increpas_22_07_22_pm;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class SwingBaseballMain extends JFrame implements ActionListener {
	
	// game app
	Baseball bs;
	
	// northPane
	JPanel northPane;
	
	JLabel     lb_1, lb_2, lb_3;
	JTextField tf_1, tf_2, tf_3;
	JButton confirmBtn;
	
	// center
	JTextArea ta;
	
	// southPane
	JPanel southPane;
	JButton resetBtn;
	
	public SwingBaseballMain()	{
		bs = new Baseball();
		
		StringBuffer sb = new StringBuffer();
		sb.append( "com : " ).append( bs.getZone() );
		
		setTitle( sb.toString() );
		
		setNorthPane();
		
		add( new JScrollPane( ta = new JTextArea( 20, 20 ) ), BorderLayout.CENTER );
		
		setSouthPane();
		
		setBounds( 300, 300, 400, 300 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	public void setNorthPane() {
		northPane = new JPanel();
		
		lb_1 = new JLabel( "number 1 : " );
		tf_1 = new JTextField( 2 ); 
		
		lb_2 = new JLabel( "number 2 : " );
		tf_2 = new JTextField( 2 ); 
		
		lb_3 = new JLabel( "number 3 : " );
		tf_3 = new JTextField( 2 ); 
		
		confirmBtn = new JButton( "Confirm" );
		
		northPane.add( lb_1 );
		northPane.add( tf_1 );
		northPane.add( lb_2 );
		northPane.add( tf_2 );
		northPane.add( lb_3 );
		northPane.add( tf_3 );
		northPane.add( confirmBtn );
		
		add( northPane, BorderLayout.NORTH );
		
		confirmBtn.addActionListener( this );
		
	}
	
	public void setSouthPane() {
		southPane = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
		resetBtn = new JButton( "Reset" );
		
		southPane.add( resetBtn );
		
		add( southPane, BorderLayout.SOUTH );
		
		resetBtn.addActionListener( this );
	}
	

	public static void main(String[] args) {
		new SwingBaseballMain();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		ArrayList<Integer> user = new ArrayList<>();
		
		if( o == confirmBtn ) {
			
			user.add( Integer.parseInt( tf_1.getText() ) );
			user.add( Integer.parseInt( tf_2.getText() ) );
			user.add( Integer.parseInt( tf_3.getText() ) );
			
			tf_1.setText( "" );
			tf_2.setText( "" );
			tf_3.setText( "" );
			
			bs.setUser( user );
			
			bs.play();
			
			ta.append( bs.msg() );
			
			ta.append( bs.show_stat() );
		}
		
		if( o == resetBtn ) {
			bs.setZone();
			
			setTitle( bs.getZone() );
			
			tf_1.setText( "" );
			tf_2.setText( "" );
			tf_3.setText( "" );
			
			ta.setText( "" );
		}
		
	}

}
