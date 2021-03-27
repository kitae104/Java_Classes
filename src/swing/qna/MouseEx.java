package swing.qna;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseEx extends JFrame implements MouseListener {	

	private JPanel panBase;
	private JLabel lblText;
	
	public MouseEx(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		panBase = new JPanel();
		panBase.setLayout(null);
		panBase.setBackground(Color.YELLOW);
		panBase.addMouseListener(this);
		
		lblText = new JLabel("홍길동");	
		lblText.setBounds(100, 100, 50, 25);
		panBase.add(lblText);
		
		add(panBase);
		
		setVisible(true);
	}
		
	public static void main(String[] args) {
		new MouseEx("마우스로 글자 옮기기", 300, 300);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			int x = e.getX();
			int y = e.getY();
			lblText.setLocation(x, y);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
