package increpas_22_07_22_pm;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SwingAdapterDemo {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public SwingAdapterDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      SwingAdapterDemo  swingAdapterDemo = new SwingAdapterDemo();        
      swingAdapterDemo.showMouseMotionAdapterDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java SWING Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(350,100);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private void showMouseMotionAdapterDemo(){
      headerLabel.setText("Listener in action: MouseMotionAdapter");      
      JPanel panel = new JPanel();      
      panel.setBackground(Color.magenta);
      panel.setLayout(new FlowLayout());        
      
      panel.addMouseMotionListener(new MouseMotionAdapter(){
         public void mouseMoved(MouseEvent e) {
            statusLabel.setText("Mouse Moved: ("+e.getX()+", "+e.getY() +")");
         }                
      });
      JLabel msglabel 
         = new JLabel("Welcome to TutorialsPoint SWING Tutorial.",JLabel.CENTER);
      
      panel.add(msglabel);
      controlPanel.add(panel);
      mainFrame.setVisible(true);  
   }
}