package hanbit_image;

import java.awt.*;
import java.awt.event.*;

public class FrameImage extends Frame{

	Image image;
	
	public FrameImage(){
		super("�̹��� �׽�Ʈ");

		image = Toolkit.getDefaultToolkit().getImage("IMAGES/icon.png");

		setBounds(200,200,500,500);
		setVisible(true);
	}

	public void paint(Graphics g){
		g.drawImage(image, 70, 70, this);
	}

	public static void main(String[] args){
		new FrameImage();
	}
}