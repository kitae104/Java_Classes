package swing.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutFrame extends JFrame {

	public BorderLayoutFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(200, 300); 
//		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new BorderLayout(10, 20));
		
		JButton b1 = new JButton("1");
		add(b1, BorderLayout.NORTH);
		
		JButton b2 = new JButton("2");
		add(b2, BorderLayout.SOUTH);
		
		JButton b3 = new JButton("3");
		add(b3, BorderLayout.WEST);
		
		JButton b4 = new JButton("4");
		add(b4, BorderLayout.EAST);
		
		JButton b5 = new JButton("5");
		add(b5);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutFrame("BorderLayout 프레임", 300, 200);
	}

}
