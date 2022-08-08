package increpas_22_08_05_am_serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

// serializable 이 이미 구현된 String 과 ArrayList 를 object Stream 으로 저장해보기

public class Stream_Serialize_Main_version_2 {
	
	// ArrayList<String> 으로 저장된 Object file 에 저장하기
	public static void saveStringInArraylist() {
		ArrayList<String> list = new ArrayList<>();
		
		list.add( "JAVA" );
		list.add( "CHOCO" );
		list.add( "1500" );
		
		String path = "src/SAVE/objectOutputStream.obj";
		
		File file = new File( path );
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream( new FileOutputStream( file ) );
			
			oos.writeObject( list );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( oos != null ) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println( "Done." );
		}
		
	}
	
	// ArrayList<String> 으로 저장된 Object file 에서 불러오기
	public static void readStringInArraylist() {
		String path = "src/SAVE/objectOutputStream.obj";
		
		File file = new File( path );
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream( new FileInputStream( file ) );
			
			Object obj = ois.readObject();
			
			ArrayList<String> list = (ArrayList<String>) obj;
			
			for( String item : list ) {
				System.out.println( item );
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if( ois != null ) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println( "done." );
		}
		
	}
	
	public static void main(String[] args) {
		// ArrayList<String> 으로 저장된 Object file 에 저장하기
//		saveStringInArraylist();
		// ArrayList<String> 으로 저장된 Object file 에서 불러오기
		readStringInArraylist();
	}
}
