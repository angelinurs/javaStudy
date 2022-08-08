package increpas_22_07_12_am;

class Cup	{
	
	String name;
	int ml;
	String color;
	int price;
	
	public Cup() {;}
	
	public Cup( String name, int ml, String color, int price) {
		this.name = name;
		this.ml = ml;
		this.color = color;
		this.price = price;
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	
	public int getMl()	{ return ml; }
	public void setMl( int ml )	{ this.ml = ml; }
	
	public String getColor() { return color; }
	public void setColor(String color) { this.color = color; }
	
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }


	@Override
	public String toString() {
		return "Cup [ml=" + ml + ", color=" + color + ", price=" + price + "]";
	}
}
