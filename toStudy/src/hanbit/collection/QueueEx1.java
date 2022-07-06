package hanbit.collection;

import java.util.*;
import static java.lang.System.out;

public class QueueEx1 {

	public static void main(String[] args) {
		String[] item = {"java","Spring","Maven"};
		
		LinkedList<String> q = new LinkedList<String>();
		
		for( String n : item )	{
			q.offer(n);
			out.println( "queue size -> " + q.size());
		}
		
		String data = "";
		
		while( ( data = q.poll()) != null )
			out.println( data + " remove!!");
		
		out.println(" Queue\'s size -> " + q.size() );
	}

}
