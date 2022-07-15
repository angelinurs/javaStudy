package increpas_22_07_12_am;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;



public class VendingMachine2 {
	private Flower[] flowers;
	
	// products Datas
//	private String[] productNames = { "장미", "소국", "백합", "안개꽃" };
//	private int[] productPrices = { 22000, 17000, 22000, 11000 };
//	private String[] productDates = { "2022-06-10", "2022-07-07", "2022-06-22", "2022-07-11" };
		
	// insert money buffer
	private int coin;

	public VendingMachine2(  ) throws FileNotFoundException { 
		
		
		setFlowersByFile( "Text/productList.txt" );
//		setFlowers();
		System.out.println( dspProducts() );
		
		System.out.print( "Insert coin : ");
		
		insertCoin( );
		
		Flower flower = selectFlower();
		
		int change = changeMoney( flower );
		
		if( invalidDate(flower) ) {
			
			System.out.println( "판매불가");
			System.out.println( "그 꽃은 유통기한이 1 달 지났습니다.");
			return;
		}
		
		if( change < 0 )	{
			System.out.println( "돈이 부족합니다." );
		} else {
			DecimalFormat df = new DecimalFormat( "#,###" );
			
			System.out.printf( "거스름 돈 : %s\n", df.format(change) );
		}
	}

	public Flower[] getFlowers() { return flowers; }

//	public void setFlowers() {
//		flowers = new Flower[ productNames.length ]; 
//		
//		for( int idx = 0; idx < flowers.length; idx++ ) {
//			flowers[ idx ] = new Flower();
//			flowers[ idx ].setName( productNames[ idx ] );
//			flowers[ idx ].setPrice( productPrices[ idx ] );
//			flowers[ idx ].setDate( productDates[ idx ] );
//		}
//	}
	
	public void setFlowersByFile( String filename ) throws FileNotFoundException	{
		File file = new File( filename );
		
		Scanner sc = new Scanner( file );
		
		ArrayList<String> line = new ArrayList<>();
		
		while( sc.hasNextLine() )	{
			line.add( sc.nextLine() );
		}
		flowers = new Flower[ line.size() ];
		
		for( int idx = 0; idx < line.size(); idx++ ) {
			String[] temp = line.get(idx).split("/");
			
			// Case 1.
			// constructor without properties
//			flowers[ idx ] = new Flower();
//			flowers[ idx ].setName( temp[0].trim() );
//			flowers[ idx ].setPrice( Integer.parseInt( temp[1].trim() ) );
//			flowers[ idx ].setDate( temp[2].trim() );
			
			// Case 2.
			// constructor with properties
			flowers[ idx ] = new Flower( temp[0].trim(),	// name
										 Integer.parseInt( temp[1].trim() ), // price
										 temp[2].trim() );	// date
		}
	}
	
	public int getCoin() { return coin; }
	public void setCoin(int coin) { this.coin = coin; }

	// display Products
	public String dspProducts() {
		StringBuffer sb = new StringBuffer();
		String temp;
		
		for( int idx = 0; idx < flowers.length; idx++ )	{
			temp = String.format("%d. %-8s ", idx+1, flowers[idx].getName() );
			sb.append( temp );
		}
		sb.append( "\n" );
		
		temp = "";
		for( int idx = 0; idx < flowers.length; idx++ )	{
			temp = String.format("   %-8d ", flowers[idx].getPrice() );
			sb.append( temp );
		}
		sb.append( "\n" );
		
		temp = "";
		for( int idx = 0; idx < flowers.length; idx++ )	{
			temp = String.format(" %-10s ", flowers[idx].getDate().toString() );
			sb.append( temp );
		}
		sb.append( "\n" );
		
		return sb.toString();
	}
	
	// insert Coin
	public void insertCoin( )	{
		// Case 1.
//		Scanner sc = new Scanner( System.in );
//		
//		int temp = sc.nextInt();
		
		// Case 2.
//		int temp = new Scanner( System.in ).nextInt();
//		
//		setCoin( temp );
		
		// Case 3.
		setCoin( new Scanner( System.in ).nextInt() );
	}
	
	// select Flower
	public Flower selectFlower( )	{
		Scanner sc = new Scanner( System.in );
		int proNum;
		
		for( ;; )	{
			System.out.print( "select procduct : " );
			proNum = sc.nextInt()-1;
			
			if( proNum >= 0 && proNum <= 3 ) break;
			
			System.out.println();
			System.out.println( "-- just select between 1 ~ 4 --" );
		}
				
		return this.flowers[ proNum ];
	}
	
	// change Money
	public int changeMoney( Flower flower )	{
		return ( coin < flower.getPrice() ) ? -1 : coin - flower.getPrice();
	}
	
	public boolean invalidDate( Flower flower ) {
		LocalDate current = LocalDate.now();
		
		System.out.println( current.until( flower.getDate(), ChronoUnit.MONTHS ) );
		
		return ( current.until( flower.getDate(), ChronoUnit.MONTHS ) < 0 )? true: false; 
	}
	
}
