package hanbit_util;

import java.util.Comparator;

public class AbleComp implements Comparator<Able> {

	@Override
	public int compare(Able o1, Able o2) {
		int var = 0;
		
		var = ( o1.getTotal() > o2.getTotal() ) ?  1 : 
			  ( o1.getTotal() < o2.getTotal() ) ? -1 : 0;
		
		return var;
	}

}
