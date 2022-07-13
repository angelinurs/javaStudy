package hanbit_SWING;

import javax.swing.*;
import java.util.Vector;

public class JTreeEx extends JFrame {
	
	Object[] gen = { "Program", "System", "Design" };
	
	Vector<Vector> node1 = new Vector<Vector>()	{
		public String toString()	{
			return "Lesson";
		}
	};

	Vector<String> node2 = new Vector<String>()	{
		public String toString()	{
			return "Java";
		}
	};
	
	Vector<String> node3 = new Vector<String>()	{
		public String toString()	{
			return "XML";
		}
	};
	
	public JTreeEx()	{
		super( "JTree Test" );

		node1.addElement( node2 );
		node1.addElement( node3 );
		
		node2.addElement( "Beg" );
		node2.addElement( "Adv" );
		node2.addElement( "JSP" );
		
		node3.addElement( "XSLT" );
		node3.addElement( "DOM" );
		
		gen[0] = node1;
		
		JTree tree = new JTree( gen );
		tree.setRootVisible( true );
		
		JScrollPane js = new JScrollPane( tree );
		
		add( js );
			
		pack();
		
		setBounds( 300, 300, 600, 250 );
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JTreeEx();
	}

}
