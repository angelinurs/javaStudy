package increpas_22_07_20_am;

import java.awt.*;
import java.awt.event.*;

import javax.crypto.spec.ChaCha20ParameterSpec;
import javax.swing.*;

public class CardChattingLayorEx extends JFrame
								 implements ActionListener {
	// 로그인 하면 채팅창으로 넘어가는 거
	
	CardLayout cl;
	
	JPanel card_1, card_2;

	// main pane components
	JPanel mainCenterPane, mainBottomPane,
		   mainIdPane, mainPasswdPane, mainLogInPane;
	
	ImageIcon mainIcon;
	
	JLabel id_lbl, pw_lbl;
	JTextField id_tf;
	JPasswordField pw_tf;
	
	JButton loginBtn;
	
	// chat pane components
	JPanel chatCenterPane, chatbottomPane;
	
	JTextArea ta;
	
	JTextField tf;
	
	JButton sendBtn;
	
	// flags
	enum CardSection	{
		MAIN, CHAT
	}
	
	String userId;
	CardSection cardSection;
	
	public CardChattingLayorEx() {
		super( "CardChattingLayor" );
		
		cl = new CardLayout();
		getContentPane().setLayout( cl );

		/* *****************************
		 * mainCard
		 * *************************** */
		// main center pane component
		card_1 = new JPanel( new BorderLayout() );
		
		mainCenterPane = new JPanel();
		
		mainIcon = new ImageIcon( "src/IMAGEs/kakao.jpg" );
		
		Image img = mainIcon.getImage();
		mainIcon.setImage(img.getScaledInstance( 280, 370, Image.SCALE_SMOOTH ) );
		
		mainCenterPane.add( new JLabel( mainIcon ) );
		
		card_1.add( mainCenterPane, BorderLayout.CENTER );
		
		// main bottom pane component
		mainBottomPane = new JPanel( new GridLayout( 3, 1 ) );
		
		mainIdPane = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
		
		id_lbl = new JLabel( "ID : " );
		id_tf = new JTextField( 10 );
		
		mainIdPane.add( id_lbl );
		mainIdPane.add( id_tf );
		
		mainPasswdPane = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );

		pw_lbl = new JLabel( "Passwd : " );
		pw_tf = new JPasswordField( 10 );
		
		mainPasswdPane.add( pw_lbl );
		mainPasswdPane.add( pw_tf );
		
		mainLogInPane = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );

		loginBtn = new JButton( "Log-in" );
		mainLogInPane.add( loginBtn );
		
		mainBottomPane.add( mainIdPane );
		mainBottomPane.add( mainPasswdPane );
		mainBottomPane.add( mainLogInPane );
		
		card_1.add( mainBottomPane, BorderLayout.SOUTH );
		
		mainCenterPane.setBackground( Color.CYAN );
		mainIdPane.setBackground( Color.CYAN );
		mainPasswdPane.setBackground( Color.CYAN );
		mainLogInPane.setBackground( Color.CYAN );
		
		getContentPane().add( "main", card_1 );
		
		/* *****************************
		 * chat panel components
		 * *************************** */
		card_2 = new JPanel( ); 
		// textarea in card_ 2
		card_2.add( new JScrollPane( ta = new JTextArea( 22, 25 ) ), BorderLayout.CENTER ); 
		
		chatbottomPane = new JPanel( new BorderLayout() );
		chatbottomPane.add( tf = new JTextField( 18 ), BorderLayout.WEST );
		
		sendBtn = new JButton( "Send" );
		chatbottomPane.add( sendBtn, BorderLayout.EAST );
		
		card_2.add( chatbottomPane, BorderLayout.SOUTH );
		
		getContentPane().add( "chat", card_2 );
		
		pack();
		
		cardSection = CardSection.MAIN;
		
		loginBtn.addActionListener( this );
		sendBtn.addActionListener( this );
		
		
		// main card enter event
		id_tf.addActionListener( this );
		pw_tf.addActionListener( this );
		
		// chat card enter event
		tf.addActionListener(this);
		
		setBounds( 300, 300, 300, 500 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}

	public static void main(String[] args) {
		new CardChattingLayorEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if( o == loginBtn || o == id_tf || o == pw_tf ) {
			String id = id_tf.getText().trim();
			
			if( id.length() < 1 )	{
				JOptionPane.showMessageDialog( this, "input ID" );
				// 공백만 입력했을때 공백 삭제함.
				id_tf.setText( "" );
				// 커서 이동
				id_tf.requestFocus();
				
				return;
			}
			
			String pw = String.valueOf( pw_tf.getPassword() ).trim();
			if( pw.length() < 1 )	{
				JOptionPane.showMessageDialog( this, "input Password" );
				// 공백만 입력했을때 공백 삭제함.
				pw_tf.setText( "" );
				// 커서 이동
				pw_tf.requestFocus();
				
				return;
			}
			
			userId = id;

			cardSection = CardSection.CHAT;
			cl.show( this.getContentPane(), "chat" );
		}
		
		// chat card
		if( ( o == sendBtn || o == tf ) && cardSection == CardSection.CHAT)	{
			String text = tf.getText(); 
			if( text.trim().length() > 0 )	{
				
				ta.append( userId );
				ta.append( " : " );				
				ta.append( text );
				ta.append( "\n" );
				
				tf.setText( "" );
			}
		}
	}
}
