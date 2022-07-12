package increpas_22_07_12_am;

import static java.lang.System.out;

public class OrganismMain {

	public static void main(String[] args) {
		String[] feats = { "fur", "teeth" };
		Organism dog = new Organism( 1, "mungmung", feats );
		
		// shallow vs deep copy test line
		feats[0] = "speak";
		
		for( String feat : dog.getFeatures() )	{
			System.out.println( feat );
		}
		
		Organism cat = new Organism();
		
		out.println( cat.getAge() );
		out.println( cat.getName() );
	}
}
