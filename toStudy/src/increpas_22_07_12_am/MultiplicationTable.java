package increpas_22_07_12_am;

public class MultiplicationTable {
	int num;
	StringBuffer sb;
	
	public MultiplicationTable( int num )	{
		this.num = num;
		
		this.cal();		
	}
	
	public int getNum() { return num; }
	public void setNum( int num ) { this.num = num; }
	
	public void cal() {
		if( num < 2 || num > 9 )	{
			System.out.println( "2~9 사이만 입력하세요.");
			return;
		}
		sb = new StringBuffer();
		
		sb.append( "=== " + num + " 단 ===\n");
		
		for( int post = 1; post < 10; post++ ) {
			sb.append( String.format( "%2d x %d = %2d\n", num, post, num * post) );
		}
		
		this.print_view();
	}
	public void print_view() {
		System.out.println( sb.toString() );
	}
}
