package increpas_22_08_05_am_serialize;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Writer_with_JFrame extends JFrame {
	
	JMenuBar bar;
	
	JMenu file_mnu;
	
	JMenuItem new_item,
			  open_item,
			  save_item,
			  exit_item;
	
	JTextArea ta;
	
	private final String path = "src/SAVE/";
	
	public Writer_with_JFrame() {
		super( "Writer exercise with Jframe" );
		
		add( new JScrollPane( ta = new JTextArea() ) );
		
		bar = new JMenuBar();
		
		file_mnu = new JMenu( "File" );
		
		new_item = new JMenuItem( "New_File" );
		open_item = new JMenuItem( "Open_File" );
		save_item = new JMenuItem( "Save_File" );
		exit_item = new JMenuItem( "Exit_File" );
		
		file_mnu.add( new_item );
		file_mnu.add( open_item );
		file_mnu.add( save_item );
		file_mnu.addSeparator();
		file_mnu.add( exit_item );
		
		bar.add( file_mnu );
		
		setJMenuBar( bar );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		
		addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
		});
		
		save_item.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				// save function
				
				saveFile();
				
				// 
			}
		});
	}

	private void saveFile() {
		String context = ta.getText();
		
		PrintWriter pw = null;
		
		JFileChooser jfc = new JFileChooser( path );
		
		int selected = jfc.showSaveDialog( this );
		
		if( selected == JFileChooser.APPROVE_OPTION ) {
			File file = jfc.getSelectedFile();
			
			try {
				pw = new PrintWriter( file );
				
				pw.write( context );
				pw.flush();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if( pw != null ) pw.close();
			}
		}
		
	}

	public static void main(String[] args) {
		new Writer_with_JFrame();
	}

}
