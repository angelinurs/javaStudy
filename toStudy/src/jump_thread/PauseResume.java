package jump_thread;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


/*
 * https://www.bitinvert.com/java/pause-resume/
 */
public class PauseResume extends JFrame {
	
	private JButton button;
	private JTextArea ta;
	
	private Object lock;
	private volatile boolean paused;
	
	private Thread counter;
	
	public PauseResume() {
		super( "Pause Resume button." );
		
		button = new JButton( "Start" );
		ta = new JTextArea( 5, 20 );
		lock = new Object();
		paused = true;
		
		counter = new Thread( new Runnable() {
			
			@Override public void run() {
				while( true )
					work();
			}
		});
		
		counter.start();
		
		add( button, BorderLayout.NORTH );
		add( ta, BorderLayout.SOUTH );
		
		pack();
		
		setDefaultCloseOperation(  JFrame.EXIT_ON_CLOSE );
		setVisible( true );
	} 
	
	public void work()	{
		for( int idx = 0; idx < 10; idx++ )	{
			allowPause();
			write( Integer.toString( idx ) );
			sleep();
		}
		done();
	}
	
	private void allowPause() {
		synchronized ( lock ) {
			while( paused )	{
				try {
					lock.wait();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	
	private ActionListener pauseResume = 
			new ActionListener() {
				
				@Override public void actionPerformed(ActionEvent e) {
					paused = !paused;
					button.setText( paused ? "Resume": "Pause" );
					
					synchronized ( lock ) {
						lock.notifyAll();
					}
				}
			};
			
	private void sleep() {
		try {
			Thread.sleep( 500 );
		}catch ( InterruptedException ie) {
			// TODO: handle exception
		}
	}

	private void done() {
		button.setText( "Start" );
	}

	private void write( String text ) {
		ta.append( text );
	}

	public static void main(String[] args) {
		EventQueue.invokeLater( new Runnable() {
			
			@Override public void run() {
				new PauseResume();
			}
		});
	}
}
