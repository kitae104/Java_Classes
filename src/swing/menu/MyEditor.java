package swing.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

import swing.components.CheckBoxEx;

public class MyEditor extends JFrame implements ActionListener {

	private JMenuBar mb;
	private JMenu menuFile, menuEdit, menuInfo;
	private JMenuItem menuItemNew, menuItemOpen, menuItemSave, menuItemExit;
	private JMenuItem menuItemInfo;
	
	private JToolBar toolBar;
	
	private JButton btnNew, btnOpen, btnSave, btnExit;
	private JButton btnOk;
	
	private JTextArea ta;
	
	private final int EXIT_SUCCESS = 0;	// 상수 
	
	private ImageIcon[] imgs = { new ImageIcon("images/new.png"),
			  new ImageIcon("images/open.png"),
			  new ImageIcon("images/save.png"),
			  new ImageIcon("images/exit.png")
	};
		
	private CheckBoxEx chkEx;
	
	private JPanel panelBase;
	
	private JTextField tf;
	
	public MyEditor(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
//		setLocation(1800, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 레이아웃
		setLayout(new BorderLayout());
		
		// 메뉴 추가 
		makeMenu();
		
		// 툴 바 추가 
		makeToolBar();
		
		// 패널 추가 
		makeBasePanel();		
		
		setJMenuBar(mb);
		
		add(toolBar, BorderLayout.NORTH);
		
		add(panelBase);
		
		setVisible(true);
	}
	
	private void makeBasePanel() {
		panelBase = new JPanel();
		panelBase.setLayout(new BorderLayout());
		panelBase.setBackground(Color.YELLOW);
		
		/*
		tf = new JTextField(20);
		panelBase.add(tf);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		panelBase.add(btnOk);
		*/
		
		ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelBase.add(sp);
	}

	private void makeToolBar() {
		toolBar = new JToolBar("내 툴바");
		
		btnNew = new JButton(imgs[0]);
		btnNew.addActionListener(this);
		
		btnOpen = new JButton(imgs[1]);
		btnOpen.addActionListener(this);
		
		btnSave = new JButton(imgs[2]);
		btnSave.addActionListener(this);
		
		btnExit = new JButton(imgs[3]);
		btnExit.addActionListener(this);
		btnExit.setToolTipText("프로그램을 종료합니다.");
		
		toolBar.add(btnNew);
		toolBar.add(btnOpen);
		toolBar.add(btnSave);
		toolBar.addSeparator();
		toolBar.add(btnExit);
		
	}

	private void makeMenu() {
		mb = new JMenuBar();
		
		menuFile = new JMenu("파일");
		
		menuItemNew = new JMenuItem("새파일");
		menuFile.add(menuItemNew);
		
		menuItemOpen = new JMenuItem("열기");
		menuFile.add(menuItemOpen);
		
		menuItemSave = new JMenuItem("저장");
		menuItemSave.addActionListener(this);
		menuFile.add(menuItemSave);
		
		menuFile.addSeparator();
		
		menuItemExit = new JMenuItem("닫기");
		menuItemExit.addActionListener(this);
		menuItemExit.setToolTipText("프로그램을 종료합니다.");
		
		menuFile.add(menuItemExit);
		
		menuEdit = new JMenu("편집");
		
		
		menuInfo = new JMenu("정보");
		menuItemInfo = new JMenuItem("프로그램정보");
		menuItemInfo.addActionListener(this);
		
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
		
		if(obj == menuItemExit || obj == btnExit) {
			
			checkExit();
			
		} else if(obj == menuItemInfo) {
			chkEx = new CheckBoxEx("체크박스 연습", 250, 200, this);			
		} else if(obj == btnOk) {
			String msg = JOptionPane.showInputDialog("숫자1?");
			int sum = Integer.parseInt(msg) + 10;
			tf.setText(sum + "");
		} else if(obj == btnNew) {
			ta.setText("");
		} else if (obj == btnOpen || obj == menuItemOpen) {	
			//FileNameExtensionFilter filter = new FileNameExtensionFilter(
			//		"텍스트파일", 
			//		"txt");			
			JFileChooser fc = new JFileChooser();
			//fc.setFileFilter(filter);
			fc.addChoosableFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
			fc.addChoosableFileFilter(new FileNameExtensionFilter("TEXT", "txt"));
			fc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
			//fc.setAcceptAllFileFilterUsed(false);
			
			fc.showOpenDialog(null);
			
			File in = fc.getSelectedFile();
			BufferedReader br = null;
			String line = null;
		
			try {				
				br = new BufferedReader(new FileReader(in));				
				while((line = br.readLine()) != null) {
					ta.append(line + "\n");
				}
			} catch (FileNotFoundException e1) {				
				e1.printStackTrace();
			} catch (IOException e1) {				
				e1.printStackTrace();
			} finally {
				try {					
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		} else if(obj == btnSave || obj == menuItemOpen) {
			JFileChooser fc = new JFileChooser();
			fc.addChoosableFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
			fc.addChoosableFileFilter(new FileNameExtensionFilter("TEXT", "txt"));
			fc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
			
			fc.showSaveDialog(null);
			
			File out = fc.getSelectedFile();
			BufferedWriter bw = null;			
		
			try {				
				bw = new BufferedWriter(new FileWriter(out));	
				String str = ta.getText();
				str = str.replace("\n", System.getProperty("line.separator"));
				bw.write(str);
				
			} catch (FileNotFoundException e1) {				
				e1.printStackTrace();
			} catch (IOException e1) {				
				e1.printStackTrace();
			} finally {
				try {					
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}			
			
		}
	}

	/**********************************************
	 * 
	 * @date : 2020. 5. 20.
	 * 설명 : JOption을 이용한 나가기 기능 구현   
	 **********************************************
	 */
	private void checkExit() {
		int result = JOptionPane.showConfirmDialog(null, "정말나갈까요?","나가기", 
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(result == JOptionPane.YES_OPTION) {
			System.exit(EXIT_SUCCESS);
		}
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	
}
