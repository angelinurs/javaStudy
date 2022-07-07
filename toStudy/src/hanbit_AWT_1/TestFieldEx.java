package hanbit_AWT_1;

import java.awt.*;

public class TestFieldEx {
	
	public static void main(String[] args) {
		
		Frame f = new Frame("TextField Test");
		
		Panel p = new Panel();
		
		Label lb1 = new Label("Id : ");
		Label lb2 = new Label("Passwd : ");
		
		TextField tf1 = new TextField("", 12);
		TextField tf2 = new TextField("input passwd", 10);
		
//		tf1.selectAll();
//		tf2.selectAll();
		
		tf2.setEchoChar('*');
		
		p.add(lb1);
		p.add(tf1);
		p.add(lb2);
		p.add(tf2);
		
		f.add(p);
		
		f.setLocation(300, 300);
		f.setSize(400, 100);
		f.setVisible(true);

	}

}
