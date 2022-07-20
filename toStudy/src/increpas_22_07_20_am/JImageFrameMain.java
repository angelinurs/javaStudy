package increpas_22_07_20_am;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JImageFrameMain extends JFrame {
	
	ImageIcon icon;
	JLabel lb;
	
	public JImageFrameMain() {
		super( "Image test" );
		
		setLayout( new FlowLayout( FlowLayout.LEFT ) );
		
//		String filename = "src/images/icon2.jpg";
		String filename = "src/imageLottos/10.jpg";
		
		icon = new ImageIcon( filename );
		
		// image resize()
		Image img = icon.getImage();
		
		Image img_resize = img.getScaledInstance( 100, 100, Image.SCALE_SMOOTH );
		
		icon.setImage( img_resize );
		
		lb = new JLabel( icon );
		
		ImageIcon icon_resize = new ImageIcon( img );
		
		JLabel new_lb = new JLabel( icon_resize );
		
		add(lb);
		add( new_lb );
		
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}

	public static void main(String[] args) {
		new JImageFrameMain();
	}

}
