package hanbit_AWT_Event;

import java.awt.*;
import java.awt.event.*;

public class MouseMotionEventEx extends Frame 
								implements MouseMotionListener, 
										   ActionListener {
	
	Label move = new Label("trace to mouse", Label.CENTER);
	
	Button exit = new Button("Exit");
	
	public MouseMotionEventEx()	{
		super("MouseMotionEvent test");
		
		setLayout(null);
		
		move.setBounds(100, 50, 150, 20);
		exit.setBackground(Color.RED);
		
		add( move );
		add( exit );
		
		setBounds( 300, 100, 500, 600);
		setVisible( true );
		
		addMouseMotionListener(this);
		exit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new MouseMotionEventEx();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Exit"))
			System.exit(0);		
	}

	@Override
	public void mouseDragged(MouseEvent e) { }

	@Override
	public void mouseMoved(MouseEvent e) {
		Point p = e.getPoint();
		move.setLocation(p);
	}
}
