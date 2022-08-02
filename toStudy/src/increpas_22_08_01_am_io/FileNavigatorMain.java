package increpas_22_08_01_am_io;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.*;

public class FileNavigatorMain extends JFrame {
	
	JPanel topPane;
	JScrollPane mainPane;
	
	JLabel pathLabel;
	JTextField tf;
	JButton backwardBtn;
	JButton parentBtn;
	
	JList<String> navi;
	
	Font font;
	
	String presentPath;
	String[] folders;
	
	Stack<String> history;
	
	
	public FileNavigatorMain() {
		super( "FileNavigator" );
		
		// 탐색한 디렉터리 기록
		history = new Stack<>();
		
		font = new Font( "serif", Font.BOLD, 12 );
		
		setLayout( new FlowLayout() );
		
		setTopPane();
		setMainPane();
		
		setBounds( 300, 300, 350, 500 );
		setVisible( true );
		
		
		// window closing envet 
		addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
		});
		
		backwardBtn.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				if( history.size() > 0 ) {
					// pop 을 두번 하는 이유는 ? 
					// getFilelist 에서 마지막에 탐색한 주소를 다시 push 해주기 때문이다.
					history.pop();
					getFilelist( history.pop() );
				}
			}
		});
		
		parentBtn.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				if( history.size() > 0 ) {
					getFilelist( new File(presentPath).getParent() );
//					System.out.println( new File(presentPath).getParent() );
				}
			}
		});
		
		tf.addKeyListener( new KeyAdapter() {

			@Override public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				if( key == KeyEvent.VK_ENTER )
					getFilelist( tf.getText().trim() );
			}
			
		});
		
		navi.addMouseListener( new MouseAdapter() {

			@Override public void mouseClicked(MouseEvent e) {
				if( e.getClickCount() == 2 ) {
//					String selectedValue = navi.getSelectedValue();
					
					int index = navi.locationToIndex( e.getPoint() );
					
					if( index >= 0 ) {
						Object o = navi.getModel().getElementAt(index);
						
						// ".." 처리
						if( o.toString().equalsIgnoreCase( ".." ) ) {
							
//							if( presentPath.equals( "c:\\" ) ) return;
//							else {
//								getFilelist( new File( presentPath ).getParent() );
//								return;
//							}
							// same code
							if( !presentPath.equals( "c:\\" ) ) {
								getFilelist( new File( presentPath ).getParent() );
							}
							return;
						}
						
						System.out.println( o.toString() );
						System.out.println( presentPath );
						
						File present = new File( presentPath );
						File select = new File( present, o.toString() );
						
						getFilelist( select.getPath() );
					}
				}
			}
			
		});
	}
	
	void setTopPane()	{
		topPane = new JPanel( new FlowLayout() );
		
		topPane.add( pathLabel = new JLabel( "PATH : " ) );
		
		pathLabel.setFont( font );
		
		topPane.add( tf = new JTextField( 15 ) );
		topPane.add( backwardBtn = new JButton( "<<" ));
		topPane.add( parentBtn = new JButton( "UP" ));
		
		add( topPane );
	}
	
	void setMainPane() {
		mainPane = new JScrollPane(navi = new JList<String>());
		
		add( mainPane );
	}
	
	void getFilelist( String filename )	{
		
		File path = new File( filename );
		
		if( !path.exists() )	{
//			System.out.println( "Not exist." );
			JOptionPane.showMessageDialog( this , "Not exist." );
			return;
		}
		
		if( !path.isDirectory() ) {
			System.out.println( "Not a directory." );
			JOptionPane.showMessageDialog( this , "Not a directory." );
			return;
		}
		
		try {
//			String[] filelist = path.list();
			File[] filelist = path.listFiles();
			
			ArrayList<String> ar = new ArrayList<>();
			ar.add( ".." );
			for( int idx = 0; idx < filelist.length; idx++ )	{
				if( filelist[ idx ].isDirectory() && !filelist[ idx ].isHidden() )
					ar.add( filelist[ idx ].getName() );
			}
			
			// Case 01.
			// 파라미터 a의 길이는 0으로 지정하면 알아서 list의 길이에 맞게 조정되어 folders 에 저장된다.
			folders = ar.toArray( new String[0] );
			
			// Case 02.
	//		folders = new String[ ar.size() ];
	//		folders = ar.toArray( folders] );
			
			navi.setListData( folders );
			
			tf.setText( path.getPath() );
			
			presentPath = path.getPath();
			
			System.out.println( history.toString() );
			System.out.println( history.size() );
			history.push( presentPath );
			
		} catch ( NullPointerException npe) {
			JOptionPane.showMessageDialog( this , "해당 디렉터리 접근 불가!!" );
		}
	}

	public static void main(String[] args) {
		new FileNavigatorMain();
	}

}
