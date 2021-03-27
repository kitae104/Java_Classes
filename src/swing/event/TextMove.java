package swing.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextMove extends JFrame implements MouseListener, KeyListener, MouseMotionListener {

	private JPanel panelBase;   
	private JLabel lblText;
	
	public static final int STEP = 10;
	
	
	public TextMove(String title, int width, int height) {		
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new BorderLayout());
		
		panelBase = new JPanel();	
		panelBase.setLayout(null);
		panelBase.setBackground(new Color(255, 45, 200));
		
		panelBase.addMouseListener(this);
		panelBase.addKeyListener(this);
		
		
		lblText = new JLabel("김기태");
		lblText.setBounds(30, 30, 80, 30);
		panelBase.add(lblText);
		panelBase.addMouseMotionListener(this);
		
		add(panelBase);
		setVisible(true);
		panelBase.requestFocus();
	}
	
	public static void main(String[] args) {
		new TextMove("마우스로 글자 옮기기", 300, 200);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			Random rnd = new Random();
			int r = rnd.nextInt(256);
			int g = rnd.nextInt(256);
			int b = rnd.nextInt(256);
			
			panelBase.setBackground(new Color(r,g, b));
		}
		
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		switch(keyCode) {
		case KeyEvent.VK_UP:
			lblText.setLocation(lblText.getX(), lblText.getY() - STEP);	
			break;
		case KeyEvent.VK_DOWN:
			lblText.setLocation(lblText.getX(), lblText.getY() + STEP);	
			break;
		case KeyEvent.VK_RIGHT:
			lblText.setLocation(lblText.getX() + STEP, lblText.getY());
			break;
		case KeyEvent.VK_LEFT:
			lblText.setLocation(lblText.getX() - STEP, lblText.getY());
			break;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		lblText.setLocation(e.getPoint());		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
