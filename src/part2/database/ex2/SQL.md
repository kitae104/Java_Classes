### SELECT 예제
ResultSet rs = DB.getResultSet("SELECT * FROM users WHERE name = ?", "홍길동");
while (rs.next()) {
    System.out.println(rs.getString("email") + " / " + rs.getInt("age"));
}

### INSERT 예제
int result = DB.executeUpdate("INSERT INTO users (name, email, age) VALUES (?, ?, ?)",
                              "홍길동", "hong@test.com", 25);
if (result > 0) {
    System.out.println("삽입 성공");
}

### UPDATE 예제
DB.executeUpdate("UPDATE users SET age = ? WHERE name = ?", 30, "홍길동");

### UPDATE 예제
DB.executeUpdate("DELETE FROM users WHERE email = ?", "hong@test.com");
