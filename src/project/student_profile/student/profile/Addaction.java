package project.student_profile.student.profile;

import java.sql.Connection;
import java.sql.PreparedStatement;

import project.common.DB;

public class Addaction {

	public boolean add(StudentProfile studentProfile) {
		boolean check = false;
		
		try {
			Connection conn = DB.getCon();
			String query = "insert into profile(name,domain,address) value(?,?,?)";
			PreparedStatement p = con.prepareStatement(query);
	           
			p.setString(1, studentProfile.getName());
			p.setString(2, studentProfile.getdomain());
			p.setString(3, studentProfile.getaddress());
			p.executeUpdate();
	           
	        check = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return check;
	}
}
