package swing.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyEventEx extends JFrame implements KeyListener {

	private JPanel panelBase;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;

	public KeyEventEx(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(1800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new BorderLayout());
		
		panelBase = new JPanel();
		panelBase.addKeyListener(this);
		
		lbl1 = new JLabel("getKeyCode()");		
		lbl1.setOpaque(true);				// 불투명 속성 설정
		lbl1.setBackground(Color.CYAN);
		
		lbl2 = new JLabel("getKeyChar()");
		lbl2.setOpaque(true);
		lbl2.setBackground(Color.CYAN);
		
		lbl3 = new JLabel("getKeyText()");
		lbl3.setOpaque(true);
		lbl3.setBackground(Color.CYAN);
		
		
		panelBase.add(lbl1);
		panelBase.add(lbl2);
		panelBase.add(lbl3);
		
		add(panelBase);
		
		setVisible(true);
		panelBase.requestFocus();
	}
	
	public static void main(String[] args) {
		new KeyEventEx("키 이벤트 연습", 300, 200);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		char keyChar = e.getKeyChar();
		String keyStr = e.getKeyText(keyCode);
		lbl1.setText(keyCode+"");
		lbl2.setText(keyChar+"");
		lbl3.setText(keyStr);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
