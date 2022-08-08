package increpas_22_08_02_pm_IOStream;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.swing.*;


public class ReadFileWithJFrame extends JFrame{
	
	//
	JTextArea ta;
	
	JMenu file_mnu;
	JMenuItem new_item, 
			  open_item, 
			  save_item, 
			  exit_item;
	
	JMenuBar mnuBar;
	
	//
	public ReadFileWithJFrame() {
		super( "Read and Save File by JFrame." );
		
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
				int openVal = jfc.showOpenDialog( ReadFileWithJFrame.this );
				
				if( openVal == jfc.APPROVE_OPTION ) {
					File file = jfc.getSelectedFile();
//					System.out.println( file.getName() );
					
					ta.setText( openFile(file) );
				}
			}
		});
		
		save_item.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				String contents = ta.getText();
				
				JFileChooser jfc = new JFileChooser( "c:/Test" );
				
				int saveVal = jfc.showSaveDialog( ReadFileWithJFrame.this );
				
				if( saveVal == jfc.APPROVE_OPTION ) {
					File file = jfc.getSelectedFile();
					
					saveFile( file, contents );
				}
			}
		});
		
		exit_item.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				System.exit( 0 );
			}
		});
	}
	
	//
	public String openFile( File file ) {
		FileInputStream fis = null;
		//
		StringBuffer sb = new StringBuffer();
		byte[] bytes = null;
		
		//
		try {
			fis = new FileInputStream( file );
			
			int data = -1;
			
			// Case 01. ascii 및 byte 로만 처리
//			while( ( data = fis.read() ) != -1 ) {
//				sb.append( (char) data );
//			}
			
			// Case 02. UT-8 처리
			bytes = new byte[ fis.available() ];
			
			for( int idx = 0; ( data = fis.read() ) != -1; idx++ ) {
				bytes[ idx ] = (byte)data;
			}
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
				try {
					if( fis != null ) fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
//		return sb.toString();
		return new String( bytes, Charset.forName( "UTF-8" ) );
	}
	
	//
	public void saveFile( File file, String contens ) {
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream( file );
			
			fos.write( contens.getBytes() );
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
				try {
					if( fos != null ) fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * create menu bar 
	 */
	public void setMenu() {
		
		//
		mnuBar = new JMenuBar();
		file_mnu = new JMenu( "FILE" );
		
		//
		new_item = new JMenuItem( "New_File" );
		open_item = new JMenuItem( "Open_File" );
		save_item = new JMenuItem( "Save_File" );
		exit_item = new JMenuItem( "Exit_File" );
		
		//
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
	public static void main(String[] args) {
		new ReadFileWithJFrame();
	}
}
