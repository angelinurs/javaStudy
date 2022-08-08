package hanbit_AWT_1;

import java.awt.*;

public class MenuEx extends Frame {
	public MenuEx()	{
		super("Menu test");
		
		MenuBar mb = new MenuBar();
		
		Menu mnuFile = new Menu("File");
		Menu mnuColor = new Menu("Color");
		Menu mnuHelp = new Menu("Help");
		
		MenuItem mnuNew = new MenuItem("New File");
		MenuItem mnuOpen = new MenuItem("Open File");
		MenuItem mnuSave = new MenuItem("Save File");
		MenuItem mnuQuit = new MenuItem("Quit File");
		
		mnuFile.add(mnuNew);
		mnuFile.add(mnuOpen);
		mnuFile.add(mnuSave);
		mnuFile.addSeparator();
		mnuFile.add(mnuQuit);
		
		Menu mnuFontColor = new Menu("Font Color");
		mnuColor.add(mnuFontColor);
		
		CheckboxMenuItem mnuBlack = new CheckboxMenuItem("Black", true);
		CheckboxMenuItem mnuRed = new CheckboxMenuItem("Red");
		CheckboxMenuItem mnuBlue = new CheckboxMenuItem("Blue");
		
		mnuFontColor.add(mnuBlack);
		mnuFontColor.add(mnuRed);
		mnuFontColor.add(mnuBlue);
		
		mb.add(mnuFile);
		mb.add(mnuColor);
		mb.add(mnuHelp);
		
		setMenuBar(mb);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MenuEx();
	}

}
