package increpas_22_07_20_am;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class CanvasOverride extends Canvas{
	
	Image img;
	
	public CanvasOverride() {
		//이미지를 만들기 위해 필요한 객체 생성
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		String filename = "src/Images/sealion.jpg";
		img = tk.getImage( filename );
	}
	
	@Override
	public void paint(Graphics g) {
		// argument g 는 붓과 같은 역활을 한다.
		g.drawImage(img, 0, 0, 300, 200, this );
		
		g.drawLine(150, 10, 300, 10);
		
		g.setColor( Color.GREEN );
		
		g.drawRect(150, 20, 100, 100);
		
		g.setColor( Color.ORANGE );
		g.fillRect( 150, 122, 100, 100);
		
	}
}
