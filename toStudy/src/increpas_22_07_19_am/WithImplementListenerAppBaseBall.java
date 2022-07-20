package increpas_22_07_19_am;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
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

public class WithImplementListenerAppBaseBall extends JFrame 
											  implements ActionListener, KeyListener {
	final int size = 10;
	ArrayList<JButton> btns;
	ArrayList<JButton> selBtns;
	ArrayList<JButton> ballBtns;
	
	String[] gameType = { "구구단", "야구게임" };
	
	JPanel topPanel;
	JPanel botPanel;
	
	GridLayout grid;
	
	JTextArea ta;
	
	Baseball bball;
	ArrayList<Integer> userCount;
	
	public WithImplementListenerAppBaseBall() {
		
		super( "Abstract test" );
		
		ta = new JTextArea();
		
		ta.addKeyListener( this );
		
		add( new JScrollPane( ta ) );
		
		// default side panel
		createPanel( "야구게임" );
		add( botPanel, BorderLayout.WEST );
		
		pack();
		
		setBounds( 300, 300, 500, 500 );
		setVisible( true );
		
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String tmp = e.getActionCommand();		
		
		if( tmp == "야구게임" || tmp == "Restart" )	{
			// 기존 panel component 전부 삭제
			botPanel.removeAll();		
			
			// panel 에 새롭게 셋팅
			createPanel( tmp );
			
			// component 업데이트 후 반영함.
			botPanel.updateUI();
		}
		
		if( tmp == "Restart" )	{
			ta.setText( "" );
			
			// 야구게임을 시작하면 유전에게 입력받을 ball number 를 3개까지 저장
			userCount = new ArrayList<>();
			bball = new Baseball();
			ta.setText( bball.getZone() );
			ta.append( "\n" );
			ta.append( bball.msg() );
			ta.append( "\n" );
		}
		
		// 야구게임이 선택 되었을때,
		if( tmp.length() == 1  ) {
			
			ta.append( tmp );
			ta.append( " " );
			
			
			System.out.printf( "size : %d, number : %d \n", userCount.size(), Character.getNumericValue( tmp.charAt(0) ) );
			
			userCount.add( Character.getNumericValue( tmp.charAt(0) ) );
			
			if( userCount.size() != 0 && userCount.size() % 3 == 0 )	{
				System.out.println( userCount );
				bball.setUser( userCount );
				bball.play();
				ta.append( bball.show_stat() );
				ta.append( "\n" );				
				
				if( bball.getStrikeCount() == 3 )	{
					ta.append( "축하합니다.\n" );
					return;
				}
				
				ta.append( bball.msg() );
				
				userCount.clear();
			
			}
		}
	}

	// select panel reset and draw
	public void createPanel(String panelTitle ) {
		if( panelTitle == "야구게임" )	{
			
			botPanel = new JPanel( new GridLayout( size+1, 1 ) );
			
			btns = new ArrayList<>();
			
			btns.add( new JButton( "Restart" ) );
			botPanel.add( btns.get( 0 ) );

			btns.get( 0 ).addActionListener( this );

			for( int idx = 0; idx < size; idx++ ) {
				btns.add( new JButton( String.valueOf( idx ) ) );
				
				botPanel.add( btns.get(idx + 1) );

				btns.get( idx + 1 ).addActionListener( this );
			}
			
			// 야구게임을 시작하면 유전에게 입력받을 ball number 를 3개까지 저장
			userCount = new ArrayList<>();
			bball = new Baseball();
			ta.setText( bball.getZone() );
			ta.append( "\n" );
			ta.append( bball.msg() );
			ta.append( "\n" );
		}
	}
	
	public static void main(String[] args) {
		new WithImplementListenerAppBaseBall();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		String line = ta.getText();
//		System.out.println( line );
		
		if( line.length() != 0 && line.length() % 20 == 0 )
			ta.append( "\n\r" );
	}

	@Override
	public void keyPressed(KeyEvent e) { }

	@Override
	public void keyReleased(KeyEvent e) { }
}

