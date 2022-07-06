package hanbit_util;

class Able {
	String empno;
	int net, ejb, xml, total;
	
	public Able( int total ) { this.total = total; }
	public Able( String no, int n, int e, int x ) {
		this.empno = no;
		this.net = n;
		this.ejb = e;
		this.xml = x;
		
		this.total = n + e + x;
	}
	public int getTotal() { return this.total; }

}
