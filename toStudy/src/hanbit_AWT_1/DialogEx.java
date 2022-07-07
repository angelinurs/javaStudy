package hanbit_AWT_1;

import java.awt.*;

public class DialogEx extends Frame {
	public DialogEx()	{
		super("Dialog test");
		
		Dialog d = new Dialog(this, "User Dialog");
		
		// Frame config
		setSize(200, 200);
		setVisible(true);
		
		// Dialog config		
		d.setSize(200, 100);
		d.setVisible(true);
	}

	public static void main(String[] args) {
		new DialogEx();
	}

}
