package swing.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ComboBoxEx extends JFrame implements MouseListener, ActionListener {

	private String[] strs = {"arrow1","arrow2","arrow3"};
		
	private ImageIcon[] imgs = { new ImageIcon("images/arrow1.png"),
								  new ImageIcon("images/arrow2.png"),
								  new ImageIcon("images/arrow3.png")
			};
	
	private JComboBox<String> cbStr;
	private JLabel lblImg;
	
	public ComboBoxEx(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(1800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new FlowLayout());
		
		cbStr = new JComboBox<String>(strs);
		cbStr.addActionListener(this);		
		add(cbStr);
		
		lblImg = new JLabel(imgs[0]);
		add(lblImg);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComboBoxEx("Combo 연습", 300, 300);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == cbStr) {
			int index = cbStr.getSelectedIndex();
			lblImg.setIcon(imgs[index]);			
		}
		
	}

}
