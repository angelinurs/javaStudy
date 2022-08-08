package increpas_22_07_12_am;

public class Organism {
	int age;
	String name;
	String[] features;
	
	public Organism() {;}
	
	public Organism( int age, String name, String[] features )	{
		this.age = age;
		this.name = name;
		
		// shallow copy
//		this.features = features;
		
		// deep copy
		this.features = new String[ features.length ];
		
		for( int idx = 0; idx < features.length; idx++ )	{
			this.features[ idx ] = features[ idx ];
		}
	}

	public void setAge( int age )	{ this.age = age; }
	
	public void setName( String name ) { this.name = name; }
	
	public void setFeeatures( String[] features ) { 
		this.features = new String[ features.length ];
		
		for( int idx = 0; idx < features.length; idx++ )	{
			this.features[ idx ] = features[ idx ];
		} 
	}
	
	public int getAge() { return age; }	
	public String getName() { return name; }
	public String[] getFeatures()	{ return features; }

}
