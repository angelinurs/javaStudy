package increpas_22_07_25_am;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

class BallMouseAdapter extends MouseAdapter {
	BallThreadMain frame;
	
	public BallMouseAdapter(BallThreadMain frame) {
		this.frame = frame;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		BallThread b = new BallThread( e.getX(), e.getY(), 50, 50, frame );
		frame.blist.add( b );
		b.start();
	}
	
};

class BallThread extends Thread {
	int x, y;
	int width = 50, height = 50;
	int speed;
	Color color;
	
	BallThreadMain frame;
	
	public BallThread( int x, int y, 
					   int width, int height, 
					   BallThreadMain frame ) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = ( int )( Math.random() * 10 + 2 );
//		color = new Color( 
//							( int )( Math.random() * 256 ) , 
//							( int )( Math.random() * 256 ) ,
//							( int )( Math.random() * 256 ) 
//						 );
		
		this.frame = frame;
	}

	@Override
	public void run() {
		while( true )	{
//			y += 5;
			y += speed;
			
			// ckeck. panel size over
			if(  y > frame.ballPane.getHeight() - height )
				break;
				
			// repaint
			frame.ballPane.repaint();
			
			try {
				Thread.sleep( 100 );
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
};

class BallPanel extends JPanel {
	BallThreadMain frame;
	
	public BallPanel( BallThreadMain frame) {
		this.frame = frame;
	}

	@Override
	public void paint(Graphics g) {
		Image buf = frame.createImage( this.getWidth(), this.getHeight() );
		Graphics buf_g = buf.getGraphics();
		
		// arraylist 에 있는 item 수 만큼 그리기 
		for( int  idx = 0; idx < frame.blist.size(); idx++ ) {
			BallThread ball = frame.blist.get( idx );
			
			buf_g.fillOval( ball.x, ball.y, ball.width, ball.height );
		}
		
		// ballPane 에 다시 그려주기
		g.drawImage( buf, 0, 0, this );
		
	}
	
};

public class BallThreadMain extends JFrame {
	
	BallPanel ballPane;
	ArrayList<BallThread> blist;
	
	public BallThreadMain() {
		super( "Ball Thread test." );
		
		blist = new ArrayList<>();
		
		add( ballPane = new BallPanel( this ) );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		/* *************************
		 * 아래의 3 라인은 테스트 코드
		 * - begin
		 */
//		BallThread b = new BallThread( 10, 0, 50, 50, this );
//		blist.add( b );
//		b.start();
//		
//		BallThread b2 = new BallThread( 100, 0, 50, 50, this );
//		blist.add( b2 );
//		b2.start();
		/*
		 * - End
		 * **************************/
		
		addMouseListener( new BallMouseAdapter( this ));
	}

	public static void main(String[] args) {
		new BallThreadMain();
	}

}
