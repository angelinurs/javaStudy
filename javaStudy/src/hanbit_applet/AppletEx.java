package hanbit_applet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("removal")
public class AppletEx extends Applet 
					  implements ActionListener {
	
	TextField tf;
	Button b;
	List list;
	
	public void init()	{
		setLayout(new BorderLayout());
		
		String name = getParameter("name");
		
		Panel p = new Panel();
		list = new List(10);
		
		Label l = new Label("Receiver : ");
		tf = new TextField( name, 20 );
		b = new Button("Send");
		
		p.add(l);
		p.add(tf);
		p.add(b);
		
		add( p, BorderLayout.NORTH);
		add( list, BorderLayout.CENTER);
		
		tf.addActionListener(this);
		b.addActionListener(this);
		
		list.add("init() call");
	}
	
	public void start()	{
		list.add("start() call");
	}
	
	public void stop()	{
		list.add("stop() call");
	}
	
	public void paint(Graphics g)	{
		list.add("paint() call");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		list.add( tf.getText() );
		tf.setText("");
	}
}
