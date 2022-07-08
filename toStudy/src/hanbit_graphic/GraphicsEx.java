package hanbit_graphic;

import java.awt.*;
import java.awt.event.*;

public class GraphicsEx extends Frame
						implements ActionListener {
	
	Point first_point, last_point, old_point;
	
	MenuItem menu_tool_pen, menu_tool_line, 
			 menu_tool_circle, menu_tool_rect;
	
	String str = "Pen";
	
	public GraphicsEx()	{
		super("Graphics test");
		
		MenuBar mb = new MenuBar();
		
		Menu menu_tool = new Menu("Tools");
		
		menu_tool_pen = new MenuItem("Pen");
		menu_tool_line = new MenuItem("Line");
		menu_tool_circle = new MenuItem("Circle");
		menu_tool_rect = new MenuItem("Rectangle");
		
		menu_tool.add( menu_tool_pen);
		menu_tool.add( menu_tool_line);
		menu_tool.add( menu_tool_circle);
		menu_tool.add( menu_tool_rect);
		
		mb.add( menu_tool );
		setMenuBar(mb);
		
		add( new GrimPanCanvas(), BorderLayout.CENTER );
		
		setBounds( 200, 200, 400, 400 );
		setVisible(true);
		
		menu_tool_pen.addActionListener(this);
		menu_tool_line.addActionListener(this);
		menu_tool_circle.addActionListener(this);
		menu_tool_rect.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		MenuItem selected_menu = (MenuItem)ae.getSource();
		
		if( selected_menu.equals(menu_tool_pen))
			str = menu_tool_pen.getLabel();
		
		else if( selected_menu.equals(menu_tool_line))
			str = menu_tool_line.getLabel();
		
		else if( selected_menu.equals(menu_tool_circle))
			str = menu_tool_circle.getLabel();
		
		else if( selected_menu.equals(menu_tool_rect))
			str = menu_tool_rect.getLabel();		
	}

	public static void main(String[] args) {
		new GraphicsEx();

	}
	
	class GrimPanCanvas extends Canvas
						implements MouseMotionListener,
								   MouseListener	{
		public GrimPanCanvas()	{
			addMouseListener(this);
			addMouseMotionListener(this);
		}

		@Override
		public void mouseClicked(MouseEvent e) { }

		@Override
		public void mousePressed(MouseEvent me) {
			first_point = me.getPoint();
			old_point = me.getPoint();
		}

		@Override
		public void mouseReleased(MouseEvent me) {
			last_point = me.getPoint();
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) { }

		@Override
		public void mouseExited(MouseEvent e) { }

		@Override
		public void mouseDragged(MouseEvent me) {
			last_point = me.getPoint();
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) { }
		
		public void update(Graphics g) {
			paint(g);
		}
		
		public void paint( Graphics g ) {
			if( first_point != null && last_point != null )	{
				if( str.equals("Pen"))	{
					g.drawLine(first_point.x, first_point.y, last_point.x, last_point.y);
					first_point = last_point;
					
					return;
				}
				else if( str.equals("Line"))	{
//					g.setColor(new Color(1.0f, 0.0f, 0.0f, 0.5f));
					g.setColor(Color.WHITE);
					g.drawLine(first_point.x, first_point.y, old_point.x, old_point.y);
					
					g.setColor(Color.BLACK);
					g.drawLine(first_point.x, first_point.y, last_point.x, last_point.y);
					
					return;
				}
				else if( str.equals("Circle"))	{
//					g.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0f));
					g.setColor( new Color( 255,255,255) );
					g.fillOval(first_point.x, first_point.y, 
							old_point.x - first_point.x, old_point.y -first_point.y);
					
					g.setColor(new Color(0, 0, 255));
					g.fillOval(first_point.x, first_point.y, 
							last_point.x - first_point.x, last_point.y -first_point.y);
				}
				else if( str.equals("Rectangle"))	{
					g.setColor( new Color( 255,255,255) );
					g.fillRect(first_point.x, first_point.y, 
							old_point.x - first_point.x, old_point.y -first_point.y);
					
					g.setColor(new Color(0, 0, 255));
					g.fillRect(first_point.x, first_point.y, 
							last_point.x - first_point.x, last_point.y -first_point.y);
				}
				old_point = last_point;
			}
		}
	}
}
