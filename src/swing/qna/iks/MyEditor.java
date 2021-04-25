package swing.qna.iks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyEditor extends JFrame implements ActionListener{
	
	private JMenuBar mb;
	private JMenu menuFile, menuEdit, menuInfo;
	private JMenuItem menuItemNew, menuItemOpen, menuItemSave, menuItemExit, menuItemInfo;
	
	private HashMap<String, Integer> hash = new HashMap<>();
	
	public MyEditor(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		makeMenu();
		
		this.setJMenuBar(mb);				
		
		setVisible(true);
	}
 
	private void makeMenu() {
		mb = new JMenuBar();								
		menuFile = new JMenu("파일");			
		
		menuItemNew = new JMenuItem("새파일");	
		menuFile.add(menuItemNew);				
		
		menuItemOpen = new JMenuItem("열기");
		menuItemOpen.addActionListener(this);	
		menuFile.add(menuItemOpen);
 
		menuItemSave = new JMenuItem("저장");
		menuFile.add(menuItemSave);
		
		menuFile.addSeparator();					
		
		menuItemExit = new JMenuItem("닫기");
		menuItemExit.addActionListener(this);
		menuFile.add(menuItemExit);
		
		
		menuEdit = new JMenu("편집");
		
		menuInfo = new JMenu("정보");
		
		menuItemInfo = new JMenuItem("프로그램 정보");
		menuInfo.add(menuItemInfo);
		
		mb.add(menuFile);
		mb.add(menuEdit);
		mb.add(menuInfo);
	}
 
	public static void main(String[] args) {
		new MyEditor("간단 메모장", 800, 500);
 
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == menuItemExit) {
			System.exit(0);								
		}
		else if(obj == menuItemOpen) {
			openPanel();
		}
		
	}
 
	private void openPanel() {
		MainFrame frame = new MainFrame("내프레임", 300, 300);
		
	}
 
}
