package hanbit_SWING;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameEx extends JFrame {
	
	public JFrameEx()	{
		super("JFrame test");
		
		JButton b1 = new JButton("North");
		JButton b2 = new JButton("Center");
		
		Container cp = getContentPane();
		
		cp.add("North", b1);
		cp.add(b2);
		
		setSize(200, 200);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JFrameEx();
	}
}
