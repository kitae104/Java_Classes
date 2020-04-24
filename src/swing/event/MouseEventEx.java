package swing.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseEventEx extends JFrame implements MouseListener, ActionListener {

	private JButton btn;
	private JButton btn2;

	public MouseEventEx(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(1800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new FlowLayout());
		
		btn = new JButton("마우스 이벤트 테스트 버튼");
		btn.addMouseListener(this);
		btn.addActionListener(this);
		add(btn);
		
		btn2 = new JButton("Test");
		btn2.addMouseListener(this);
		add(btn2);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MouseEventEx("마우스 이벤트 연습", 300, 200);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == btn) {
			btn.setBackground(Color.RED);
		}else if(obj == btn2) {
			btn2.setBackground(Color.YELLOW);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == btn) {
			btn.setBackground(Color.YELLOW);
		} else if(obj == btn2) {
			btn2.setBackground(Color.RED);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn) {
			System.out.println(btn.getText());
		}
		
	}

}
