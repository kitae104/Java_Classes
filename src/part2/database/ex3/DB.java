package part2.database.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	public static Connection conn;

    public static void init() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	conn = DriverManager.getConnection( 
					"jdbc:mysql://localhost:3306/java_db", 
					"root", "1111");
            System.out.println("DB 연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("DB 연결 오류 또는 쿼리 오류입니다.");
            e.printStackTrace();
        }
    }

    // SELECT: PreparedStatement와 바인딩 값 전달
    public static ResultSet getResultSet(String sql, Object... params) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            setParams(pstmt, params);
            return pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // INSERT, UPDATE, DELETE: PreparedStatement 사용
    public static int executeUpdate(String sql, Object... params) {
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            setParams(pstmt, params);
            return pstmt.executeUpdate();  // 영향을 받은 행 수 반환
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // PreparedStatement에 파라미터 바인딩 처리
    private static void setParams(PreparedStatement pstmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pstmt.setObject(i + 1, params[i]);  // 인덱스는 1부터 시작
        }
    }
}

