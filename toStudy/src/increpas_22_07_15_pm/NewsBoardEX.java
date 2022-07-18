package increpas_22_07_15_pm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class NewsBoardEX extends JFrame{
	
//	JPanel topP, midP, bottomP;
	JPanel topP, bottomP;
	JScrollPane midP;
	
	public NewsBoardEX()	{
		super( "NewsBoard test");
		
		topP = new JPanel();
//		midP = new JPanel();
		midP = new JScrollPane();
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
		JTextArea ta = new JTextArea( 20, 20 );
		
		// add components to middle panel
		// Case 1. 생성과 동시에 component 삽입
//		midP = new JScrollPane( ta );
		
		// Case 2. 생성후 component 삽입
		midP = new JScrollPane();
		midP.setViewportView( ta ); //이렇게 할 경우 프로그램상에서 textarea 가 안보임.
		
		midP.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
		midP.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		
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
		add( topP, BorderLayout.NORTH ); // 이런 방식을 더 많이 씀. 기존에 정의되어 있는 값 사용.
		add( "Center", midP ); // 이 방식은 불필요하게 String object 를 생성함.
		add( bottomP, BorderLayout.SOUTH );
		
		pack();
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		
		/*
		 *  아래의 코드는 현재 작업 상태가 저장이 안되고 바로 종료 함.
		 *  그래서 개선이 필요하다.
		 *  예를 들어 종료시 현재까지 작업을 저장할지 여부 확인 알람정도는 띄워줘햐 한다.
		 */
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}

	public static void main(String[] args) {
		new NewsBoardEX();

	}

}
