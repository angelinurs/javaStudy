package increpas_22_07_27_am;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Iterator;

/* ************************
 * - class HeroAvatar
 */
class HeroAvatar {
	Rectangle pos;

	public HeroAvatar(Rectangle pos) {
		this.pos = pos;
	}
};

/* ************************
 * - class MeteoVO 
 * - extends Thread
 */
class MeteoVO extends Thread {
	AvoidingMeteorites frame;
	
	Rectangle pos;
	int speed;
	
	public MeteoVO( AvoidingMeteorites frame ) {
		
		this.frame = frame;

		pos = new Rectangle();
		
		pos.width  = frame.meteo_img.getWidth( frame );
		pos.height = frame.meteo_img.getHeight( frame );
		
		pos.x = (int)(Math.random() * ( frame.gamePane.getWidth() - pos.getWidth() ) );
		pos.y = 0;
		
		speed = (int)(Math.random() * 8 + 2 );
	}

	@Override public void run() {
		
		while( true ) {
			
			pos.y += speed;
			
			if( pos.y > frame.gamePane.getHeight() - frame.meteo_img.getHeight( frame) || 
				frame.hero.pos.intersects( pos ) )
				break;
			
			frame.gamePane.repaint();
			
			try {
				Thread.sleep( 200 );
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		// while loop 를 종료했다는건 meteo 가 부딪쳤다는것이다.
		// 1. meteo 삭제.
		frame.meteoVoList.remove( this );
		
		
		// 2. exploit 추가
		ExploitVO expVO = new ExploitVO( );
		
		expVO.pos.x = (int) ( pos.getCenterX() - expVO.size/2 );
		expVO.pos.y = (int) ( pos.getCenterY() - expVO.size/2 );
		
		frame.expVOList.add( expVO );
	}
};

/* ************************
 * - MeteoExploit 
 * - extends Thread
 */
class ExploitVO extends Thread {
	int size = 128;
	Point pos;
	
	int index;
	// 반복문을 gqp 만큼 돌때 index 1 증가 시킬 예정
	int gap = 5;
	int interval = gap;
	
	public ExploitVO() { pos = new Point(); }
	
	public ExploitVO( int x, int y ) { pos = new Point(x, y); }
	
	public boolean move_index() {
		if( interval == gap )
			index++;
		
		interval--;
		
		if( interval == 0 )
			interval = gap;
		
		return index >= 27;
	}
};

/* ************************
 * - Main class
 * - class AvoidingMeteorites 
 */
public class AvoidingMeteorites extends JFrame {
	
	// set game board image;
	// background image size
	Dimension d = new Dimension( 390, 590 );
	JPanel gamePane;
	
	// image ready
	
	Image background_img;
	Image hero_img;
	Image meteo_img;
	
	ArrayList<Image> exploit_imgs;
	
	HeroAvatar hero;
	
	// meteo drop ratio
	int dropTime = 900;
	
	boolean quitFlag = false;
	
	// meteo thread
	Thread meteoThread = null; 
	
	ArrayList<MeteoVO> meteoVoList = null;
	
	ArrayList<ExploitVO> expVOList = null;

	public AvoidingMeteorites( ) {
		super( "Avoiding Meteorites");
		
		// 이미지를 아이콘으로 가여오나
		// getImage() method 를 통해 일반 Image Object 로 만들어준다.
		background_img = new ImageIcon( "src/imageMeteo/back.jpg" ).getImage();
		hero_img       = new ImageIcon( "src/imageMeteo/me.png" ).getImage();
		meteo_img      = new ImageIcon( "src/imageMeteo/meteo.png" ).getImage();
		
		// exploit images load
		exploit_imgs = new ArrayList<>();
		String expFilename;
		for( int idx = 1; idx <= 27; idx++ )	{
			expFilename = String.format( "src/imageMeteo/exp_enemy/exp_%d.png", idx );
			exploit_imgs.add( new ImageIcon( expFilename ).getImage() ); 
		}
		
		// initialize game board
		setGamePane();
		
		// HeroAvatar Object binding
		setHero();
		
		pack();
		
		setLocation( 300, 50 );
		// window size de-activate
		setResizable( false );
		setVisible( true );
		
		// meteo vo Thread list init
		meteoVoList = new ArrayList<>();
		
		// Exploit vo Thread list init
		expVOList = new ArrayList<>();
		
		// 운석만드는 Thread 실행
		if( meteoThread == null ) {
			meteoThread = new Thread() {
				@Override public void run() {
					
					while( !quitFlag ) {
						MeteoVO vo = new MeteoVO( AvoidingMeteorites.this );
						
						meteoVoList.add( vo );
						
						vo.start();
						
						try {
							Thread.sleep( dropTime );
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
			};
			meteoThread.start();
		}
		
		// event listener register
		addWindowListener( new WindowAdapter() {

			@Override public void windowClosing(WindowEvent e) {
				System.exit( 0 );
			}
		});
		
		addKeyListener( new KeyAdapter() {

			@Override public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				switch (key) {
				case KeyEvent.VK_A:
					hero.pos.x -= 3;
					break;
				case KeyEvent.VK_D:
					hero.pos.x += 3;
					break;
				}
				
				gamePane.repaint();
			}
		});
	}
	
	private void setGamePane() {
			
		gamePane = new JPanel() {
			@Override protected void paintComponent(Graphics g) {
				
				g.drawImage( background_img, 0, 0, this );
				g.drawImage( hero_img, hero.pos.x, hero.pos.y, this );
				
				// 삭제시 데이터 충돌을 방지 하기 위해 순회할 대상 자료를 복제
				Iterator<MeteoVO> it = getCloneArray();
				
				while( it.hasNext() )	{
					MeteoVO meteo = it.next();
					
					g.drawImage( meteo_img, meteo.pos.x, meteo.pos.y, this );
				}
				
				// draw exploit images
				for( int idx = 0; idx < expVOList.size(); idx++ )	{
					ExploitVO exp = expVOList.get( idx );
					
					g.drawImage( exploit_imgs.get( exp.index ) , exp.pos.x, exp.pos.y, this );
					
					// exploit 객체가 remove 되는데 move_index() 호출이 27 번 일어나게 된다.
					// 그러므로 바로 삭제되는 듯 보이지만 실제로는 바로 삭제 되지 않고 index 값이 계속 변하는 것이다.
					if( exp.move_index() )
						expVOList.remove( exp );
				}
			}
		};
		
		// 화면에 표시될 크기를 미리 예약함. 
		// Dimension 타입 인자를 받음.
		gamePane.setPreferredSize( d );
		
		add( gamePane );
	}
	
	Iterator<MeteoVO> getCloneArray() {
		return ( (ArrayList<MeteoVO>) meteoVoList.clone() ).iterator();
	}
	
	public void setHero(  ) {
		
		int width = hero_img.getWidth( this );
		int height = hero_img.getHeight( this );
		
		int posX = ( d.width - hero_img.getWidth( this ) ) / 2;
		int posY = d.height - hero_img.getHeight( this ) - 10;
		
		hero = new HeroAvatar( new Rectangle( posX, posY, width, height ) );
	}

	public static void main(String[] args) {
		new AvoidingMeteorites();
	}
}
