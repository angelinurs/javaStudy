package hanbit.collection;

import java.util.Vector;

public class VectorMain {
	
	public static void viewVector( String title, Vector v )	{
		StringBuffer sb = new StringBuffer();
		
		sb.append( title ).append( "\n" );
		sb.append( "capacity : ").append( v.capacity() ).append( "\n" );
		sb.append( "size : " ).append( v.size() ).append( "\n" );
		
		System.out.println( sb.toString() );
	}
	
	public static void ex1() {
		Vector<String> v = new Vector<>(2, 5);
		
		viewVector( "======  Vector create ======", v );
		
		v.add( "pak" );
		v.add( "young" );
		v.addElement( "sang" );
		
		viewVector( "======  Add element ======", v );
	}
	
	public static void ex2()	{
		Vector<Double> v = new Vector<>( 2, 5 );
		
		// add Elements
		v.add( 100.3 );
		v.add( 3.3 );
		v.addElement( 1000. );
		
		for( double n : v )	{
			System.out.println( n );
		}
		
		// search Element
		double search = 1000.0;
		int index = v.indexOf( search  );
		
		System.out.println( ( index != -1 ) ? index + "index exist" : "not extist" );
		
		viewVector( "======  Search Element ======", v );
		
		// delete Element
		double del = 3.3;
		
		if( v.contains( del ) )	{
			v.remove( del );
			System.out.println( del + " deleted.");
		}
		
		viewVector( "======  Delete Element ======", v );
		
		// customize Vector capacity
		v.trimToSize();
		
		viewVector( "======  Customize Vector Capacity ======", v );
	}
	
	 public static void ex3() {       
        //Create an empty Vector1  
        Vector<Double> v = new Vector<>(2, 5);     
        
        //Add elements in the vector  
        v.add(1.);  
        v.add(2.);  
        v.add(3.);  
//        vec.add(4.);  
//        vec.add(5.);
        
        Double[] arr = new Double[ v.size() ];  
        
        //copy elements of vector into an array  
        v.copyInto(arr);    
        
        System.out.println("Elements in an array are: ");  
        for(Double num : arr)  
        {  
            System.out.println(num);  
        }        
     }

	public static void main(String[] args) {
//		ex1();
//		ex2();
		ex3();

	}

}
