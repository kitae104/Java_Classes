package project.student_profile.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_db", "root", "1111");
			return con;
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}
}