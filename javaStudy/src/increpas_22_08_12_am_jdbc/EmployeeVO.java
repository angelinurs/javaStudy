package increpas_22_08_12_am_jdbc;

public class EmployeeVO {
	int emp_no;
	String first_name,
		   last_name,
		   birth_date,
		   gender,
		   hire_date;
	
	public EmployeeVO( int emp_no, 
					   String first_name, String last_name, 
					   String birth_date, String gender, String hire_date) {
		this.emp_no = emp_no;
		this.first_name = first_name;
		this.last_name = last_name;
		this.birth_date = birth_date;
		this.gender = gender;
		this.hire_date = hire_date;
	}

	public int getEmp_no() { return emp_no; }
	public void setEmp_no(int emp_no) { this.emp_no = emp_no; }

	public String getFirst_name() { return first_name; }
	public void setFirst_name(String first_name) { this.first_name = first_name; }

	public String getLast_name() { return last_name; }
	public void setLast_name(String last_name) { this.last_name = last_name; }

	public String getBirth_date() { return birth_date; }
	public void setBirth_date(String birth_date) { this.birth_date = birth_date; }

	public String getGender() { return gender; }
	public void setGender(String gender) { this.gender = gender; }

	public String getHire_date() { return hire_date; }
	public void setHire_date(String hire_date) { this.hire_date = hire_date; }
	
	public String toString( ) {
		StringBuffer sb  = new StringBuffer();
		sb.append( "emp_no : " ).append( emp_no ).append( ",\t" );
		sb.append( "hire_date : " ).append( hire_date ).append( ",\t" );
		sb.append( "first_name : " ).append( first_name ).append( ",\t" );
		sb.append( "last_name : " ).append( last_name ).append( ",\t" );
		sb.append( "birth_date : " ).append( birth_date ).append( ",\t" );
		
		return sb.toString();
	}
};
