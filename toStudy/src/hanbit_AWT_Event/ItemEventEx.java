package hanbit_AWT_Event;

import java.awt.*;
import java.awt.event.*;

public class ItemEventEx extends Frame implements ActionListener, ItemListener {
	
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	
	Button exit = new Button("Exit");
	TextArea ta = new TextArea(5, 20);
	
	Checkbox cb1 = new Checkbox("soccer", false);
	Checkbox cb2 = new Checkbox("baseball", false);
	Checkbox cb3 = new Checkbox("basketball", false);
	Checkbox cb4 = new Checkbox("tennis", false);
	
	public ItemEventEx()	{
		super("ItemEvent test");
		
		p1.add( cb1 );
		p1.add( cb2 );
		p1.add( cb3 );
		p1.add( cb4 );
		
		p2.add( exit );
		
		add( p1, BorderLayout.NORTH );
		add( p2, BorderLayout.SOUTH );
		add( ta, BorderLayout.CENTER );
		
		setBounds( 300, 300, 300, 300);
		setVisible( true );
		
		exit.addActionListener(this);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		System.exit(0);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if( e.getStateChange() == ItemEvent.SELECTED )
			ta.append(e.getItem() + " is selected\n\n");
		else if( e.getStateChange() == ItemEvent.DESELECTED )
			ta.append(e.getItem() + " is not selected\n\n");
	}

	public static void main(String[] args) {
		new ItemEventEx();

	}
}
