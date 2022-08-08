package increpas_22_07_12_am;

import java.text.DecimalFormat;
import java.util.Scanner;

class Drink extends Cup { 
	public Drink() {;}
	public Drink( String name, int price )	{
		setName(name);
		setPrice(price);
	}
};

public class VendingMachine {
	private Drink[] drinks;
	
	// products Datas
	private String[] productNames = { "Coke", "Sprite", "Let's be", "CeylonTea" };
	private int[] productPrices = { 500, 500, 700, 900 };
	
	// insert money buffer
	private int coin;

	public VendingMachine(  ) { 
		drinks = new Drink[ productNames.length ]; 
		
		setDrinks();
		System.out.println( dspProducts() );
		
		System.out.print( "Insert coin : ");
		
		insertCoin( );
		
		Drink drink = selectDrink();
		
		int change = changeMoney( drink );
		
		if( change < 0 )	{
			System.out.println( "돈이 부족합니다." );
		} else {
			DecimalFormat df = new DecimalFormat( "#,###" );
			
			System.out.printf( "거스름 돈 : %s\n", df.format(change) );
		}
	}

	public Drink[] getDrinks() { return drinks; }

	public void setDrinks() {
		for( int idx = 0; idx < drinks.length; idx++ ) {
			drinks[ idx ] = new Drink();
			drinks[ idx ].setName( productNames[ idx ] );
			drinks[ idx ].setPrice( productPrices[ idx ] );
		}
	}
	
	public int getCoin() { return coin; }
	public void setCoin(int coin) { this.coin = coin; }

	// display Products
	public String dspProducts() {
		StringBuffer sb = new StringBuffer();
		String temp;
		
		for( int idx = 0; idx < drinks.length; idx++ )	{
			temp = String.format("%d. %-8s ", idx+1, drinks[idx].getName() );
			sb.append( temp );
		}
		sb.append( "\n" );
		
		temp = "";
		for( int idx = 0; idx < drinks.length; idx++ )	{
			temp = String.format("   %-8d ", drinks[idx].getPrice() );
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
	
	// select Drink
	public Drink selectDrink( )	{
		Scanner sc = new Scanner( System.in );
		int proNum;
		
		for( ;; )	{
			System.out.print( "select procduct : " );
			proNum = sc.nextInt()-1;
			
			if( proNum >= 0 && proNum <= 3 ) break;
			
			System.out.println();
			System.out.println( "-- just select between 1 ~ 4 --" );
		}
				
		return this.drinks[ proNum ];
	}
	
	// change Money
	public int changeMoney( Drink drink )	{
		return ( coin < drink.getPrice() ) ? -1 : coin - drink.getPrice();
	}
}
