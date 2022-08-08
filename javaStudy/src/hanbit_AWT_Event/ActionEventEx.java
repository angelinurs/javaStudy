package hanbit_AWT_Event;

import java.awt.*;
import java.awt.event.*;

public class ActionEventEx extends Frame implements ActionListener{
	Panel p;
	Button input, exit;
	TextArea ta;
	
	public ActionEventEx()	{
		super("ActionEvent test");
		
		
		p = new Panel();
		input = new Button("Input");
		exit = new Button("exit");
		ta = new TextArea();
		
		input.addActionListener(this);
		exit.addActionListener(this);
		
		p.add( input );
		p.add( exit );
		
		add( p, BorderLayout.NORTH );
		add( ta, BorderLayout.CENTER );
		
		setBounds( 300, 300, 300, 300);
		setVisible( true );
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String name;
		name = ae.getActionCommand();
		
		if(name.equals("Input"))
			ta.append("pressed input button\n");
		else	{
			ta.append("program exit.\n");
			try {
				Thread.sleep(2000);
			}catch( Exception e)	{
				;
			}finally {
				System.exit(0);
			}
		}
		
	}

	public static void main(String[] args) {
		new ActionEventEx();

	}
}
