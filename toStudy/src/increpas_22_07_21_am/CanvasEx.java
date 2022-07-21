package increpas_22_07_21_am;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class CanvasEx extends Canvas {
	
	int posX, posY;

	@Override
	public void paint(Graphics g) {
		
		StringBuffer sbAxis = new StringBuffer();		
		
//		g.setColor( Color.BLACK );
		g.setColor( new Color( posX % 256, posY % 256, ( posX + posY ) % 256) );
		
		sbAxis.append( String.format( "x : %d, y : %d", posX, posY ) );
		
		g.drawString( sbAxis.toString(), posX, posY );
	}

	@Override
	public void update(Graphics g) {
		paint( g );
	}
}
