package increpas_22_07_25_am;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

class MyMouseAdapter extends MouseAdapter {
	JPanelWithThread2 frame;
	ArrayList<MyThread2> arr;
	
	public MyMouseAdapter(JPanelWithThread2 frame) {
		this.frame = frame;
		arr = new ArrayList<>();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		MyThread2 t = new MyThread2(frame, e.getX(), e.getY() );
		t.start();
		arr.add(t);
	}
	
}

class MyThread2 extends Thread {
	
	JPanelWithThread2 frame;
	
	int x, y;
	int width = 50, height = 50;
	Graphics img_g;
	
	public MyThread2( JPanelWithThread2 frame, int x, int y ) {
		
		this.frame = frame;
		this.x = x;
		this.y = y;
		
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
			img_g = frame.myPane.img.getGraphics();
			
			// 아래의 코드는 thread 간의 자원을 공유 하는 코드
			frame.setToBackground( img_g );
			img_g = frame.getToBackground();
			
			
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

class MyPanel2 extends JPanel{
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

public class JPanelWithThread2 extends JFrame {
	
	MyPanel2 myPane;
	Graphics background = null;

	public JPanelWithThread2( ) {
		add( myPane = new MyPanel2() );
		
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 300, 300, 300, 300 );
		
		addMouseListener( new MyMouseAdapter( this ) );
	}
	
	public void setToBackground( Graphics background ) {
		this.background = background;
	}
	public Graphics getToBackground()	{
		
		return background;
	}

	public static void main(String[] args) {
		new JPanelWithThread2();
	}
}
