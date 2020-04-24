package swing.event;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionEventEx extends JFrame {

	public ActionEventEx(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(1800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("1111");
				
			}
		});
		add(btn);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ActionEventEx("엑션 이벤트 연습", 300, 200);
	}
}

