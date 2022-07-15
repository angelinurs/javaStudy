package increpas_22_07_12_am;

import java.time.LocalDate;

public class Flower {
	String name;
	int price;
	LocalDate date;
	
	public Flower() { ; }
	
	public Flower( String name, int price, String date ) { 
		setName(name);
		setPrice(price);
		setDate(date);
	}

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public int getPrice() { return price; }

	public void setPrice(int price) { this.price = price; }

	public LocalDate getDate() { return date; }

	public void setDate( String date ) {
//		int year, month, day;
//		
//		String[] ar = date.split("-");
//		
//		year = Integer.parseInt( ar[ 0 ] );
//		month = Integer.parseInt( ar[ 1 ] );
//		day = Integer.parseInt( ar[ 2 ] );
//		
//		this.date = LocalDate.of( year, month, day );
		
		this.date = LocalDate.parse( date );
	}
}
