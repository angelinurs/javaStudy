package hanbit_thread2;

import java.util.ArrayList;
import java.util.List;

public class Car {
	
	private List<String> carList = null;
	
	public Car() {
		carList = new ArrayList<String>();
	}
	
	public String getCar() {
		String carName = null;
		
		switch( ( int )(Math.random() * 3 ) )	{
		case 0 : 
			carName = "SM5";
			break;
		case 1 : 
			carName = "Tesla";
			break;
		case 2 : 
			carName = "Ferrari";
			break;
		}
		
		return carName;
	}
	
	public synchronized String pop() {
		String carName = null;
		
		if( carList.size() == 0 ) {
			try	{
				System.out.println( "[ Wait ] " + carList.size() );
				this.wait();
			} catch ( InterruptedException e )	{
				e.printStackTrace();
			}
		}
		carName = (String)carList.remove(
								carList.size() - 1
							);
		System.out.println( "[ Sale ] " + carList.size() + " -> [ " + carName + " ] " );
		
		return carName;
	}

	public synchronized void push( String car ) {
		if( carList.size() == 5 ) {
			this.notify();
		}
		carList.add( car );
		
		System.out.println( "[ Produce ] " + carList.size() + " -> [ " + car + " ] " );
		
	}
}
