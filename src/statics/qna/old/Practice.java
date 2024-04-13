package statics.qna.old;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Practice extends JFrame implements ActionListener{
	
	private JButton Arrange, Exit, change;
	private JLabel label;
	private JTextField tf;
	private JPanel panelCenter;
	
	public Practice(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		panelNorth();
		panelCenter();
		panelSouth();
		
		
		setVisible(true);
	}
 
 
	private void panelCenter() {
		panelCenter = new JPanel();
		panelCenter.setLayout(null);
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		
	}
 
	private void panelNorth() {
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBackground(Color.yellow);
		
		Arrange = new JButton("새로 배치");
		Arrange.addActionListener(this);
		panelNorth.add(Arrange);
		
		Exit = new JButton("종료");
		Exit.addActionListener(this);
		panelNorth.add(Exit);
		
		getContentPane().add(panelNorth, BorderLayout.NORTH);
	}
 
	private void panelSouth() {
		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new FlowLayout());
		panelSouth.setBackground(Color.gray);
		
		change = new JButton("별 개수 수정");
		change.addActionListener(this);
		panelSouth.add(change);
		
		tf = new JTextField(10);
		tf.addActionListener(this);
		panelSouth.add(tf);
		
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
	}
 
	private void randomStar() {
		for(int i=0;i<Integer.parseInt(tf.getText());i++) {
			int x = (int)(Math.random()*300);
			int y = (int)(Math.random()*300);
			label = new JLabel("*");
			label.setLocation(x, y);
			label.setSize(20, 20);
			panelCenter.add(label);
			panelCenter.repaint();			
		}
	}
	public static void main(String[] args) {
		new Practice("내 프레임", 300, 300);
 
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == Exit) {
			System.exit(0);
		}
		else if(obj == Arrange) {
			randomStar();
			
		}
		
	}
 
	
 
}
