package increpas_22_08_03_pm_IOStream;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.*;


/*
 * 찾기와 바꾸기 기능 넣기
 * - JDialogue 기능 구현 해야함.
 */
public class ReadBufferImplement_JFrame_version_up2 extends JFrame{
	
	//
	JTextArea ta;
	
	JPanel topPane;
	
	// present file status
	JLabel bottomLabel;
	
	JMenu file_mnu;
	JMenu edit_mnu;
	JMenuItem new_item, 
			  open_item, 
			  save_item, 
			  saveAs_item, 
			  exit_item;
	
	JMenuItem search_item;
	JMenuItem replace_item;
	
	JMenuBar mnuBar;
	
	File openedFile;
	
	String path = "src/Text/";
	
	//
	public ReadBufferImplement_JFrame_version_up2() {
		super( "Read and Save File byte buffer by JFrame." );
		
		openedFile = null;

		setTopPane();
		
		setMenu();
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		
		addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
		});
		
		new_item.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				openedFile = null;
				
				ta.setText( "" );
				bottomLabel.setText( "No name File..." );
			}
		});
		
		open_item.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser( path );
				int openVal = jfc.showOpenDialog( ReadBufferImplement_JFrame_version_up2.this );
				
				if( openVal == JFileChooser.APPROVE_OPTION ) {
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
				
				if( openedFile != null ) {
					saveFile( openedFile, contents );
				} else {
					
					saveAs( contents );
				}
			}
		});
		
		saveAs_item.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				String contents = ta.getText();
				
				saveAs( contents );
			}
		});
		
		exit_item.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				System.exit( 0 );
				
			}
		});
		
		search_item.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				new JDialogueImplentation( ReadBufferImplement_JFrame_version_up2.this, false );
			}
		});
		
		replace_item.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				new JDialogueImplentation( ReadBufferImplement_JFrame_version_up2.this, true );
			}
		});
	}
	
	private void setTopPane() {
		topPane = new JPanel( new BorderLayout() );
		topPane.add( new JScrollPane( ta = new JTextArea( ) ), BorderLayout.CENTER );
		topPane.add( bottomLabel = new JLabel( "No name File..." ), BorderLayout.SOUTH );
		add( topPane );
	}
	
	/**
	 * create menu bar 
	 */
	private void setMenu() {
		
		// creates menuBar and Menu
		mnuBar = new JMenuBar();
		file_mnu = new JMenu( "FILE" );
		edit_mnu = new JMenu( "EDIT" );
		
		// creates items
		new_item = new JMenuItem( "New_File" );
		open_item = new JMenuItem( "Open_File" );
		save_item = new JMenuItem( "Save_File" );
		saveAs_item = new JMenuItem( "SaveAs_File" );
		exit_item = new JMenuItem( "Exit_File" );
		
		search_item = new JMenuItem( "Search" );
		replace_item = new JMenuItem( "replace" );
		
		// adds items
		file_mnu.add( new_item );
		file_mnu.add( open_item );
		
		file_mnu.addSeparator();
		
		file_mnu.add( save_item );
		file_mnu.add( saveAs_item );
		
		file_mnu.addSeparator();
		
		file_mnu.add( exit_item );
		
		
		edit_mnu.add( search_item );
		edit_mnu.add( replace_item );
		
		//
		mnuBar.add( file_mnu );
		mnuBar.add( edit_mnu );
		
		//
		setJMenuBar( mnuBar );
	}
	
	//
	private String openFile( File file ) throws Exception {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		//
		StringBuffer sb = new StringBuffer();
		
		byte[] bytes = null;
		
		//
//		fis = new FileInputStream( file );
		
		bis = new BufferedInputStream( new FileInputStream( file ) );
		
		
		
		// Case 01.
		// byte array 를 활용하여, 주어진 buffer size 만큼 읽어오기
		// UT-8 처리가 자동으로 이루어진다.
		int bufferSize = 2048;
		
		bytes = new byte[ bufferSize ];
		
		int readCount = 0;
		
		while( ( readCount = bis.read( bytes ) ) != -1 ) {
			sb.append( new String( bytes, 0, readCount ) );
		}
		
		
		if( bis != null ) bis.close();
//		if( fis != null ) fis.close();
		
		// 사용한 file 포인터 저장
		openedFile = file;
		
		// 상단에 현재 열린 파일 이름 표시
		bottomLabel.setText( file.getPath() );
		
		return sb.toString();
//		return new String( bytes, Charset.forName( "UTF-8" ) );
	}
	
	//
	private void saveFile( File file, String contents ) {
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream( file );
			bos = new BufferedOutputStream( fos );
			
			bos.write( contents.getBytes() );
			bos.flush();
			
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
		
		// 사용한 file 포인터 저장
		openedFile = file;
		
		bottomLabel.setText( file.getPath() );
	}
	
	//
	private void saveAs( String contents )	{
		JFileChooser jfc = new JFileChooser( "c:/Test" );
		
		int saveVal = jfc.showSaveDialog( ReadBufferImplement_JFrame_version_up2.this );
		
		File file = null;
		
		if( saveVal == JFileChooser.APPROVE_OPTION ) {
			file = jfc.getSelectedFile();
			
			int answer;
			if( file.exists() ) {
				answer = JOptionPane.showConfirmDialog( this, "Do you Want to overwrite?",
												"Save", JOptionPane.YES_NO_OPTION );
				if( answer != JOptionPane.YES_OPTION ) 
					return;
			}
			
			saveFile( file, contents );
		}
	}

	//
	public static void main(String[] args) {
		new ReadBufferImplement_JFrame_version_up2();
	}
}

