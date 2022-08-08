package increpas_22_08_05_am_serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// 임의의 class define
// Serializable interface 는 abstract method 가 없으므로,
// implement 할 필요가 없다.
// 다만 implements Serializable 문구 자체만으로 Serialize 된다는 일종의 마킹이다.
class Person implements Serializable {
	String name;
	int age;
	
	public Person() { }

	public Person( String name, int age ) {
		this.name = name;
		this.age = age;
	}

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public int getAge() { return age; }

	public void setAge(int age) { this.age = age; }
}

public class Stream_Serialize_Main {
	
	// 임의의 object 파일에 저장하기
	public static void output_Serialized_Object() {
		
		// 파일에 직렬화 쓰기 할 객체 생성
		Person student = new Person( "alex",  27 );
		
		// 저장할 파일 경로 지정
		String path = "src/SAVE/objectSerialized.obj";
		
		File file = new File( path );
		
		if( file.exists() ) {
			return;
		}
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream( file );
			
			// object 를 file 로 저장하기 위해서 Object Stream 이 필요함.
			oos = new ObjectOutputStream( fos );
			
			// 아래의 코드는 object serialize 하지 않은 object 를 바로 쓰기하므로,
			// serialize exception error 가 발생한다.
			oos.writeObject( student );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( fos != null ) fos.close();
				if( oos != null ) oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 임의의 object 파일에서 읽어오기
	public static void read_Serialized_Object() {
		String path = "src/SAVE/objectSerialized.obj";
		
		File file = new File( path );
		
		if( !file.exists() ) {
			return;
		}
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			// object 를 파일로 부터 읽기를 하기위해 필요한 stream
			fis = new FileInputStream( file );
			ois = new ObjectInputStream( fis );
			
			// 연결된 stream 에서 object 를 읽어오기
			Object obj = ois.readObject();
			
			Person data = null;
			if( obj instanceof Person ) {
				// 만약 읽어온 Object instance 에 Person 이 있다면
				// 강제로 casting 한다. ( Down Case )
				
				data = (Person) obj;
				
			}
			
			System.out.println( data.getName() );
			System.out.println( data.getAge() );
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} finally {
				try {
					if( fis != null ) fis.close();
					if( ois != null ) ois.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static void main(String[] args) {
		// 임의의 object 파일에 저장하기
//		output_Serialized_Object();
		
		// 임의의 object 파일에서 읽어오기
		read_Serialized_Object();
	}

}
