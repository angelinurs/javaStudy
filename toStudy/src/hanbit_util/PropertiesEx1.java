package hanbit_util;

import java.util.Properties;
import java.util.Enumeration;
import static java.lang.System.out;

public class PropertiesEx1 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.put("UserName", "John");
		prop.setProperty("lovely", "Hana");
		prop.setProperty("dbDRV", "oracle.jdbc.driver.OracleDriver");
		
		String user = prop.getProperty("UserName");
		String love = prop.getProperty("lovely");
		String dbDRV = prop.getProperty("dbDRV");
		
		out.println( String.format("%s, %s, %s", user, love, dbDRV));
		
		Enumeration<?> keys = prop.propertyNames();
		
		while( keys.hasMoreElements() )
			out.println( keys.nextElement() );
		
		prop.list(System.out);

	}

}
