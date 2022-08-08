package increpas_22_08_02_pm_IOStream;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

import javax.swing.*;

public class ReadBufferImplement_JFrame extends JFrame{
	
	//
	JTextArea ta;
	
	JMenu file_mnu;
	JMenuItem new_item, 
			  open_item, 
			  save_item, 
			  exit_item;
	
	JMenuBar mnuBar;
	
	//
	public ReadBufferImplement_JFrame() {
		super( "Read and Save File byte buffer by JFrame." );
		
		add( new JScrollPane( ta = new JTextArea( ) ) );
		
		setMenu();
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		
		addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
		});
		
		open_item.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser( "c:/Test" );
				int openVal = jfc.showOpenDialog( ReadBufferImplement_JFrame.this );
				
				if( openVal == jfc.APPROVE_OPTION ) {
					File file = jfc.getSelectedFile();
//					System.out.println( file.getName() );
					
					try {
						ta.setText( openFile(file) );
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				
				ta.setCaretPosition( 0 );
			}
		});
		
		save_item.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				String contents = ta.getText();
				
				JFileChooser jfc = new JFileChooser( "c:/Test" );
				
				int saveVal = jfc.showSaveDialog( ReadBufferImplement_JFrame.this );
				
				if( saveVal == jfc.APPROVE_OPTION ) {
					File file = jfc.getSelectedFile();
					
					try {
						saveFile( file, contents );
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		exit_item.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				System.exit( 0 );
			}
		});
	}
	
	/**
	 * create menu bar 
	 */
	private void setMenu() {
		
		// creates menuBar and Menu
		mnuBar = new JMenuBar();
		file_mnu = new JMenu( "FILE" );
		
		// creates items
		new_item = new JMenuItem( "New_File" );
		open_item = new JMenuItem( "Open_File" );
		save_item = new JMenuItem( "Save_File" );
		exit_item = new JMenuItem( "Exit_File" );
		
		// adds items
		file_mnu.add( open_item );
		file_mnu.add( open_item );
		file_mnu.add( save_item );
		
		file_mnu.addSeparator();
		
		file_mnu.add( exit_item );
		
		//
		mnuBar.add( file_mnu );
		
		//
		setJMenuBar( mnuBar );
	}
	
	//
	private String openFile( File file ) throws Exception {
		FileInputStream fis = null;
		//
		StringBuffer sb = new StringBuffer();
		byte[] bytes = null;
		
		//
		fis = new FileInputStream( file );
		
		// Case 01.
		// byte array 를 활용하여, 주어진 buffer size 만큼 읽어오기
		// UT-8 처리가 자동으로 이루어진다.
		int bufferSize = 2048;
		
		bytes = new byte[ bufferSize ];
		
		int readCount = 0;
		
		while( ( readCount = fis.read( bytes ) ) != -1 ) {
			sb.append( new String( bytes, 0, readCount ) );
		}
		
		if( fis != null ) fis.close();
		
		return sb.toString();
//		return new String( bytes, Charset.forName( "UTF-8" ) );
	}
	
	//
	private void saveFile( File file, String contens ) throws Exception {
		
		FileOutputStream fos = null;
		
		fos = new FileOutputStream( file );
		
		fos.write( contens.getBytes() );
		
		if( fos != null ) fos.close();
	}

	//
	public static void main(String[] args) {
		new ReadBufferImplement_JFrame();
	}
}
