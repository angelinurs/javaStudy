package increpas_22_08_04_pm_IOStream;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PostZipCode_ReadLine_JFrame extends JFrame {
	
	JPanel northPane;
	JPanel centerPane;
	
	JTextField postnumber_tf, 
			   street_tf;
	JComboBox<String> cities_combo;
	JButton searchBtn;

	JList<String> addressList;
	
	// plz downloads file
	private final String path = "src/ZIPCODE_DB/";
	
	// Case 01.
	// Load file list
	String[] cities;
	
	// Case 02.
	// Load String array
//	String[] cities = { "강원도",   "경기도", 
//						"경상남도",  "경상북도",
//						"광주광역시", "대구광역시",
//						"대전광역시", "부산광력시",
//						"서울특별시", "세종특별자치시",
//						"울산광역시", "인천광역시",
//						"전라남도",  "전라북도",
//						"제주특별자치도",
//						"충청남도",  "충청북도"
//						};
	
	DefaultListModel<String> street_model;
	
	public PostZipCode_ReadLine_JFrame() {
		super( "우편번호 검색_file_version" );
		
		cityList();
		
		setNorthPane();
		setCenterPane();
		pack();
		
		setBounds( 300, 300, 600, 700 );
		setVisible( true );
		
		addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
		});
		
		searchBtn.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				searchAddress();
			}
		});
		
		street_tf.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				searchAddress();
			}
		});
		
		addressList.addMouseListener( new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String seletValue = addressList.getSelectedValue();
				
				if( seletValue != null ) {
					postnumber_tf.setText( seletValue.split( "\\|" )[ 0 ].trim() );
				}
			}
		});
	}

	private void setNorthPane() {
		northPane = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
		
		northPane.add( postnumber_tf = new JTextField( 10 ) );
		northPane.add( cities_combo = new JComboBox<>(cities) );
		northPane.add( street_tf = new JTextField( 20 ) );
		northPane.add( searchBtn = new JButton( "search" ) );
		
		cities_combo.setBackground( Color.WHITE );
		
		add( northPane, BorderLayout.NORTH );
	}

	private void setCenterPane() {
		centerPane = new JPanel( new BorderLayout() );
		centerPane.add( new JScrollPane( addressList = new JList<>() ), BorderLayout.CENTER );
		
		add( centerPane, BorderLayout.CENTER );
	}
	
	private void searchAddress()	{
		if( street_tf.getText().trim().length() == 0 ) {
			JOptionPane.showMessageDialog( PostZipCode_ReadLine_JFrame.this, "도로명을 입력하세요." );
			street_tf.requestFocus();
			return;
		}
		
		int selectedIndex = cities_combo.getSelectedIndex();
		
		String filename = String.format( "%s%s.txt", path, cities[ selectedIndex ] );
		
//		String cityName = cities_combo.getItemAt( cities_combo.getSelectedIndex() );
//		String filename = String.format( "src/ZIPCODE_DB/%s.txt", cityName );
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader( new FileReader( new File(filename) ) );
			
			String line = null;
			ArrayList<String> datas = new ArrayList<>();
			
			while( ( line = br.readLine() ) != null ) {
				String[] tokens = line.split( "\\|" );
				
				if( tokens[ 8 ].trim().contains( street_tf.getText().trim() ) ) {
					
					datas.add( tokens[ 0 ] + " | " + tokens[ 8 ] + " | " + tokens[ 15 ] );
				}
			}
			
			String[] arr = datas.toArray( new String[ datas.size() ] );
			addressList.setListData(  arr );
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
				try {
					if( br != null ) br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void cityList( ) {
		
		File file = new File( path );
		
		String[] filenames = file.list();
		
		ArrayList<String> citynames = new ArrayList<>();

		for( String filename : filenames ) {
			if( filename.endsWith( ".txt"  ) ) {
				// Case 01.
				citynames.add( filename.replaceAll( ".txt", "" ) );
				
				// Case 02.
//				int idx = citynames.lastIndexOf( ".txt" );
//				citynames.add( filename.substring( 0, idx ) );
			}
		}
		
		cities = citynames.toArray( new String[ citynames.size() ] );
	}

	public static void main(String[] args) {
		new PostZipCode_ReadLine_JFrame();
	}

}
