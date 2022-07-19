package hanbit_class2;

class UserException extends Exception	{
	private int port = 772;

	public UserException(String msg) { super( msg ); }

	public UserException(String msg, int port) {
		super( msg );
		this.port = port;
	}
	
	public int getPort()	{ return port; }
}

public class UserExceptionMain {
	
	public void test( String[] n ) throws UserException	{
		System.out.println( "Test" );
		if( n.length < 1)
			throw new UserException( "nothing" );
		else
//			for( int idx = 0; idx < n.length; idx++ ) System.out.println( n[ idx ]);
			throw new UserException( "finale stage", 703 );
	}	

	public static void main(String[] args) {
		
		UserExceptionMain um = new UserExceptionMain();
		
		try	{
			um.test( args );
		} catch ( UserException ue ) {
//			System.out.println( ue.getMessage() );
			ue.printStackTrace();
		}

	}

}
