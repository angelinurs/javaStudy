package increpas_22_07_18_am;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class FileEditBoard extends JFrame {
	
	// declare JScrollPane
	JScrollPane jscrP;
	
	// declare textarea
	JTextArea jta;
	
	// declare menu area
	JMenuBar jmb;
	JMenu file_m, edit_m;
	ArrayList<JMenuItem> file_menu_items;
	ArrayList<JMenuItem> edit_menu_items;
	
	// menu data
	String[] fileMenu = { "New", "Open", "Save", "As Save" };
	String[] editMenu = { "Copy", "Paste", "Replace" };
	
	public FileEditBoard() {
		super( "File Edit Board test." );
		
		// window appearance set
		setBounds( 300, 300, 500, 500 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		jmb = new JMenuBar();
		setJMenuBar( jmb );		
		
		file_m = new JMenu( "FILE" );
		edit_m = new JMenu( "EDIT" );
		
		jmb.add( file_m );
		jmb.add( edit_m );
		
		// add menu item - file
		file_menu_items = new ArrayList<>( );
		
		for( int idx = 0; idx < fileMenu.length; idx++ ) {
			file_menu_items.add( new JMenuItem( fileMenu[ idx ] ) );
			file_m.add( file_menu_items.get( idx ) );
		}
		
		// add menu item - edit
		edit_menu_items = new ArrayList<>( );
		
		for( int idx = 0; idx < editMenu.length; idx++ ) {
			edit_menu_items.add( new JMenuItem( editMenu[ idx ] ) );
			edit_m.add( edit_menu_items.get( idx ) );
		}
		
		/*******************
		 * Configure Text area
		 *******************/
		
		jta = new JTextArea( 20, 30 );
		
		jscrP = new JScrollPane( jta );
		
		// JScrollPane set 
		jscrP.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
		jscrP.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		
		// Panel Border set - title, line
		jscrP.setBorder( new TitledBorder( 
						new LineBorder( Color.BLACK, 3 ), "Text Area Contents" ));
		
		add( jscrP );
		
		pack();
	}
	

	public static void main(String[] args) {
		new FileEditBoard();
	}

}
