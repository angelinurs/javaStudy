package increpas_22_08_03_pm_IOStream;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JDialogueImplentation extends JDialog {
	
	JTextField keyword_tf;
	JButton searchBtn;
	
	JTextField replace_tf;
	JButton replaceBtn;
	
	JButton replaceAllBtn;
	
	JPanel northPan;
	
	JPanel centerPane;
	
	JPanel replacePane;
	JPanel replaceAllPane;
	
	// dialogue 는 레퍼런스 되는 객체의 주소를 가지고 있어야 한다.
	
	ReadBufferImplement_JFrame_version_up2 frame;
	
	String searchWord;
	ArrayList<Integer> startIndexes;
	
	public JDialogueImplentation( ReadBufferImplement_JFrame_version_up2 frame, boolean replaceMod ) {
		// reference 되어지는 frame 의 textarea ( component )에 접근 할 수 잇다. 
		this.frame = frame;
		
		// search 기능 관련 초기화
		searchWord = null;
		startIndexes = new ArrayList<>();
		
		setNorthPane();
		
		centerPane = new JPanel( new GridLayout( 2, 1 ) );
		setReplacePane();
		setReplaceAllPane();
		
		add( centerPane, BorderLayout.CENTER );
		
		centerPane.setVisible( replaceMod );
		
		setBounds( 200, 200, 420, 200 );
		setVisible( true );
		
		// event 등록
		addWindowListener( new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// 자기 자신만 메모리에서 삭제
				dispose();
				
				// 검색 한 인덱스 초기화
				startIndexes.clear();
			}
			
		});
		
		searchBtn.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				
				if( keyword_tf.getText().length() == 0 ) {
					JOptionPane.showMessageDialog( frame, "검색어를 입력해주세요." );
					return;
				}
				
				// 기존 검색어와 같은지 확인
				if( searchWord == null || !searchWord.equalsIgnoreCase( keyword_tf.getText() ) ) {
					searchWord = keyword_tf.getText();
					startIndexes.clear();
				}
				
				String context =  frame.ta.getText();
				
				// 이전에 같은 keyword 로 찾은게 있는지 확인
				int lastIndex = ( startIndexes.size() > 0 )? 
										startIndexes.get( startIndexes.size() - 1 ) + searchWord.length() : 0;

				int startIndex = context.indexOf( searchWord, lastIndex );
				
				// String.indexOf() 가 못찾으면,
				// -1 을 return 하기 때문에,
				// from last index 인자없이 처음 부터 검색한다.
				if( startIndex < 0 ) startIndex = context.indexOf( searchWord );
				
				// 찾은 keyword 위치 저장
				startIndexes.add( startIndex );
				
				lastIndex = startIndex + searchWord.length();
				
				// 찾은 keyword 선택하기
				frame.ta.select( startIndex, lastIndex );
			}
		});
		
		replaceBtn.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				
				if( keyword_tf.getText().length()  == 0 ) {
					JOptionPane.showMessageDialog( frame, "검색어를 입력해주세요." );
					return;
				}
				
				doReplace();
				
			}
		});
		
		replaceAllBtn.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				
				if( keyword_tf.getText().length()  == 0 ) {
					JOptionPane.showMessageDialog( frame, "검색어를 입력해주세요." );
					return;
				}
				
				while( doReplace() ) { ; }
				
			}
		});
		
	}

	public void setNorthPane() {
		northPan = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
		northPan.add( new JLabel( "search word : ") );
		northPan.add( keyword_tf = new JTextField( 20 ) );
		northPan.add( searchBtn = new JButton( "Search " ) );
		
		add( northPan, BorderLayout.NORTH );
		
	}

	private void setReplacePane() {
		replacePane = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
		replacePane.add( new JLabel( "replace word : ") );
		replacePane.add( replace_tf = new JTextField( 20 ) );
		replacePane.add( replaceBtn = new JButton( "Replace" ) );
		
		centerPane.add( replacePane );
		
	}
	
	private void setReplaceAllPane() {
		replaceAllPane = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
		replaceAllPane.add( replaceAllBtn = new JButton( "ReplaceAll" ) );
		
		centerPane.add( replaceAllPane );
		
	}
	
	private boolean doReplace() {
		searchWord = keyword_tf.getText();
		String replaceWord = replace_tf.getText();
		String context =  frame.ta.getText();
		
		int startIndex = context.indexOf( searchWord );
		
		// String.indexOf() 가 못찾으면,
		// -1 을 return 하기 때문에,
		// replace 를 종료 한다.
		if( startIndex < 0 ) {
			JOptionPane.showMessageDialog( frame, "더 이상 변경할 단어가 없습니다." );
			return false;
		}
		
		int lastIndex = startIndex + searchWord.length();
		
		frame.ta.replaceRange( replaceWord, startIndex, lastIndex );
		
		return true;
	}
}