package increpas_22_08_01_am_Synchonized;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

class Signal implements Runnable {
	
	// run() method greenOn(), redOn()
	// redBtton, greenBtn 와 같은 member variable 을 변경하기 위해 필요.
	SignalMain frame;
	
	public Signal(SignalMain frame) {
		this.frame = frame;
	}

	// allow access multi-thread 
	@Override public void run() {
		String name = Thread.currentThread().getName();
		
		while( true ) {
			synchronized (this ) {
				switch (name) {
				case "R": 
					redOn();
					break;
				case "G": 
					greenOn();
					break;
				case "Y": 
					yellowOn();
					break;
				}
				
				try {
					Thread.sleep( 100 );
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	
	private void yellowOn() {
		frame.yellowBtn.setBackground( Color.YELLOW );
		frame.greenBtn.setBackground(  Color.GRAY );
		frame.redBtn.setBackground(    Color.GRAY );
	}
	
	private void greenOn() {
		frame.yellowBtn.setBackground( Color.GRAY );
		frame.greenBtn.setBackground(  Color.GREEN );
		frame.redBtn.setBackground(    Color.GRAY );
	}
	
	private void redOn() {
		frame.yellowBtn.setBackground( Color.GRAY );
		frame.greenBtn.setBackground(  Color.GRAY );
		frame.redBtn.setBackground(    Color.RED );
	}
};

public class SignalMain extends JFrame {
	
	JButton redBtn, greenBtn, yellowBtn;
	
	public SignalMain() {
		super( "Signal board" );
		
		redBtn = new JButton();
		greenBtn = new JButton();
		yellowBtn = new JButton();
		
		setLayout( new GridLayout( 1, 3 ) );
		
		add( redBtn );
		add( greenBtn );
		add( yellowBtn );
		
		setBounds( 300, 300, 300, 200);
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
			
		});
		
		Signal run = new Signal( this );
		
		Thread rt = new Thread( run, "R" );
		Thread gt = new Thread( run, "G" );
		Thread yt = new Thread( run, "Y" );
		
		rt.start();
		gt.start();
		yt.start();
	}
	
	public static void main(String[] args) {
		new SignalMain();
		
	}
}