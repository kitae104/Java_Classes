package part2.frame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FirstFrame extends JFrame {

	public FirstFrame() {
		setTitle("프레임");
		setSize(300, 200);
		setLocationRelativeTo(null);	
		setLayout(new FlowLayout());
		
		JButton btn = new JButton("버튼");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("1111");
				
			}
		});
		add(btn);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FirstFrame();
	}
}
