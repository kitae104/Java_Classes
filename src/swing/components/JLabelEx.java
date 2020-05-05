package swing.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JLabelEx extends JFrame {

	public JLabelEx(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(1800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new FlowLayout());
		
		//System.out.println(System.getProperty("user.dir"));
		
		ImageIcon icon = new ImageIcon("images/tel.png");
		JLabel lblImg = new JLabel(icon);
		
		ImageIcon icon2 = new ImageIcon("images/java.jpg");
		JLabel lblImg2 = new JLabel(icon2);
		
		ImageIcon icon3 = new ImageIcon("images/arrow1.png");
		ImageIcon icon4 = new ImageIcon("images/arrow2.png");
		ImageIcon icon5 = new ImageIcon("images/arrow3.png");
		JButton btn = new JButton("버튼", icon3);
		btn.setVerticalTextPosition(JButton.TOP);
		btn.setRolloverIcon(icon4);
		btn.setPressedIcon(icon5);
		
		add(lblImg);
		add(lblImg2);
		add(btn);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JLabelEx("JLabel 연습", 680, 700);
	}

}
