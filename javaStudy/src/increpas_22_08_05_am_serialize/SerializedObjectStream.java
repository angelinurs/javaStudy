package increpas_22_08_05_am_serialize;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;

// declare class implements serializable interface 
class ShapeCircle implements Serializable {
	Rectangle pos;

	public ShapeCircle(Rectangle pos) {
		this.pos = pos;
	}
}

public class SerializedObjectStream {
	
	String path = "src/SAVE/SerializedObjectStream.obj";
	
	ShapeCircle circle;
	
	public void saveObject() {
		File file = new File( path );
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream( new FileOutputStream( file ) );
			
			oos.writeObject( circle );
			
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
		File file = new File( path );
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream( new FileInputStream( file ) );
			
			ShapeCircle obj = (ShapeCircle) ois.readObject();
			
			circle = obj;
			
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
		SerializedObjectStream sample = new SerializedObjectStream();
		
		sample.circle = new ShapeCircle( new Rectangle( 10, 10, 10, 10 ) );
		
		sample.saveObject();

		sample.circle = new ShapeCircle( new Rectangle( 20, 20, 20, 20 ) );
		
		StringBuffer sb = new StringBuffer();
		
		sb.append( sample.circle.pos.getX() ).append( "\n" );
		sb.append( sample.circle.pos.getY() ).append( "\n" );
		sb.append( sample.circle.pos.getWidth() ).append( "\n" );
		sb.append( sample.circle.pos.getHeight() ).append( "\n" );
		
		System.out.println( sb.toString() );
		
		sample.readObject();
		
		sb = new StringBuffer();
		
		sb.append( sample.circle.pos.getX() ).append( "\n" );
		sb.append( sample.circle.pos.getY() ).append( "\n" );
		sb.append( sample.circle.pos.getWidth() ).append( "\n" );
		sb.append( sample.circle.pos.getHeight() ).append( "\n" );
		
		System.out.println( sb.toString() );
	}

}
