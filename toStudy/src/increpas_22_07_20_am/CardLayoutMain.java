package increpas_22_07_20_am;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class CardLayoutMain extends JFrame 
							implements ActionListener {
	
	CardLayout cl;
	
	JPanel card_1, card_2;
	
	// components of Card_1
	JPanel north_p;
	JButton north_btn;
	
	// components of Card_2
	ImageIcon icon;
	Image img;
	
	JPanel south_p;
	JButton south_btn;

	public CardLayoutMain() {
		super( "CardLayout test" );
		
		cl = new CardLayout();
		getContentPane().setLayout( cl );
		
		// first screen
		card_1 = new JPanel( new BorderLayout() );
		north_p = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
//		
//		north_btn = new JButton( "Next" );
//		north_p.add( north );
		
		north_p.add( north_btn = new JButton( "Next" ) );
		
		card_1.add( north_p, BorderLayout.NORTH );
		
		/*
		 * 카드 레이아숭리 현재 객체의 contenPane 에 적용되었으니 화면도 
		 * 
		 * ContentPane 에 적용해야 한다. 이름은 card_1 이라고 지정한다.
		 */
		getContentPane().add( "Card_1", card_1 );
		
		// second screen
		card_2 = new JPanel( new BorderLayout() );
		south_p = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
		
		south_p.add( south_btn = new JButton( "Prev" ) );
		
		card_2.add( south_p, BorderLayout.SOUTH );
		
		String filename = "src/IMAGES/icon.png";
		
		icon = new ImageIcon( filename );
		card_2.add( new JLabel( "Prev" ) );
		
		getContentPane().add( "Card_2", card_2 );
		
		north_btn.addActionListener( this );
		south_btn.addActionListener( this );
		
		// 강제로 card_2 panel 보이기 설정
		cl.show( getContentPane(), "Card_1" );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}

	public static void main(String[] args) {
		new CardLayoutMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Case 1. e.getActionCommand()
//		String cmd = e.getActionCommand();
//				
//		if( cmd == "Prev" )
//			cl.show( getContentPane(),  "Card_1" );
//		else if ( cmd == "Next" )
//			cl.show( getContentPane(),  "Card_2" );
		
		Object obj = e.getSource();
		
		// Case 2. e.getSource();
		// ==
		if( obj == north_btn )
			cl.show( getContentPane(),  "Card_2" );
		else if ( obj == south_btn )
			cl.show( getContentPane(),  "Card_1" );
	}
}
