package increpas_22_07_19_am;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class BaseballWithHashSet {
	ArrayList<Integer> zone;
	int[] check_board;
	ArrayList<Integer> user;
	
	int ballCount = 0;
	
	int strikeCnt, ballCnt;
	
	/*
	 * out : 0
	 * ball : 1
	 * strike : 2
	 */
	
	public BaseballWithHashSet()	{
		check_board = new int[3];
		zone = new ArrayList<>();
		
		setZone();
		
//		System.out.println( getZone() );
//		
//		while( strikeCnt != 3 ) play();
//		
//		System.out.println( "Done.");
	}
	
	public void setZone() {
		
		zone.clear();
		
		HashSet<Integer> temp = new HashSet<>();
		
		while( temp.size() < 3 )
			temp.add( (int)( Math.random() * 9 + 1 ) );
		
		Iterator<Integer> it = temp.iterator();
		
		while( it.hasNext() )
			zone.add( it.next() );
	}
	
	
	
	public void setUser( ArrayList<Integer> userInput ) {
		user = userInput;
	}
	
	public String getZone() { 
		return zone.toString();
	}
	
	public void play( )	{
		
		strikeCnt = 0;
		ballCnt = 0;
		
		for ( int idx = 0; idx < user.size(); idx++ ) 
			for( int jdx = 0; jdx < zone.size(); jdx++ )
				if ( zone.get( jdx ) == user.get( idx ) )
					check_board[ idx ] = ( idx == jdx ) ? 2: 1;
		
		strikeCount();
		ballCount();
		
//		show_stat();
	}
	
	public void strikeCount() {
		for( int val : check_board )
			if( val == 2 )
				strikeCnt++;
	}
	
	public int getStrikeCount()	{
		return strikeCnt;
	}
	
	public void ballCount() {
		for( int val : check_board )
			if( val == 1 )
				ballCnt++;
	}
	
	public String show_stat()	{
		StringBuffer sb = new StringBuffer();
		
		String prn = String.format("%d Strkie, %d Ball, %d Out\n", strikeCnt, ballCnt, 3 - strikeCnt- ballCnt );
		sb.append( "\n" + prn );
		
		return sb.toString();	
	}
	
	public String msg() {
		return new StringBuffer().append( ballCount++ + 1 ).append(" 번째 ")
				                 .append("input 3 ball ").append( "\n" )
				                 .toString();
	}
}
