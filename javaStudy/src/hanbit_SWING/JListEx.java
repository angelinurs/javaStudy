package hanbit_SWING;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;

public class JListEx extends JFrame {
	public JListEx()	{
		super( "JList Test" );
		
		setLayout( new FlowLayout( ) );
		
		// 리스트 초기화 방법 1. -> array
		String[] listData = { "ONE", "TWO", "THREE", "FOUR", "FIVE" };
		JList list1 = new JList( listData );
		
		list1.setSelectedIndex( 1 );
		
		// 리스트 초기화 방법 2. -> model
		// - new DefaultListModel()
		JList list2 = new JList( new DefaultListModel() );
		
		DefaultListModel model = (DefaultListModel)list2.getModel();
		
		model.addElement( "사과" );
		model.addElement( "딸기" );
		model.addElement( "바나나" );
		model.addElement( "수박" );
		
		list2.setSelectedIndex( 1 );
		
		// 리스트 초기화 방법 3. -> Vector container
		Vector vListData = new Vector();
		
		JList list3 = new JList( vListData );
		JScrollPane scroll = new JScrollPane( list3 );
		
		String[] sportsData = { 
								"축구", "야구", "농구", "배구", "테니스",
								"수영", "축구", "배드민턴", "육상", "태권도",
								"유도" 
							  };
		
		for( String sports : sportsData )
			vListData.add( sports );
		
		list3.setSelectedIndex( 0 );
		
		// 리스트 초기화 방법 4. -> object
		// - new DefaultListModel()
		class Student	{
			String id, name, department;
			
			public Student( String id, String name, String department ) {
				this.id = id;
				this.name = name;
				this.department = department;
			}
			
			public String toString()	{ return name; }
		}
		
		JList list4 = new JList( new DefaultListModel() );
		
		list4.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		
		model = (DefaultListModel)list4.getModel();
		
		model.addElement( new Student( "100", "홍길동", "전산과" ) );
		model.addElement( new Student( "200", "김삿갓", "국믄과" ) );
		model.addElement( new Student( "300", "성춘향", "국악과" ) );
		
		list4.setSelectedIndex( 1 );
		
		add( list1 );
		add( list2 );
		add( scroll );
		add( list4 );
		
		pack();
		
		setBounds( 300, 300, 300, 300 );
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JListEx();
	}

}
