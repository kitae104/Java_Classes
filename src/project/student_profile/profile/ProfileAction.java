package project.student_profile.profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import project.common.DB;

public class ProfileAction {

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

	/**
	 * 전체 학생 프로필 조회
	 * @param id
	 * @return boolean
	 */
	public void display() {
		try {
			Connection conn = DB.getCon();	// DB 연결
			String query = "SELECT * FROM profile";	// SQL 쿼리문
			PreparedStatement pstmt = conn.prepareStatement(query); // 쿼리문 준비
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println("ID : " + rs.getInt(1));
				System.out.println("이름 : " + rs.getString(2));
				System.out.println("학과 : " + rs.getString(3));
				System.out.println("주소 : " + rs.getString(4));
				System.out.println("*******************************");
				System.out.println();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	/**
	 * ID에 의한 학생 프로필 조회
	 * @param id
	 * @return boolean
	 */
	public boolean displayById(int id) {
		boolean check = false; // 성공 여부
		
		try {
			Connection conn = DB.getCon();	// DB 연결
			String query = "SELECT * FROM profile WHERE id = ?";	// SQL 쿼리문
			PreparedStatement pstmt = conn.prepareStatement(query); // 쿼리문 준비
			pstmt.setInt(1, id); // ID 입력
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println("ID : " + rs.getInt(1));
				System.out.println("이름 : " + rs.getString(2));
				System.out.println("학과 : " + rs.getString(3));
				System.out.println("주소 : " + rs.getString(4));
				System.out.println("*******************************");
				System.out.println();
				check = true;	// 성공 여부 변경 
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return check;
	}

	/**
	 * ID에 의한 학생 프로필 삭제
	 * @param studentProfile
	 * @return boolean
	 */
	public boolean deleteById(int deleteId) {
		boolean check = false; // 성공 여부
		
		try {
			Connection conn = DB.getCon();	// DB 연결
			String query = "DELETE FROM profile WHERE id = ?";	// SQL 쿼리문
			PreparedStatement pstmt = conn.prepareStatement(query); // 쿼리문 준비
			pstmt.setInt(1, deleteId); // ID 입력
			pstmt.executeUpdate();	 // 쿼리문 실행
			check = true;	// 성공 여부 변경 
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return check;
	}

	/**
	 * 학생 프로필 이름 수정
	 * @param studentProfile
	 * @return boolean
	 */
	public boolean updateName(int updateId, String updateName) {
		boolean check = false; // 성공 여부
		Connection conn = null; // DB 연결 객체
		PreparedStatement pstmt = null; // PreparedStatement 객체
		try {
			conn = DB.getCon();	// DB 연결
			String query = "UPDATE profile SET name = ? WHERE id = ?";	// SQL 쿼리문
			pstmt = conn.prepareStatement(query); // 쿼리문 준비
			pstmt.setString(1, updateName); // 수정할 이름 입력
			pstmt.setInt(2, updateId); // ID 입력
			pstmt.executeUpdate();	 // 쿼리문 실행
			check = true;	// 성공 여부 변경 
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (conn != null) {
					conn.close(); // DB 연결 해제
				}
				if (pstmt != null) {
					pstmt.close(); // PreparedStatement 해제
				}
			} catch (Exception e) {
				System.out.println("DB 연결 해제 중 오류 발생: " + e.getMessage());
			}
		}
		
		return check;
	}

	public boolean updateDept(int updateId, String updateDept) {
	    boolean check = false;
	    String query = "UPDATE profile SET dept = ? WHERE id = ?";
	    
	    // try-with-resources 방식
	    try (Connection conn = DB.getCon();
	         PreparedStatement pstmt = conn.prepareStatement(query)) {	    	
	    	
	    	pstmt.setString(1, updateDept);
            pstmt.setInt(2, updateId);
            int rowsAffected = pstmt.executeUpdate();
            check = rowsAffected > 0;	// 성공 여부 변경

	    } catch (Exception e) {
	        System.out.println("updateDept 메서드에서 예외 발생: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return check;
	}

	public boolean updateAddress(int updateId, String updateAddress) {
		boolean check = false; // 성공 여부
		String query = "UPDATE profile SET address = ? WHERE id = ?";
		
		try (Connection con = DB.getCon();
			 PreparedStatement pstmt = con.prepareStatement(query)) {
			
			pstmt.setString(1, updateAddress); // 수정할 주소 입력
			pstmt.setInt(2, updateId); // ID 입력
			int rowsAffected = pstmt.executeUpdate();	 // 쿼리문 실행
			check = rowsAffected > 0;	// 성공 여부 변경 
		} catch (Exception e) {
			System.out.println("updateAddress 메서드에서 예외 발생: " + e.getMessage());
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean updateProfile(int updateId, String data, String category) {
		boolean check = false; // 성공 여부
		String query = "UPDATE profile SET " + category + " = ? WHERE id = ?";
		
		try (Connection con = DB.getCon();
				PreparedStatement pstmt = con.prepareStatement(query)) {
			
			pstmt.setString(1, data); // 수정할 주소 입력
			pstmt.setInt(2, updateId); // ID 입력
			int rowsAffected = pstmt.executeUpdate();	 // 쿼리문 실행
			check = rowsAffected > 0;	// 성공 여부 변경 
		} catch (Exception e) {
			System.out.println("프로파일 업데이트 과정에서 예외 발생: " + e.getMessage());
			e.printStackTrace();
		}
		return check;
	}
}
