package project.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_db?characterEncoding=UTF-8&useUnicode=yes&serverTimezone=UTC",
                    "root", "1111");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 에러");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("DB 연결 오류 또는 쿼리 오류 입니다.");
            e.printStackTrace();
            return null;
        }
    }
}
