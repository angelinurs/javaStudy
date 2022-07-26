package increpas_22_07_25_am;

import java.awt.*;
import javax.swing.*;

class MyThread extends Thread {
	
	JPanelWithThread frame;
	
	int x, y;
	int width = 50, height = 50;
	
	public MyThread( JPanelWithThread frame) {
		
		this.frame = frame;
	}

	@Override
	public void run() {
		/*
		 * Double buffering,
		 * 기존에 화면에 있던 그림을 지우지 않고 새로운 이미지 위에 그림을 올리는것.
		 */
		while( true ) {
//			frame.myPane.y += 5;
			y += 5;
			
//			System.out.println( frame.myPane.y );
			
//			if( frame.myPane.y >= frame.myPane.getHeight() - frame.myPane.height )
			if( y >= frame.myPane.getHeight() - height )
				break;
			
			// myPanel 모양과 같은 Image object 생성
			frame.myPane.img = frame.createImage( frame.myPane.getWidth(), frame.myPane.getHeight() );
			
			// img 에마 그림을 그릴수 있는 Graphics Object 가져오기
			Graphics img_g = frame.myPane.img.getGraphics();
			
			img_g.setColor( Color.BLUE );
			img_g.fillOval(x, y, width, height);
			
			frame.myPane.repaint();
			
			try {
				Thread.sleep( 200 );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class MyPanel extends JPanel{
//	int x, y;
//	int width = 50, height = 50;
	Image img;

	@Override
	public void paint(Graphics g) {
		
//		g.setColor( Color.BLUE );
//		g.fillOval( x, y, width, height );
		
		g.drawImage(img, 0, 0, this );
	}
}

public class JPanelWithThread extends JFrame {
	
	MyPanel myPane;

	public JPanelWithThread( ) {
		add( myPane = new MyPanel() );
		
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 300, 300, 300, 300 );
		
		new MyThread( this ).start();
	}

	public static void main(String[] args) {
		new JPanelWithThread();
	}
}
