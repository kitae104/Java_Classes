package part2.gui.event;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

public class StringMove extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblName;

	private final int STEP = 10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					StringMove frame = new StringMove();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					// 키보드 동작을 위해서는 포커스를 설정해야 함(중요!!) - 화면 등장 이후에 설정
					frame.getContentPane().requestFocus();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StringMove()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {				
				lblName.setLocation(e.getPoint());
			}
		});
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				char keyChar = e.getKeyChar();
				String keyText = e.getKeyText(keyCode);
				System.out.println("keyCode : " + keyCode + ", keyChar : " + keyChar + ", keyText : " + keyText);
				
				switch(keyCode) {
				case KeyEvent.VK_UP:
					lblName.setLocation(lblName.getX(), lblName.getY() - STEP);
					break;
				case KeyEvent.VK_DOWN:
					lblName.setLocation(lblName.getX(), lblName.getY() + STEP);
					break;
				case KeyEvent.VK_LEFT:
					lblName.setLocation(lblName.getX() - STEP, lblName.getY());
					break;
				case KeyEvent.VK_RIGHT:
					lblName.setLocation(lblName.getX() + STEP, lblName.getY());
					break;
				}
				
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				lblName.setLocation(x, y);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					Random random = new Random();
					int r = random.nextInt(256);
					int g = random.nextInt(256);
					int b = random.nextInt(256);
					contentPane.setBackground(new Color(r, g, b));
				}
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblName = new JLabel("홍길동");
		lblName.setForeground(new Color(0, 128, 64));
		lblName.setFont(new Font("굴림", Font.BOLD, 16));
		lblName.setBounds(79, 58, 69, 26);
		contentPane.add(lblName);		
	}
}
