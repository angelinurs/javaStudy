package increpas_22_08_03_pm_IOStream;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;

import java.net.URL;

import javax.swing.*;

public class URLDownloader extends JFrame {
	
	JPanel centerPane, midPane;
	
	JTextField url_tf;
	
	JButton downBtn;
	
	JLabel saveLabel;

	// web 상에서 가져오기 위해 필요한 object
	URL url;
	// source : https://c.tenor.com/aq8x-fzLKoMAAAAd/seal-white-seal.gif
	InputStream is;
	
	// 파일을 저장하기 위한 objects
	File save_file;
	FileOutputStream fos;
	
	public URLDownloader() {
		super( "- URL Downloader." );
		
		setLayout( new BorderLayout() );
		
		setCenterPane();
		setMidPane();
		
		setBounds( 300, 300, 500, 200 );
		setVisible( true );
		
		addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				closed();
			}
		});
		
		downBtn.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser( "src/Text/" );
				
				String urlAddress =  url_tf.getText().trim();
				
				// 아래의 if 문은 url에 filename 이 있을경우 미리 지정해서 저장하기
				// Case 01.
//				if( urlAddress.contains( "." ) )	{
//					String[] tokens = urlAddress.split( "/" );
//					
//					String newFilename = jfc.getCurrentDirectory() + File.separator + tokens[ tokens.length -1 ];
//					
//					jfc.setSelectedFile( new File( newFilename ) );
//				}
				
				// Case 02.
//				String[] tokens = urlAddress.split( "/" );
////				String newFilename = jfc.getCurrentDirectory() + File.separator + tokens[ tokens.length -1 ];
//				String newFilename = tokens[ tokens.length -1 ];
//				jfc.setSelectedFile( new File( newFilename ) );
				
				// Case 03.
				int idx = urlAddress.lastIndexOf( "/" );
				String filename = urlAddress.substring( idx + 1 );
				jfc.setSelectedFile( new File( filename ) );
				
				
				int index = jfc.showSaveDialog( URLDownloader.this );
				
				if( index == jfc.APPROVE_OPTION ) {
					
					save_file = jfc.getSelectedFile(  );
					
					//
					try {
						fos = new FileOutputStream( save_file );
						
						// read web stream bytes by url
						url = new URL( urlAddress );
						
						is = url.openStream();
						
						byte[] buffer = new byte[ 2048 ];
						
						int byteCount = 0;
						
						while( ( byteCount = is.read( buffer ) ) != -1 ) {
							fos.write( buffer, 0, byteCount );
							fos.flush();
						}
						
						JOptionPane.showMessageDialog( URLDownloader.this, "done." );
						
						saveLabel.setText( save_file.getPath() );
						
					} catch (Exception e2) {
						e2.printStackTrace();
					} finally {
							try {
								if( fos != null ) fos.close();
								if( is != null ) is.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
					}
				}
			}
		});
	}

	public void setCenterPane() {
		centerPane = new JPanel( new BorderLayout() );
		
		centerPane.add( new JLabel( "URL : " ), BorderLayout.WEST );
		centerPane.add( url_tf = new JTextField( 40 ) );
		
		add( centerPane, BorderLayout.NORTH );
	}
	
	public void setMidPane() {
		midPane = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
		
		midPane.add( saveLabel = new JLabel(), BorderLayout.WEST );
		midPane.add( downBtn = new JButton( "Down.." ), BorderLayout.EAST );
		add( midPane, BorderLayout.CENTER );
	}
	
	public void closed() {
		try {
			if( is != null ) is.close();
			if( fos != null ) fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.exit( 0 );
	}

	public static void main(String[] args) {
		new URLDownloader();
	}
}
