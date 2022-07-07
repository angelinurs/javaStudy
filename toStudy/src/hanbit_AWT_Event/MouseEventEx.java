package hanbit_AWT_Event;

import java.awt.*;
import java.awt.event.*;

public class MouseEventEx extends Frame implements MouseListener, ActionListener {
	
	Panel p = new Panel();
	Button test = new Button("Test");
	Button exit = new Button("Exit");
	
	TextArea ta = new TextArea();
	
	public MouseEventEx()	{
		super("MouseEvent test");
		
		p.add(test);
		p.add(exit);
		
		ta.setEditable(false);
		
		add( p, BorderLayout.SOUTH );
		add( ta, BorderLayout.CENTER );
		
		setBounds( 300, 300, 300, 300);
		setVisible( true );
		
		test.addMouseListener(this);
		exit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new MouseEventEx();

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		ta.append("Mouse Clicked..\n");		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		ta.append("Mouse Pressed..\n");		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ta.append("Mouse Released..\n");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		ta.append("Mouse Entered..\n");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		ta.append("Mouse Exited..\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Exit"))
			System.exit(0);
		
	}
}
