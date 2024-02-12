package swing.builder.app.db;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DbConnection
{
	
	private static Connection conn = null;
	
	public static Connection dbConnector() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db", "root", "1234");
			JOptionPane.showMessageDialog(null, "DB 연결 설공");
			return conn;
		} 
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
		
	}
}
