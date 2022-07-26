package jump_thread;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


/*
 * https://www.bitinvert.com/java/pause-resume/
 */
public class PauseResume {
	
	private JFrame frame;
	private JButton button;
	private JTextArea ta;
	
	private Object lock;
	private volatile boolean paused;
	
	private Thread counter;
	
	public PauseResume() {
		this.frame = new JFrame( "Pause Resume button." );
		this.button = new JButton( "Start" );
		this.ta = new JTextArea( 5, 20 );
		this.lock = new Object();
		this.paused = true;
		
		counter = new Thread( new Runnable() {
			
			@Override
			public void run() {
				while( true )
					work();
			}
		});
		
		counter.start();
		
		frame.add( button, BorderLayout.NORTH );
		frame.add( ta, BorderLayout.SOUTH );
		
		frame.pack();
		
		frame.setDefaultCloseOperation(  JFrame.EXIT_ON_CLOSE );
		frame.setVisible( true );
	} 
	
	public void work()	{
		for( int idx = 0; idx < 10; idx++ )	{
			allowPause();
			write( Integer.toString( idx ) );
			sleep();
		}
		donw();
	}
	
	private void allowPause() {
		synchronized ( lock ) {
			while( )
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
