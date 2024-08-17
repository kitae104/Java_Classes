package jaemin.exceptions;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver1");
            DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db", "root", "1234");
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } finally{
            System.out.println("무조건 실행");
        }
    }
}
