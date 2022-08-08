package increpas_22_08_05_pm_serialize;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.File;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/* ***********************
 * - Word class
 */
class WordVO extends Thread	{
	
	// properties
	int x, y = -30;
	int width, height = 20;
	int speed;
	
	String text;
	Color c;
	
	WordBreak frame;

	public WordVO( String text, WordBreak frame) {

		this.text = text;
		this.frame = frame;
		
		this.x = (int)( Math.random() * ( frame.mainPane.getSize().width - 100 ) );
		this.speed = (int)( Math.random() * 2 + 1 );
		
		this.c = new Color(
					(int)( Math.random() * 256 ),	// red
					(int)( Math.random() * 256 ),	// green
					(int)( Math.random() * 256 )	// blue
				); 
	}

	@Override public void run() {
		
		while( true ) {
			y += speed;
			
			if( y > frame.mainPane.getHeight() - 16 ) {
				break;
			}
			
			frame.mainPane.repaint();
			
			try {
				Thread.sleep( 100 );
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		// Thread 가 소멸되기 직전 현재 WordVO 객체를 저장된 ArrayList 로부터 삭제함.
		frame.wordList.remove( this );
	}
};

/* ***********************
 * - Main class
 */
public class WordBreak extends JFrame {
	
	JPanel mainPane;
	JPanel topPane;
	JPanel bottomPane;
	
//	CopyOnWriteArrayList<WordVO> words;
	ArrayList<WordVO> words;
	
	JTextField inputTf;
	JButton startBtn, confirmBtn;
	
	JLabel scoreLabel;
	int score;
	
	Font font; 
	
	// 시작 버튼을 클릭할때 생성되어 구동되는 Thread object
	Thread thread;
	int dropTime = 1000;
	
	// true 이면 시작버튼을 활성화를 toggle 하기 위해 설정
	boolean isStart = false;
	
	ArrayList<String> wordList;

	public WordBreak(){
		super( "Word Break." );
		
		this.words = new ArrayList<>();
//		this.words = new CopyOnWriteArrayList<>();
		
		this.setWordList();
		this.font = new Font( "Serif", Font.BOLD, 20 );
		
		this.setTopPane();
		this.setMainPane();
		this.setBottomPane();
		
		setBounds( 300, 300, 300, 600 );
		setVisible( true );
		
		
		// [ event ] window
		addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
		});
		
		// [ event ] Button of start
		// click 과 같은 명확한 지시 상황 없이 각 WordVO object 를 생성하는 thread 가 필요.
		startBtn.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				
				if( thread == null ) {
					
					thread = new Thread() {
						@Override public void run() {
							
							isStart = true;
							
							while( true ) {
								
								try {
									Thread.sleep( dropTime );
								} catch (Exception e2) {
									// TODO: handle exception
								}
								
								int index = (int)( Math.random() * wordList.size() - 1 );
								
								WordVO vo = new WordVO( wordList.get( index ), WordBreak.this );
								
								words.add( vo );
								
								vo.start();
							}
						}
					};
					thread.start();
					
					startBtn.setEnabled( false );
				}
			}
		});
		
		// [ event ] Enter key of textfield
		// click 과 같은 명확한 지시 상황 없이 각 WordVO object 를 생성하는 thread 가 필요.
//		inputTf.addKeyListener( new KeyAdapter() {
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				int key = e.getKeyCode();
//				
//				switch( key ) {
//				case KeyEvent.VK_ENTER:
//					
//					String keyword = inputTf.getText();
//					
//					Iterator<WordVO> vo = words.iterator();
//					
//					while( vo.hasNext() ) {
//						WordVO obj = vo.next();
//						
//						if( keyword.equalsIgnoreCase( obj.text )  ) {
//							System.out.println( obj.text + ", " + keyword );
//							vo.remove();
//							scoreLabel.setText( String.valueOf( score += 10 ) );
//							// break;
//						}
//					}
//				}
//				inputTf.setText( "" );
//			}
//		});
		
		inputTf.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				String keyword = inputTf.getText().trim();
				
				if( keyword.length() > 0 )	{
					
					// ConcurrentModificationException 을 피하기 위해 
					// 자료형 복사하기
//					ArrayList<WordVO> cloneWords = WordBreak.this.getCloneWords();
					ArrayList<WordVO> cloneWords = getCloneWords();
					
					Iterator<WordVO> it = cloneWords.iterator();
					
					while( it.hasNext() ) {
						WordVO obj = it.next();
						
						if( keyword.equalsIgnoreCase( obj.text )  ) {
							System.out.println( obj.text + ", " + keyword );
							words.remove( obj );
							
							scoreLabel.setText( String.valueOf( score += 10 ) );
						}
					}
					inputTf.setText( "" );
				}
			}
		});
	}
	
	void setMainPane() {
		
		mainPane = new JPanel() {

			@Override public void paint(Graphics g) {
				
				// create new background image 
				Image img = createImage( (int)this.getSize().getWidth(), 
										 (int)this.getSize().getHeight()	);
				
				Graphics img_g = img.getGraphics();
				
//				for( int idx = 0; idx < words.size(); idx++ )	{
//					WordVO word = words.get( idx );
//					img_g.setColor( word.c );
//					img_g.drawString( word.text, word.x, word.y );
//				}

				/* ***************************
				 * - It can occur, bellow code
				 */
//				Iterator<WordVO> it = words.iterator();
//				Iterator<WordVO> it = WordBreak.this.getCloneWords().iterator();
				Iterator<WordVO> it = getCloneWords().iterator();
				
				while( it.hasNext() )	{
					WordVO vo = it.next();
					img_g.setColor( vo.c );
					img_g.drawString( vo.text, vo.x, vo.y );
				}
				
				g.drawImage( img, 0, 0, this );
			}
		};
		
		this.add( mainPane );
	}
	
	void setTopPane() {
		topPane = new JPanel( new GridLayout( 1, 2) );
		JPanel topLeftPane = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
		
		topLeftPane.add( startBtn = new JButton( "Start" ) );
		
		topPane.add( scoreLabel = new JLabel(), BorderLayout.WEST );
		topPane.add( topLeftPane, BorderLayout.EAST );		
		
		// JLabel font setup
		startBtn.setFont( font );
		scoreLabel.setFont( font );
		scoreLabel.setForeground( Color.BLUE );
		
		scoreLabel.setText( String.valueOf( score ) );
		
		add( topPane, BorderLayout.NORTH );
	}
	
	void setBottomPane() {
		bottomPane = new JPanel();
		
		bottomPane.add( inputTf = new JTextField( 10 ) );
		bottomPane.add( confirmBtn  = new JButton( "Confirm" ) );
		
		inputTf.setFont( new Font( "Serif", Font.BOLD, 20 ) );
		
		add( bottomPane, BorderLayout.SOUTH );
		
	}
	
	// set word_list from file.
	void setWordList(){
		// 아래는 word_list 에 들어갈 내용 참조 주소
		// https://ko.wiktionary.org/wiki/%EB%B6%80%EB%A1%9D:%EC%9E%90%EC%A3%BC_%EC%93%B0%EC%9D%B4%EB%8A%94_%ED%95%9C%EA%B5%AD%EC%96%B4_%EB%82%B1%EB%A7%90_5800
		
		wordList = new ArrayList<>();
		
		try {
			Scanner sc = new Scanner( new File( "src/TEXT/word_list.txt" ) );
			
			while( sc.hasNext() )
				wordList.add( sc.nextLine().trim() );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 프레임을 다시 그릴대만, 복사한다.
	ArrayList<WordVO> getCloneWords() {
		return (ArrayList<WordVO>) words.clone(); 
	}

	public static void main(String[] args) {
		new WordBreak();
	}
}
