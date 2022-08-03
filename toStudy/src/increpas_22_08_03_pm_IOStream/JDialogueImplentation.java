package increpas_22_08_03_pm_IOStream;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JDialogueImplentation extends JDialog {
	
	JTextField keyword_tf;
	
	JButton searchBtn;
	
	JPanel centerPane;
	
	// dialogue 는 레퍼런스 되는 객체의 주소를 가지고 있어야 한다.
	
	ReadBufferImplement_JFrame_version_up2 frame;
	
	public JDialogueImplentation( ReadBufferImplement_JFrame_version_up2 frame ) {
		// reference 되어지는 frame 의 textarea ( component )에 접근 할 수 잇다. 
		this.frame = frame;
		
		centerPane = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
		centerPane.add( new JLabel( "search word : ") );
		centerPane.add( keyword_tf = new JTextField( 20 ) );
		centerPane.add( searchBtn = new JButton( "Search" ) );
		
		add( centerPane );
		
		setBounds( 200, 200, 420, 200 );
		setVisible( true );
		
		// event 등록
		addWindowListener( new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// 자기 자신만 메모리에서 삭제
				dispose();
			}
			
		});
		
	}

}