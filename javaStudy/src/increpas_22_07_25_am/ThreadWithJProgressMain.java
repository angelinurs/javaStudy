package increpas_22_07_25_am;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.function.DoublePredicate;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

class ThreadWithJProgress extends Thread {
	ThreadWithJProgressMain frame;
	Color color;
	boolean stopFlag;
	
	public ThreadWithJProgress( ThreadWithJProgressMain frame,
								Color color ) {
		this.frame = frame;
		this.color = color;
		stopFlag = true;
	}

	// Case 01. for loop
//	@Override
//	public void run() {
//		for( int idx = 1; idx <= 100; idx++ )	{
//			frame.redBar.setValue( idx );
//			
//			try {
//				Thread.sleep( 100 );
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
	public void setStop( boolean stop ) {
		stopFlag = stop;
	}
	
	public boolean getStop() {
		return stopFlag;
	}
	
	
	// Case 01. while loop
	@Override
	public void run() {
		
		JProgressBar selectBar = null;
		
		if ( color == Color.RED ) {
			selectBar = frame.redBar;
		} else if ( color == Color.GREEN ) {
			selectBar = frame.greenBar;
		}
		
		int val = selectBar.getValue();
		
		while( true ) {
			if( ++val > selectBar.getMaximum() ) {
				break;
			}
			if( getStop() ) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				this.notify();
			}
			
			selectBar.setValue( val );
			
			try {
				Thread.sleep( 100 );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
};

class ThreadKeyListener extends KeyAdapter	{
	
	ThreadWithJProgressMain frame;
	
	ThreadWithJProgress redThread;
	ThreadWithJProgress greenThread;
	

	boolean doublePressedRed   = false, isRunningRed   = false;
	boolean doublePressedGreen = false, isRunningGreen = false;
	
	public ThreadKeyListener(ThreadWithJProgressMain frame) {
		this.frame = frame;
		
		redThread = new ThreadWithJProgress( frame, Color.RED );
		greenThread = new ThreadWithJProgress( frame, Color.GREEN );
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		ThreadWithJProgress t = null;
		
		switch( code ) {
			case KeyEvent.VK_R:
				if( !doublePressedRed ) {
					if( !isRunningRed ) {
						redThread.setStop( false );
						redThread.start();
						isRunningRed = true;
					} else {
						// pause
						redThread.setStop( true );
//						redThread.suspend();
					}
				} else {
					// restart
					redThread.setStop( false );
//					redThread.resume();
				}
				doublePressedRed = !doublePressedRed;
				break;
				
			case KeyEvent.VK_G:
				if( !doublePressedGreen ) {
					if( !isRunningGreen ) {
						greenThread.start();
						isRunningGreen = true;
					} else {
						// pause
						greenThread.suspend();
					}
				} else {
					// restart
					greenThread.resume();
				}
				doublePressedGreen = !doublePressedGreen;
				break;
			}
	}
}

public class ThreadWithJProgressMain extends JFrame {
	
	JProgressBar redBar, greenBar;
	
	public ThreadWithJProgressMain() {
		super( "Thread With JProgress test." );
		
		setLayout( new GridLayout( 3, 1 ) );
		add( redBar = new JProgressBar( 0, 100 ) );
		add( greenBar = new JProgressBar( 0, 100 ) );
		
		redBar.setForeground( Color.RED );
		redBar.setValue( 20 );
		
		greenBar.setForeground( Color.GREEN );
		greenBar.setValue( 0 );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		addKeyListener( new ThreadKeyListener( this ) );
//		new ThreadWithJProgress( this ).start();
	}

	public static void main(String[] args) {
		new ThreadWithJProgressMain();
	}

}
