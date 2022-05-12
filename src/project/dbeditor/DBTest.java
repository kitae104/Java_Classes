package project.dbeditor;

public class DBTest {

	public static void main(String[] args) {
		DB.init();
		new DBEditor("DB Editor", 1000, 600);
	}

}
