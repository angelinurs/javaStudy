package hanbit_Except_Assert;

import static java.lang.System.out;

public class AssertTest2 {
	public void gugu( int dan )	{
		assert dan > 1 && dan < 10 : "input : 2~9 > ";
		out.println( dan + " dan" );
		out.println( "--------------");
		
		StringBuffer sb = new StringBuffer();
		
		for( int i = 0; i < 9; i++ ) {
			// clear befor gugu line
			sb.delete( 0, sb.length() );
			
			// make gugu line
			sb.append(dan).append("*").append( i + 1 ).append("=").append(dan*(i+1));
			
			out.println( sb.toString() );
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AssertTest2 at = new AssertTest2();
		
		try	{
			int dan = Integer.parseInt(args[0]);
			at.gugu( dan );
		} catch( Exception e ) {
			e.printStackTrace();
		}

	}

}
