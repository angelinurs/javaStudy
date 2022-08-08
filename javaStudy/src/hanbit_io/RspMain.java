package hanbit_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

//
class Rsp implements Serializable {
	private int win, lose, draw;
	private String name;

	public int getWin() { return win; }
	public int getLose() { return lose; }
	public int getDraw() { return draw; }
	
	public String getName() { return name; }

	public void setWin(int win) { this.win = win; }
	public void setLose(int lose) { this.lose = lose; }
	public void setDraw(int draw) { this.draw = draw; }

	public void setName(String name) { this.name = name; }
};

//
class ScoreLoader {
	private Rsp info;
	
	public Rsp getInfo() {
		return info;
	}
	
	public ScoreLoader( Rsp info ) {
		this.info = info;
		
		String path = "src/SAVE"
				    + info.getName().trim()
				    + "/UserInfo.sav";
		File file = new File( path );
		
		ObjectInputStream ois = null;
		if( file.exists() ) {
			
			try {
				ois = new ObjectInputStream( new FileInputStream( file ) );
				
				this.info = (Rsp) ois.readObject();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
					try {
						if( ois != null ) ois.close();
						
						System.out.println( "Load Success!!" );
					} catch (IOException e) {
						e.printStackTrace();
						
						System.out.println( "Load Fail!!" );
					}
			}
		} else {
			System.out.println( "Create New ID" );
		}
	}
};

//
public class RspMain {

	public static void main(String[] args) {
		Rsp rsp = new Rsp();
		
		String id;
		
		int win = 0, lose = 0, draw = 0;
		
		System.out.println( "아이디를 입력하세요 : " );
		
		Scanner sc = new Scanner( System.in );
		
		id = sc.nextLine();
		
		rsp.setName( id );
		
		ScoreLoader loader = new ScoreLoader( rsp );
		
		win = loader.getInfo().getWin();
		lose = loader.getInfo().getLose();
		draw = loader.getInfo().getDraw();
		
		System.out.println( win + " win, " + lose + " lose, " + draw + " draw" );
		
		
		

	}

}
