package hanbit_SWING;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.*; // import PlainDocument

public class JSliderEx extends JFrame {
	
	JSlider red   = new JSlider( JSlider.HORIZONTAL, 0, 255, 0 );
	JSlider green = new JSlider( JSlider.HORIZONTAL, 0, 255, 0 );
	JSlider blue  = new JSlider( JSlider.HORIZONTAL, 0, 255, 0 );
	
	JLabel rgb = new JLabel( "RGB( 0, 0, 0 )", JLabel.CENTER );
	
	JPanel p1 = new JPanel( new BorderLayout() );
	JPanel west = new JPanel( new GridLayout( 0, 1 ) );
	JPanel center = new JPanel( new GridLayout( 0, 1 ) );
	
	JPanel p2 = new JPanel();
	
	int r, g, b;
	
	public JSliderEx()	{
		super( "JSlider Test" );
		
		red.setMajorTickSpacing( 50 );
		red.setMinorTickSpacing( 5 );
		red.setPaintTicks( true );
		red.setPaintLabels( true );
		
		green.setMajorTickSpacing( 50 );
		green.setMinorTickSpacing( 5 );
		green.setPaintTicks( true );
		green.setPaintLabels( true );
		
		blue.setMajorTickSpacing( 50 );
		blue.setMinorTickSpacing( 5 );
		blue.setPaintTicks( true );
		blue.setPaintLabels( true );
		
		JLabel rlabel = new JLabel( "RED" );
		JLabel glabel = new JLabel( "GREEN" );
		JLabel blabel = new JLabel( "BLUE" );
		
		rlabel.setForeground( Color.red );
		glabel.setForeground( Color.green );
		blabel.setForeground( Color.BLUE );
		
		rgb.setFont( new Font( "돋움채", Font.BOLD, 14 ) );
		
		west.add(rlabel);
		west.add(glabel);
		west.add(blabel);
		
		center.add(red);
		center.add(green);
		center.add(blue);
		
		p1.add( "West", west );
		p1.add( "Center", center );
		
		add( "North", rgb );
		add( "South", p1 );
		add( "Center", p2 );
		
		pack();
		
		setBounds( 300, 300, 600, 300 );
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		red.addChangeListener( new Servent() );
		green.addChangeListener( new Servent() );
		blue.addChangeListener( new Servent() );
	}
	
	class Servent implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			
			if( e.getSource() == red ) {
				r = source.getValue();
			}
			
			if( e.getSource() == green ) {
				g = source.getValue();
			}
			
			if( e.getSource() == blue ) {
				b = source.getValue();
			}
			
			p2.setBackground( new Color( r, g, b ) );
			rgb.setText( "RGB( " + r + ", " + g + ", " + b + " )" );
			
		}
		
	}

	public static void main(String[] args) {
		new JSliderEx();
	}

}
