package increpas_22_07_08_pm;

import java.util.Arrays;
import java.util.Scanner;
/*
 *  야구 게임
 */

public class Baseball {
	int[] zone;
	int[] check_board;
	int[] user;
	
	int ballCount = 0;
	
	int strikeCnt, ballCnt, OutCnt;
	
	/*
	 * out : 0
	 * ball : 1
	 * strike : 2
	 */
	
	public Baseball()	{
		
		setZone();
		System.out.println( getZone() );
		
		while( strikeCnt != 3 ) play();
		
		System.out.println( "Done.");
	}
	
	public void setZone() {
		boolean dup = false;
		
		zone = new int[3];
		zone[ 0 ] = (int)( Math.random() * 9 + 1 );
		
		for( int idx = 1; idx < zone.length;  )	{
			
			int ball = (int)( Math.random() * 9 + 1 );
			
			for( int jdx = 0; jdx < idx; jdx++  ) {
				if ( zone[ jdx ] == ball )	{
					dup = true;					
					break;
				}
			}
			
			if( !dup ) zone[ idx++ ] = ball;
		}
	}
	
	public void setUser() {
		
		user = new int[3]; 
		Scanner sc = new Scanner( System.in );
		
//		for( int idx = 0; idx < tusu.length; idx++ )	{
//			user[ idx ] = sc.nextInt();
//		}
		
		// Check input data length ( size -> 3 )
//		for( ; ; ) {
//			String[] ar = sc.nextLine().split(" ");
//			
//			if( ar.length == 3 ) break;
//		}
		
		String[] ar = sc.nextLine().split(" ");
		
		for( int idx = 0; idx < ar.length; idx++ ) {
			user[ idx ] = Integer.parseInt( ar[ idx ] );
//			user[ idx ] = Integer.valueOf( ar[ idx ] );
		}
	}
	
	public String getZone() {
//		StringBuffer sb = new StringBuffer();
//		
//		sb.append("== Setting zone ==" );
//		sb.append( "\n" );
//		
//		for( int digit : zone )
//			sb.append( String.valueOf( digit ) + " " );
//			
//		sb.append( "\n" );		
//		
//		return sb.toString();
		
		return Arrays.toString( zone );
	}
	
	public void play( )	{
		
		check_board = new int[3];
		
		strikeCnt = 0;
		ballCnt = 0;
		
		System.out.println( ( ballCount++ + 1 ) +" 번째 " + "input 3 ball ");
		
		setUser();
		
		for ( int idx = 0; idx < user.length; idx++ ) 
			for( int jdx = 0; jdx < zone.length; jdx++ )
				if ( zone[ jdx ] == user[idx] )
					check_board[ idx ] = ( idx == jdx ) ? 2: 1;
		
		strikeCount();
		ballCount();
		
		show_stat();
	}
	
	public void strikeCount() {
		for( int val : check_board )
			if( val == 2 )
				strikeCnt++;
	}
	
	public void ballCount() {
		for( int val : check_board )
			if( val == 1 )
				ballCnt++;
	}
	
	public void show_stat()	{
		StringBuffer sb = new StringBuffer();
		
		String prn = String.format("%d Strkie, %d Ball, %d Out\n", strikeCnt, ballCnt, 3 - strikeCnt- ballCnt );
		sb.append("\n" + prn );
		System.out.println( sb.toString() );		
	}

	public static void main(String[] args) {
		
		new Baseball();
	}
}
