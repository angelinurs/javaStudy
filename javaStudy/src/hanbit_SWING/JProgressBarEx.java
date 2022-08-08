package hanbit_SWING;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JProgressBarEx extends JFrame {
	
	JProgressBar bar = new JProgressBar();
	JButton btStart = new JButton( "Start" );
	
	ProgressMonitor monitor;
	
	public JProgressBarEx()	{
		super( "JProgressBar Test" );
		
		// Case 1.
		// - add panel
//		JPanel pane = new JPanel();
//		
//		pane.add( bar, BorderLayout.CENTER );
//		pane.add( btStart, BorderLayout.EAST );
//
//		add( pane );
		
		// Case 2.
		// - add frame
		// need setLayout method
		this.setLayout(new FlowLayout());
		
		add( btStart, BorderLayout.EAST );
		add( bar, BorderLayout.CENTER );
		
		monitor = new ProgressMonitor( this, "진행중", "작업중", 0, 100 );
		
		pack();
		
		setBounds( 300, 300, 600, 300 );
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Task t = new Task();
				t.start();
			}
		};
		
		btStart.addActionListener(action);
	}
	
	class Task extends Thread {
		
		public void run()	{
			
			int count = 0;
			
			bar.setValue( 0 );
			monitor.setProgress( 0 );
			
			while( count < bar.getMaximum() )	{
				count++;
				bar.setValue(count);
				monitor.setProgress(count);
				
				try	{
					sleep( 300 );
				} catch( Exception ex ) { ex.printStackTrace(); }
			}
		}
	}

	public static void main(String[] args) {
		new JProgressBarEx();
	}

}
