package hanbit_AWT_2;

import java.awt.*;

@SuppressWarnings("serial")
public class CardLayoutEx extends Frame {
	
	CardLayout card;
	Panel first_panel, second_panel, third_panel;
	
	public CardLayoutEx()	{
		super(" CardLayout Test");
		
		card = new CardLayout();		
		setLayout( card );
		
		first_panel = new Panel();
		first_panel.add( new Button("Btn_1"));
		first_panel.add( new Button("Btn_2"));
		
		second_panel = new Panel();
		second_panel.add( new Button("Btn_3"));
		second_panel.add( new Button("Btn_4"));
		
		third_panel = new Panel();
		third_panel.add( new Button("Btn_5"));
		third_panel.add( new Button("Btn_6"));
		
		add( "1", first_panel);
		add( "2", second_panel);
		add( "3", third_panel);
	}
	
	public void rotate()	{
		for( int idx = 0; idx < 2; idx++ ) {
			try {
				Thread.sleep(3000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			card.next(this);
		}
	}
	
	public static void main(String[] args) {
		CardLayoutEx clt = new CardLayoutEx();
		
		clt.setBounds( 200, 200, 200, 100 );
		clt.setVisible(true);
		
		clt.rotate();
	}

}
