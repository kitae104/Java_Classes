package swing.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPaneEx extends JFrame {

	private JTabbedPane tabPane;
	private JPanel panel;
	public TabbedPaneEx(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(1800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new BorderLayout());
		
		createTabbedPane();
		add(tabPane);
		
		setVisible(true);
	}
	
	private void createTabbedPane() {
		tabPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabPane.addTab("tab1", new JLabel(new ImageIcon("images/java.jpg")));
		tabPane.addTab("tab2", new JLabel(new ImageIcon("images/머신러닝1.jpg")));
				
		panel = new JPanel();
		JButton btn = new JButton("OK!");
		panel.add(btn);
		
		tabPane.addTab("tab3", panel);
	}

	public static void main(String[] args) {
		new TabbedPaneEx("탭 팬 연습", 300, 200);
	}

}
