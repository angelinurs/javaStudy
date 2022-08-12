package increpas_22_08_12_am_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class JDBCex2 {

	public static void main(String[] args) {
		ArrayList< EmployeeVO > empList = new ArrayList<>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		PreparedStatement ps = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/employees";
		String user = "root";
		String pwd = "1111";
		
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			
			con = DriverManager.getConnection( dbUrl, user, pwd );
			System.out.println( "This connection is success!!" );

			String sql = "SELECT * FROM employees where gender = ?";
			
			Scanner sc = new Scanner( System.in );
			
			System.out.println( "input gender : ");
			String gen = sc.next();
			
			
			ps = con.prepareStatement(sql);
			
			ps.setString( 1, gen );
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				int emp_no = rs.getInt( "emp_no" );
				String first_name = rs.getString( "first_name" );
				String last_name = rs.getString( "last_name" );
				String birth_date = rs.getString( "birth_date" );
				String gender = rs.getString( "gender" );
				String hire_date = rs.getString( "hire_date" );
				
				
				EmployeeVO emp = new EmployeeVO(emp_no, first_name, last_name, birth_date, gender, hire_date);
				
				empList.add( emp );
				
				System.out.println( emp.toString() );
//				System.out.printf( "%10d, %-15s %n", emp_no, first_name );
			}
			
			// check total columns count
			ps = con.prepareStatement( "select count(*) as `count` from employees" );
			rs = ps.executeQuery();
			
			// first line is column names line
			// thus, to skip use ResultSet.next() method
			rs.next();
			System.out.println( rs.getInt( "count" ));
			
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

}
