package part2.database.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class JDBC_Test {

	public static void main(String[] args) {
		
		try {
			// 1. 오라클 드라이버 설치 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 드라이버 메니저 연결  
			Connection conn = DriverManager.getConnection( 
					"jdbc:mysql://localhost:3306/java_db", 
					"root", "1111");
			
			// 데이서 삽입(Insert)
			String insertSQL = "INSERT INTO MEMBER (name, dept, code) VALUES(?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(insertSQL);
			stmt.setString(1, "최길동");
			stmt.setString(2, "컴시과");
			stmt.setString(3, "1112");
			int num = stmt.executeUpdate();
			if(num > 0) {
				System.out.println("데이터 삽입 성공");
			} else {
				System.out.println("데이터 삽입 실패");
			}
			
			
			
//			String updateSql = 
//					"UPDATE MEMBER " + 
//					"SET 	PW='888', " + 
//					"		AGE=30, " + 
//					"		NAME='최재석' " + 
//					"WHERE ID='B1'";
//			System.out.println(updateSql);
//			stmt.executeUpdate(updateSql);
//			
//			String delId = JOptionPane.showInputDialog("지우고 싶은 ID");
//			String deleteSql = "DELETE FROM MEMBER WHERE ID='" + delId + "'";
//			System.out.println(deleteSql);
//			stmt.executeUpdate(deleteSql);
			
			
			// 데이터 검색 
//			String findId = JOptionPane.showInputDialog("찾고싶은 ID");
//			ResultSet rs = stmt.executeQuery("SELECT * FROM MEMBER WHERE id = '" + findId + "'");
						
			ResultSet rs = stmt.executeQuery("SELECT * FROM MEMBER");
			
			System.out.println("------------------------------------------------------");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");				
				String dept = rs.getString("dept");				
				String code = rs.getString("code");				
				
				System.out.println(id + "\t| " + name + "\t| " + dept + "\t| " + code);
			}
			System.out.println("------------------------------------------------------");
			
			System.out.println("OK!");
			
			conn.close();
			
		} catch (ClassNotFoundException e) {			
			System.out.println("JDBC 드라이버 로드 에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("DB 연결 오류 또는 쿼리 오류 입니다.");
			e.printStackTrace();
		} 
		
	}

}
