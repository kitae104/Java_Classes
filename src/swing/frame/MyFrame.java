package swing.frame;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(1800, 300); 
//		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("My 프레임", 300, 200);
	}

}
