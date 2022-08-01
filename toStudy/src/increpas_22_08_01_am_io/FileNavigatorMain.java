package increpas_22_08_01_am_io;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

public class FileNavigatorMain extends JFrame {
	
	JPanel topPane;
	JScrollPane mainPane;
	
	JLabel pathLabel;
	JTextField tf;
	JButton confirmBtn;
	
	JList<String> navi;
	
	public FileNavigatorMain() {
		super( "FileNavigator" );
		
		setLayout( new FlowLayout() );
		
		setTopPane();
		setMainPane();
		
		setBounds( 300, 300, 400, 600 );
		setVisible( true );
		
		
		// window closing envet 
		addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
		});
		
		confirmBtn.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				Object o =  e.getSource();
				
				getFilelist( tf.getText().trim() );
			}
		});
	}
	
	void setTopPane()	{
		topPane = new JPanel();
		
		topPane.add( pathLabel = new JLabel( "PATH : " ) );
		topPane.add( tf = new JTextField( 15 ) );
		topPane.add( confirmBtn = new JButton( "confirm") );
		
		add( topPane );
	}
	
	void setMainPane() {
		mainPane = new JScrollPane(navi = new JList<String>());
		
		add( mainPane );
	}
	
	void getFilelist( String filename )	{
		
		File path = new File( filename );
		
		if( !path.exists() )	{
//			System.out.println( "Not exist." );
			JOptionPane.showMessageDialog( this , "Not exist." );
			return;
		}
		
		if( !path.isDirectory() ) {
			System.out.println( "Not a directory." );
			JOptionPane.showMessageDialog( this , "Not a directory." );
			return;
		}		
		
		String[] filelist = path.list();
		
		
		System.out.println(filelist.length);
		navi.setListData(filelist);
	}

	public static void main(String[] args) {
		new FileNavigatorMain();
	}

}
