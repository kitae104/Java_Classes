package swing.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextMove extends JFrame implements MouseListener {

	private JPanel panelBase;   
	private JLabel lblText;
	
	public TextMove(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(2200, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new BorderLayout());
		
		panelBase = new JPanel();	
		panelBase.setLayout(null);
		panelBase.setBackground(Color.YELLOW);
		panelBase.addMouseListener(this);
		
		
		lblText = new JLabel("김기태");
		lblText.setBounds(30, 30, 80, 30);
		panelBase.add(lblText);
		
		add(panelBase);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextMove("마우스로 글자 옮기기", 300, 200);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {		
		int x = e.getX();
		int y = e.getY();
		lblText.setLocation(x, y);	
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
