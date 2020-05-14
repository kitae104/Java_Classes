package swing.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ListEx extends JFrame implements MouseListener {

	private String[] tests = {"test1","test2","test3","test4","test5",
			"test6","test7", "test8","test9","test10"};
	private JList<String> lstTest;
	private JList<ImageIcon> lstImg;
	
	private ImageIcon[] imgs = { new ImageIcon("images/arrow1.png"),
								  new ImageIcon("images/arrow2.png"),
								  new ImageIcon("images/arrow3.png")
			};
	
	
	public ListEx(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(1800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new FlowLayout());
		
		lstTest = new JList<String>(tests);
		lstTest.addMouseListener(this);	
				
		JScrollPane sp = new JScrollPane(lstTest, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(sp);
		
		lstImg = new JList<ImageIcon>(imgs);
		add(lstImg);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ListEx("List 연습", 300, 300);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
