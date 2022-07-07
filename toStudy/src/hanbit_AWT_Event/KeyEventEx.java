package hanbit_AWT_Event;

import java.awt.*;
import java.awt.event.*;

public class KeyEventEx extends Frame implements KeyListener {
	
	TextArea ta = new TextArea();
	
	public KeyEventEx()	{
		super("KeyEvent test");
		
		add( ta );
		
		setBounds( 300, 300, 400, 300);
		setVisible( true );
		
		ta.addKeyListener(this);
	}
	
	public static void main(String[] args) {
		new KeyEventEx();

	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if( e.getKeyCode() == e.VK_UP)
			ta.append("Up Key\n");
		
		if( e.getKeyCode() == e.VK_DOWN)
			ta.append("Down Key\n");
		
		if( e.getKeyCode() == e.VK_LEFT)
			ta.append("Left Key\n");
		
		if( e.getKeyCode() == e.VK_RIGHT)
			ta.append("Right Key\n");
		
		if( e.getKeyCode() == e.VK_ENTER)
			ta.append("Enter Key\n");
		
	}

	@Override
	public void keyReleased(KeyEvent e) { }
}
