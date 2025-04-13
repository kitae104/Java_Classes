package part2.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentPaneFrame extends JFrame {

	public ContentPaneFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(500, 300); 
//		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new FlowLayout());
		
//		getContentPane().setBackground(Color.RED);
		
		Container c = getContentPane();		
		c.setBackground(Color.ORANGE);
		
		// 컴포넌트 
		JButton b1 = new JButton("OK");	
		b1.setBackground(Color.RED);
		add(b1);
		
		JButton b2 = new JButton("Cancel");
		add(b2);
		
		JButton b3 = new JButton("Ignore");
		add(b3);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ContentPaneFrame("ContentPane 프레임", 350, 150);
	}

}
