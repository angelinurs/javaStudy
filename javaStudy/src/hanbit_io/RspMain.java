package hanbit_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
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
	
	public String toString() {
		return getWin() + " win, " + getDraw() + " draw, " + getLose() + " lose";
	}
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
class ScoreWriter {
	public ScoreWriter( Rsp rsp ) {
		String path = "./" + rsp.getName().trim() + "/userInfo.sav";
		
		File dir = new File( "./" );
		
		if( !dir.exists() ) {
			dir.mkdir();
		}
		
		File dir2 = new File( dir, rsp.getName().trim() );
		
		if( !dir2.exists() ) {
			dir2.mkdir();
		}
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(  new FileOutputStream( path ) );
			oos.writeObject( rsp );
			
		} catch (FileNotFoundException fnfe ) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
				try {
					if( oos != null ) oos.close();
					
					System.out.println( "save done." );
					
				} catch (IOException ioe) {
					ioe.printStackTrace();
					System.out.println( "save fault" );
				}
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
		
		rsp.setWin(win);
		rsp.setDraw(draw);
		rsp.setLose(lose);
		
		System.out.println( win + " win, " + lose + " lose, " + draw + " draw" );

		while( true ) {
			int random = new Random().nextInt(3);
			
			System.out.println( "[ S ]cissors, [ R ]ock, [ P ]aper" );
			System.out.println( "[ Q ]uit" );
			
			String user = sc.next();
			int userCount = 0;
			
			switch(user.toUpperCase()) {
			case "S" : userCount = 0;
					   break;
			case "R" : userCount = 1;
 					   break;
			case "P" : userCount = 2;
					   break;
			}
			
			// compare to number of cases
			if( userCount - random == -2 || userCount - random == 1 ) {
				System.out.println( "Win" );
				rsp.setWin( ++win );
			} else if( userCount - random == 0 ) {
				System.out.println( "Draw" );
				rsp.setDraw( ++draw );
			} else {
				System.out.println( "Lose" );
				rsp.setLose( ++lose );
			}
			
			System.out.println( rsp.toString() );
			System.out.println( "one more game ? " );
			
			String select = sc.next().trim();
			
			if( select.equalsIgnoreCase( "y" ) ) {
				break;
			}
		}
		
		System.out.println( "It's over" );
		
		ScoreWriter sw = new ScoreWriter( rsp );
	}
}
