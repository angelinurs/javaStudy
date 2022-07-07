package hanbit_AWT_2;

import java.awt.*;

@SuppressWarnings("serial")
public class GridBagLayoutEx extends Frame {
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	
	public GridBagLayoutEx()	{
		super(" GridBagLayout Test");
		
		gb = new GridBagLayout();
		setLayout( gb );
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		addToFrame( new Button("Component 1"), 0, 0, 2, 1, 2.0, 1.0 );
		addToFrame( new Button("Component 2"), 2, 0, 1, 1, 0.5, 1.0 );
		addToFrame( new Button("Component 3"), 0, 1, 3, 1, 3.0, 1.0 );
		addToFrame( new Button("Component 4"), 0, 2, 1, 2, 0.0, 1.0 );
		addToFrame( new Button("Component 5"), 1, 2, 2, 1, 0.0, 1.0 );
		addToFrame( new Button("Component 6"), 1, 3, 2, 1, 0.0, 1.0 );
		
		setBounds( 200, 200, 200, 200 );
		
//		setSize(400, 800);
		setVisible(true);
	}
	
	public void addToFrame( Component com, int x, int y,
										   int width, int height,
										   double weight_x, double weight_y )	{
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weight_x;
		gbc.weighty = weight_y;
		
		add( com, gbc );
	}
	
	public static void main(String[] args) {
		new GridBagLayoutEx();
	}

}
