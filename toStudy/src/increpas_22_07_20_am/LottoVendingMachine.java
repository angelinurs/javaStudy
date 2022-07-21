package increpas_22_07_20_am;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LottoVendingMachine extends JFrame
								implements ActionListener {
	// 번호 생성 누르면 새로운 번호 나오는거
	
	JPanel main_p, bottom_p;
	
	JButton createBtn;
	
	ArrayList<ImageIcon> lottoIcons;
	
	String pathFmt = "src/imageLottos/%d.jpg";
	
	public LottoVendingMachine() {
		super( "LottoVendingMachine Test." );
		
		lottoIcons = new ArrayList<>();
		
		main_p = new JPanel( new FlowLayout( FlowLayout.CENTER ) );
		bottom_p = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
		
		createBtn = new JButton( "Create Lotto numbers !!" );
		
		bottom_p.add( createBtn );
		
		main_p.setBackground( Color.WHITE );
		
		createBtn.addActionListener( this );
		
		pickBall();
		
		add( main_p, BorderLayout.CENTER );
		add( bottom_p, BorderLayout.SOUTH );
		
		setBounds( 300, 300, 600, 200 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	

	public static void main(String[] args) {
		new LottoVendingMachine();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if( o == createBtn )	{
			main_p.removeAll();
			
			pickBall();
			
			main_p.updateUI();
		}
	}
	
	public void pickBall() {
		TreeSet<Integer> ts = new TreeSet<>();
		
		while( ts.size() < 6 )	{
			ts.add( (int)( Math.random() * 45 + 1 ) );
		}
		
		Iterator<Integer> it = ts.iterator();
		
		while( it.hasNext() ) {
			
			lottoIcons.add( new ImageIcon( String.format( pathFmt, it.next() ) ) );
			
			main_p.add( new JLabel( lottoIcons.get( lottoIcons.size() - 1 )) );
//			System.out.println(String.format( pathFmt, it.next() ) );
		}
	}
}
