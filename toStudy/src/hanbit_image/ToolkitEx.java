package hanbit_image;

import java.awt.*;
import java.awt.event.*;

public class ToolkitEx extends Frame
					 implements KeyListener, Runnable {
	
	Image image;	
	int x, y, mx, my, sel;
	
	public ToolkitEx()	{
		super("Toolkit image test");
		
		// project name -> right click -> new source folder 
		// and reference to "soucefoldername/filename"
//		image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\class-02\\git\\javaStudy\\toStudy\\images\\icon.png");
//		image = Toolkit.getDefaultToolkit().getImage("IMAGES/sealion.jpg");
		image = Toolkit.getDefaultToolkit().getImage("IMAGES/icon.png");
		
		x = 225;
		y = 255;
		mx = 0;
		my = 0;
		sel = 0;
		
		Thread t = new Thread(this);
		
		t.start();
		
		addKeyListener(this);
		
		setBounds(200, 200, 500, 500 );
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.drawImage(image, x, y, x+80, y+80, 
					sel*50, 0, sel*50+80, 80, this);
	}

	@Override
	public void keyReleased(KeyEvent e) { }

	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) {
		
		if( e.getKeyCode() == e.VK_LEFT) {
			mx = -10;
			my = 0;
			sel = 0;
		} else if( e.getKeyCode() == e.VK_RIGHT) {
			mx = 10;
			my = 0;
			sel = 2;
		} else if( e.getKeyCode() == e.VK_UP) {
			mx = 0;
			my = -10;
			sel = 4;
		} else if( e.getKeyCode() == e.VK_DOWN) {
			mx = 0;
			my = 10;
			sel = 6;
		} else if( e.getKeyCode() == e.VK_ESCAPE) {
			System.exit(0);
		} 
	}
	
	@Override
	public void run() {
		while(true) {
			x += mx;
			y += my;
			
			if( sel%2 == 0) sel++;
			else sel--;
			
			if( x <= -50 ) x = 500;
			else if( x >= 500 ) x = 0;
			else if( y <= -50 ) y = 500;
			else if( y >= 500 ) y = 0;
			
			try {
				Thread.sleep(100);
				repaint();
			}catch(Exception e)	{}
					
		}
	}
	
	public static void main(String[] args) {
		new ToolkitEx();

	}



}
