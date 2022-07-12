package increpas_22_07_08_pm;

import java.util.Scanner;
/*
 *  야구 게임
 */

public class Baseball {
	int[] zone;
	int[] check_board;
	boolean dup = false;
	
	int ballCount = 0;
	
	int strikeCnt, ballCnt, OutCnt;
	
	/*
	 * out : 0
	 * ball : 1
	 * strike : 2
	 */
	
	public Baseball()	{
		zone = new int[3];
		check_board = new int[3];
		
		setZone();
	}
	
	public void setZone() {
		zone[ 0 ] = (int)( Math.random() * 8 + 1 );
		
		for( int idx = 1; idx < zone.length;  )	{
			
			int ball = (int)( Math.random() * 8 + 1 );
			
			for( int jdx = 0; jdx < idx; jdx++  ) {
				if ( zone[ jdx ] == ball )	{
					dup = true;					
					break;
				}
			}
			
			if( dup ) dup = false;
			else zone[ idx++ ] = ball;
		}
	}
	
	public void print_zone() {
		
		System.out.println("== Setting zone ==");
		
		for( int digit : zone )
			System.out.print( digit + " " );
		System.out.println();
	}
	
	public void play( )	{
		clear_board();
		
		int[] tusu = new int[3]; 
		Scanner sc = new Scanner( System.in );
		
		System.out.println( ( ballCount++ + 1 ) +" 번째 " + "input 3 ball ");
		
		for( int idx = 0; idx < tusu.length; idx++ )	{
			tusu[ idx ] = sc.nextInt();
		}
		
		for ( int idx = 0; idx < tusu.length; idx++ ) {
			for( int jdx = 0; jdx < zone.length; jdx++ ) {
				if ( zone[ jdx ] == tusu[idx] )	{
					if( idx == jdx )
						check_board[idx] = 2;
					else
						check_board[idx] = 1;
				}
			}
		}
		
		this.strikeCount();
		this.ballCount();
		
		show_stat();
		
		strikeCnt = 0;
		ballCnt = 0;
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
	
	public void clear_board()	{
		for( int idx = 0; idx < check_board.length; idx++ )	{
			check_board[ idx ] = 0;
		}
	}
	public void show_stat()	{
		StringBuffer sb = new StringBuffer();
		String stat;
		for( int idx = 0; idx < check_board.length; idx++ )	{
			stat = ( check_board[ idx ] == 0 ) ? "out" :
				   ( check_board[ idx ] == 1 ) ? "ball" : "strike";
			sb.append( stat+" " );
		}		
		
		String prn = String.format("%2d Strkie, %2d Ball, %2d Out\n", strikeCnt, ballCnt, 3 - strikeCnt- ballCnt );
		sb.append("\n" + prn );
		System.out.println( sb.toString() );		
	}

	public static void main(String[] args) {
		
		Baseball game = new Baseball();
		
		game.print_zone();
		
		game.play();
	}
}
