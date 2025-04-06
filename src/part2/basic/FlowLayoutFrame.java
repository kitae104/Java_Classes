package part2.basic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutFrame extends JFrame {

	public FlowLayoutFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(500, 300); 
//		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 40));
		
		JButton b1 = new JButton("1");
		add(b1);
		
		JButton b2 = new JButton("2");
		add(b2);
		
		JButton b3 = new JButton("3");
		add(b3);
		
		JButton b4 = new JButton("4");
		add(b4);
		
		JButton b5 = new JButton("5");
		add(b5);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutFrame("FlowLayout 프레임", 300, 200);
	}

}
