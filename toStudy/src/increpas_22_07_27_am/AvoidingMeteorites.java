package increpas_22_07_27_am;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


class HeroAvatar {
	Rectangle pos;

	public HeroAvatar(Rectangle pos) {
		this.pos = pos;
	}
};


public class AvoidingMeteorites extends JFrame {
	
	// set game board image;
	// background image size
	Dimension d = new Dimension( 390, 590 );
	JPanel gamePane;
	
	// image ready
	
	Image background_img;
	Image hero_img;
	Image meteo_img;
	ArrayList<Image> exploit_img;
	
	HeroAvatar hero;

	public AvoidingMeteorites( ) {
		super( "Avoiding Meteorites");
		
		// 이미지를 아이콘으로 가여오나
		// getImage() method 를 통해 일반 Image Object 로 만들어준다.
		background_img = new ImageIcon( "src/imageMeteo/back.jpg" ).getImage();
		hero_img       = new ImageIcon( "src/imageMeteo/me.png" ).getImage();
		meteo_img      = new ImageIcon( "src/imageMeteo/meteo.png" ).getImage();
		
		// initialize game board
		setGamePane();
		setHero();
		
		
		
		setLocation( 300, 50 );
		pack();
		// window size de-activate
		setResizable( false );
		setVisible( true );
		
		// 운석만드는 Thread 실행
		
		
		
		// event listener register
		addWindowListener( new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
			
		});
		
	}
	
	private void setGamePane() {
		
			
		gamePane = new JPanel() {
			@Override protected void paintComponent(Graphics g) {
				
				g.drawImage( background_img, 0, 0, this );
				g.drawImage( hero_img, hero.pos.x, hero.pos.y, this );
			}
		};
		
		// 화면에 표시될 크기를 미리 예약함. 
		// Dimension 타입 인자를 받음.
		gamePane.setPreferredSize( d );
		
		add( gamePane );
	}
	
	public void setHero(  ) {
		int posX = ( d.width - hero_img.getWidth( this ) ) / 2;
		int posY = d.height - 10;
		int width = hero_img.getWidth( this );
		int height = hero_img.getHeight( this );
		
		hero = new HeroAvatar( new Rectangle( posX, posY, width, height ) );
		
	}

	public static void main(String[] args) {
		new AvoidingMeteorites();
	}
}
