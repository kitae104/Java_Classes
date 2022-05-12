package qna.scrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrollFrame extends JFrame
{
	public ScrollFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
//		setLocation(1800, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new BorderLayout());	
				
		setScrollPanel();
		
		setVisible(true);
	}
	
	private void setScrollPanel()
	{
		JPanel panel = new JPanel();		
		panel.setPreferredSize(new Dimension(400, 1400));   // 패널에 사이즈 설정 
		panel.setBackground(Color.YELLOW);
		
		ImageIcon[] imgs = { 
				new ImageIcon("images/pf01.jpg"),
				new ImageIcon("images/pf02.jpg"),
				new ImageIcon("images/pf03.jpg")				
		};
		
		JLabel imgLabel1 = new JLabel(imgs[0]);
		JLabel imgLabel2 = new JLabel(imgs[1]);
		JLabel imgLabel3 = new JLabel(imgs[2]);
		panel.add(imgLabel1);
		panel.add(imgLabel2);
		panel.add(imgLabel3);
		
		JScrollPane sp = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(sp);
		
	}

	public static void main(String[] args)
	{
		new ScrollFrame("스크롤 패널", 400, 400);

	}

}
