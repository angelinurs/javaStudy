package increpas_22_08_05_am_serialize;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.ArrayList;


// declare class implements serializable interface 
class Circle implements Serializable {
	Rectangle pos;
	Color color;

	public Circle(Rectangle pos) {
		this.pos = pos;
		
		color = new Color( (int)(Math.random()*256), 
						   (int)(Math.random()*256), 
						   (int)(Math.random()*256) );
	}
	
	public Color getColor() {
		return color;
	}
}

public class SerializedObjectStream_JFrame extends JFrame {
	
	String path = "src/SAVE/";
	
	ArrayList<Circle> circleList = null;
	
	JPanel drawPane = null;
	
	JMenuBar bar;
	JMenu file_mnu;
	
	JMenuItem new_file,
			  open_file,
			  save_file,
			  exit_file;
	
	Image buf;
	
	File selectedFile;
	
	int beforeX, beforeY, afterX, afterY;
			  
	public SerializedObjectStream_JFrame() {
		super( "Serialized Object Stream JFrame" );
		
		circleList = new ArrayList<>();
		
		setMenu();
		setDrawPane();
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		
		addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
		});
		
		addMouseListener( new MouseAdapter() {

			@Override public void mouseClicked(MouseEvent e) {
				
				circleList.add( new Circle( new Rectangle( e.getX(), e.getY(), 10, 10 ) ) );
				
				drawPane.repaint();
			}

			@Override public void mousePressed(MouseEvent e) {
				beforeX = e.getX();
				beforeY = e.getY();
			}

			@Override public void mouseReleased(MouseEvent e) {
				afterX = e.getX();
				afterY = e.getY();
				
				if( beforeX - afterX > 0 ) {
					int temp = beforeX;
						beforeX = afterX;
						afterX = temp;
				}
				
				if( beforeY - afterY > 0 ) {
					int temp = beforeY;
						beforeY = afterY;
						afterY = temp;
				}
				
				int width = afterX - beforeX;
				int height = afterY - beforeY;
				
				circleList.add( new Circle( new Rectangle( beforeX, beforeY, width, height ) ) );
				
				drawPane.repaint();
			}
			
		});
		
		new_file.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				circleList.clear();
				
				drawPane.repaint();
			}
		});
		
		open_file.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser( path );
				
				int index = jfc.showOpenDialog( SerializedObjectStream_JFrame.this );
				
				if( index == JFileChooser.APPROVE_OPTION ) {
					selectedFile = jfc.getSelectedFile();
					
					readObject();
				}
				
				drawPane.repaint();
				
			}
		});
		
		save_file.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser( path );
				
				int index = jfc.showSaveDialog( SerializedObjectStream_JFrame.this );
				
				if( index != JFileChooser.APPROVE_OPTION ) {
					return;
				} else {
					selectedFile = jfc.getSelectedFile();
					
					if( selectedFile.exists() ) {
						int checkValue = JOptionPane.showConfirmDialog( 
								SerializedObjectStream_JFrame.this, "OverWrite?", "Warning", JOptionPane.YES_NO_OPTION );
						
						if( checkValue != JOptionPane.YES_OPTION ) {
							return;
						}
					}
					
					saveObject();
				}
			}
		});
		
		exit_file.addActionListener( new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				System.exit( 0 );
			}
		});
	}
	
	private void setMenu() {
		file_mnu = new JMenu( "File" );
		
		file_mnu.add( new_file =  new JMenuItem( "New File" ) );
		file_mnu.add( open_file =  new JMenuItem( "Open File" ) );
		file_mnu.add( save_file =  new JMenuItem( "Save File" ) );
		file_mnu.addSeparator();
		file_mnu.add( exit_file =  new JMenuItem( "Exit File" ) );
		
		bar = new JMenuBar();
		
		bar.add( file_mnu );
		
		setJMenuBar( bar );
		
	}

	public void setDrawPane() {
		drawPane = new JPanel() {
			
			@Override public void paint(Graphics g) {
				
				buf = createImage( drawPane.getWidth(),
								   drawPane.getHeight() );
				
				Graphics buf_g = buf.getGraphics();

				if( circleList != null ) {
					for( Circle circle : circleList ) {
						
						buf_g.setColor( circle.getColor() );
						int x = (int) circle.pos.getX() - (int) circle.pos.getWidth()/2;
						int y = (int) circle.pos.getY() - (int) circle.pos.getHeight()/2;
						buf_g.fillOval( x, y, 
								(int) circle.pos.getWidth() , (int) circle.pos.height );
					}
				}
				
				g.drawImage(buf, 0, 0, this );
			}

			@Override public void update(Graphics g) {
				paint(g);
			}
		};
		
		add( drawPane );
	}
	
	public void saveObject() {
		File file = selectedFile;
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream( new FileOutputStream( file ) );
			
			oos.writeObject( circleList );
			
			oos.flush();
			
			setTitle( selectedFile.getName() );
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
				try {
					if( oos != null ) oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void readObject() {
		File file = selectedFile;
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream( new FileInputStream( file ) );
			
			Object obj = ois.readObject();
			
			if( obj != null ) {
				
				ArrayList<Circle> newList = (ArrayList<Circle>) obj;
				
				circleList = newList;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
				try {
					if( ois != null ) ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static void main(String[] args) {
		
		new SerializedObjectStream_JFrame();
	}
}
