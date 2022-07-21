package increpas_22_07_21_am;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

class canvasEx2 extends Canvas {
	
	int x = -10, y = -10, width = 10, height = 10;
	
	Color c;

	@Override
	public void paint(Graphics g) {
		g.fillOval( x, y, width, height );
	}

	@Override
	public void update(Graphics g) {
		g.setColor( c );
		paint( g );
	}

};

public class canvasMain2 extends JFrame
						 implements MouseMotionListener, 
						 	        ActionListener {
	canvasEx2 can;
	
	JPanel sidePane;
	JPanel blankPane, palletPane, sizePane;
	
	Color c = Color.BLACK;
	
	JButton blackBtn;
	JButton redBtn;
	JButton greenBtn;
	JButton blueBtn;
	JButton yellowBtn;
	JButton orangeBtn;
	
	JLabel sizeLabel;
	JComboBox<Integer> sizeCombo;
	
//	String[] size = { "1", "5", "10" };
	Integer[] size = { 5, 10, 15 };
	
	public canvasMain2()	{
		super( "Canvas test" );
		
		setSidePane();
		add( sidePane, BorderLayout.WEST );
		add( can = new canvasEx2() );
		
		pack();
		
		can.addMouseMotionListener( this );
		
		setBounds( 300, 300, 300, 300 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	public void setSidePane() {
		sidePane = new JPanel( new GridLayout( 3, 1 ) );
		sidePane.add( blankPane = new JPanel() );
		palletPane = new JPanel( new GridLayout( 3, 2 ));
		sizePane = new JPanel();
		
		// pallet panel
		palletPane.add( blackBtn = new JButton() );
		blackBtn.setBackground( Color.BLACK );
		
		palletPane.add( redBtn = new JButton() );
		redBtn.setBackground( Color.RED );
		
		palletPane.add( greenBtn = new JButton() );
		greenBtn.setBackground( Color.GREEN );
		
		palletPane.add( blueBtn = new JButton() );
		blueBtn.setBackground( Color.BLUE );
		
		palletPane.add( yellowBtn = new JButton() );
		yellowBtn.setBackground( Color.YELLOW );
		
		palletPane.add( orangeBtn = new JButton() );
		orangeBtn.setBackground( Color.ORANGE );
		
		sidePane.add( palletPane );
		
		// size comboBox pane
		sizePane.add( sizeLabel = new JLabel( "Size : " ) );
		
		sizePane.add( sizeCombo = new JComboBox<>( size ) );
		
		sidePane.add( sizePane );
		
		blankPane.setBackground( Color.WHITE );
		palletPane.setBackground( Color.WHITE );
		sizePane.setBackground( Color.WHITE );
		
		blackBtn.addActionListener( this );
		redBtn.addActionListener( this );
		greenBtn.addActionListener( this );
		blueBtn.addActionListener( this );
		yellowBtn.addActionListener( this );
		orangeBtn.addActionListener( this );
		
//		sizeCombo.addActionListener( this );
		
		sizeCombo.addItemListener( new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				Object o = e.getSource();
				
				if( o == sizeCombo )	{
					int size = (Integer) sizeCombo.getSelectedItem();
					can.width = size;
					can.height = size;
				}
			}
		});
	}
	
	public static void main( String[] args ) {
		new canvasMain2();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		can.x = e.getX();
		can.y = e.getY();
		
		can.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) { }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		can.c = ( o == blackBtn ) ? Color.BLACK :
				( o == redBtn ) ? Color.RED :
				( o == greenBtn ) ? Color.GREEN :
				( o == blueBtn ) ? Color.BLUE :
				( o == yellowBtn ) ? Color.YELLOW :
				( o == orangeBtn ) ? Color.ORANGE : can.c; 
		
		if( o == sizeCombo )	{
			int size = (Integer) sizeCombo.getSelectedItem();
			can.width = size;
			can.height = size;
		}
	}
}
