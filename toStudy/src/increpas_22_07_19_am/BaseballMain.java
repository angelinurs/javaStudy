package increpas_22_07_19_am;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseballMain {

	public static void main(String[] args) {
		ArrayList<Integer> data = new ArrayList<>();
		
		Baseball bball = new Baseball();
		
		System.out.println( bball.getZone() );
		
		while( bball.getStrikeCount() != 3 ) 	{
			Scanner sc = new Scanner( System.in );
			
			System.out.println( bball.msg() );
			
			for( int idx = 0; idx < 3; idx++ )
				data.add( sc.nextInt() );
			
			bball.setUser( data );
			
			
			bball.play();
			
			System.out.println( bball.show_stat() );
		}
		
		System.out.println( "Congraturation!!" );
	}

}
