package test.y22_1_m;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test_D_Frame extends JFrame implements ActionListener {	

	private JMenuBar mb;
	private JMenu menuTest;
	private JMenuItem menuItemQ1;
	private JPanel panelBase;
	private JList list;
	private DefaultListModel<String>  listModel;


	public Test_D_Frame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocation(300, 200); 
		//setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 메뉴 추가 
		makeMenu();
		
		// 패널 추가 
		makeBasePanel();	
		
		setVisible(true);
	}
	
	
	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	private void makeMenu() {
		mb = new JMenuBar();
		
		menuTest = new JMenu("문제");
		
		menuItemQ1 = new JMenuItem("간단 계산기");
		menuItemQ1.addActionListener(this);
		
		
		menuTest.add(menuItemQ1);
		
		mb.add(menuTest);
		
		setJMenuBar(mb);		
	}

	private void makeBasePanel() {
		panelBase = new JPanel();
		panelBase.setLayout(new BorderLayout());
		panelBase.setBackground(Color.YELLOW);
		
		listModel = new DefaultListModel<>();
		
		list = new JList();
		list.setModel(listModel);
		JScrollPane sp = new JScrollPane(list, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelBase.add(sp);
		
		add(panelBase);
	}
	
	public static void main(String[] args) {
		new Test_D_Frame("학번  이름", 300, 300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == menuItemQ1) {			
//			new LayoutTest("간단한 계산기", 350, 250, this);
			new SimpleCalcFrame2("계산기", 200, 200);
		}
	}

}
