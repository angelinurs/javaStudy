package hanbit_util;

import java.util.Calendar;
import static java.lang.System.out;

public class CalendarEx1 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		
		Calendar now = Calendar.getInstance();
		
		int week_yy = now.get( now.WEEK_OF_YEAR );
		int yy = now.get( now.YEAR );
		int mm = now.get( now.MONTH ) + 1;
		int dd = now.get( now.DAY_OF_MONTH );
		
		sb.append( week_yy ).append(" week " ).append( yy ).append(" year ").append( mm ).append(" month ").append( dd ).append(" day");
		
		out.println( sb.toString() );
		
		out.println( now.getWeeksInWeekYear() );
		out.println( now.getWeekYear() );
	}

}
