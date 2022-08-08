package hanbit_AWT_Event;

import java.awt.*;
import java.awt.event.*;

public class TextEventEx extends Frame implements ActionListener, TextListener {
	
	TextField tf = new TextField(30);
	
	Button input = new Button("Input");
	
	TextArea ta = new TextArea(100, 100);
	Button exit = new Button("Exit");
	
	public TextEventEx()	{
		super("TextEvent test");
		
		input.setEnabled(false);
		
		Panel p = new Panel();
		
		p.add(new Label("Title : "));
		p.add(tf);
		p.add(input);
		
		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(exit, BorderLayout.SOUTH);
		
		setBounds( 300, 300, 400, 300);
		setVisible( true );
		
		tf.addTextListener(this);
		input.addActionListener(this);
		exit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new TextEventEx();

	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		
		if( str.equals("Input"))	{
			ta.append(tf.getText() + "\n");
			tf.setText("");
			tf.requestFocus();
		}
		
		if( str.equals("Exit"))
			System.exit(0);
	}

	@Override
	public void textValueChanged(TextEvent te) {
		if( tf.getText().equals(""))
			input.setEnabled(false);
		else
			input.setEnabled(true);		
	}
}
