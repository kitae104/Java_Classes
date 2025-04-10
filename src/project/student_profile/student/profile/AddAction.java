package project.student_profile.student.profile;

import java.sql.Connection;
import java.sql.PreparedStatement;

import project.common.DB;

public class AddAction {

	/**
	 * DB에 학생 프로필 추가
	 * @param studentProfile
	 * @return boolean
	 */
	public boolean add(StudentProfile studentProfile) {
		boolean check = false; // 성공 여부
		
		try {
			Connection conn = DB.getCon();	// DB 연결
			String query = "INSERT INTO profile(name, dept, address) VALUE (?,?,?)";	// SQL 쿼리문
			PreparedStatement pstmt = conn.prepareStatement(query); // 쿼리문 준비
	           
			pstmt.setString(1, studentProfile.getName()); 
			pstmt.setString(2, studentProfile.getDept());
			pstmt.setString(3, studentProfile.getAddress());
			pstmt.executeUpdate();	 // 쿼리문 실행
	           
	        check = true;	// 성공 여부
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return check;
	}
}
