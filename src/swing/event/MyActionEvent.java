package swing.event;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyActionEvent extends JFrame implements ActionListener {

	private JButton btn, btn2;
	
	public MyActionEvent(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(1800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new FlowLayout());
		
		btn = new JButton("Action");		
		btn.addActionListener(this);
		add(btn);
		
		btn2 = new JButton("자바");		
		btn2.addActionListener(this);
		add(btn2);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyActionEvent("엑션 이벤트 연습", 300, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btn) {
			System.out.println(btn.getText());
		} else if(obj == btn2) {
			System.out.println(btn2.getText());
		}
		
	}

	
}
