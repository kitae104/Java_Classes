package db;

public class Test {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
		
			
			System.out.println("OK!");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
			e.printStackTrace();
		}
	}
}
