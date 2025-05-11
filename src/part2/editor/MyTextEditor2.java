package part2.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import part2.components.TextAreaEx;


public class MyTextEditor2 {

	private JFrame frame;
	private RSyntaxTextArea taEditor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyTextEditor2 window = new MyTextEditor2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyTextEditor2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("에디터 만들기");
		frame.setBounds(100, 100, 826, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mItemNew = new JMenuItem("New");
		mItemNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFunc();
			}
		});
		mnNewMenu.add(mItemNew);
		
		JMenuItem mItemOpen = new JMenuItem("Open");
		mItemOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFunc();
			}
		});
		mnNewMenu.add(mItemOpen);
		
		JMenuItem mItemSave = new JMenuItem("Save");
		mItemSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFunc();
			}
		});
		mnNewMenu.add(mItemSave);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mItemExit = new JMenuItem("Exlit");
		mItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitFunc();
			}
		});
		mnNewMenu.add(mItemExit);
		
		JMenu mnNewMenu_1 = new JMenu("Options");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mitemCopy = new JMenuItem("Color");
		mitemCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorFunc();
			}			
		});
		mnNewMenu_1.add(mitemCopy);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Font");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fontFunc();
			}			
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_3 = new JMenu("Action");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Call Frame");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
//				JOptionPane.showMessageDialog(frame, "Call Frame", "Call Frame", JOptionPane.INFORMATION_MESSAGE);
				TextAreaEx myChat = new TextAreaEx("My Chat 호출하기");
				myChat.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("info");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "에디터 만들기\n2025.05.01\nprogram by 김기태", "정보", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		

		
		taEditor = new RSyntaxTextArea(20, 60);
		taEditor.setFont(new Font("D2Coding", Font.PLAIN, 16));
		taEditor.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		taEditor.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(taEditor);		
		
		frame.getContentPane().add(sp, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		sp.setColumnHeaderView(toolBar);
		
		JButton btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFunc();
			}
		});
		btnNew.setIcon(new ImageIcon("D:\\Github\\Java_WS\\Java_Classes\\images\\new.png"));
		toolBar.add(btnNew);
		
		JButton btnOpen = new JButton("");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFunc();
			}
		});
		btnOpen.setIcon(new ImageIcon("D:\\Github\\Java_WS\\Java_Classes\\images\\open.png"));
		toolBar.add(btnOpen);
		
		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFunc();
			}
		});
		btnSave.setIcon(new ImageIcon("D:\\Github\\Java_WS\\Java_Classes\\images\\save.png"));
		toolBar.add(btnSave);
		
		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitFunc();
			}
		});
		btnExit.setIcon(new ImageIcon(MyTextEditor2.class.getResource("/part2/images/exit.png")));
		toolBar.add(btnExit);
	}
	
	private void saveFunc() {
		JFileChooser fc = new JFileChooser(); // 파일 선택 대화상자 생성
		
		fc.showSaveDialog(frame);	// 저장 대화상자 호출
		
		File out = fc.getSelectedFile();	// 선택된 파일
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(out));
			String str = taEditor.getText();	// JTextArea의 내용 가져오기
			str = str.replace("\n", System.getProperty("line.separator"));	// 줄바꿈 문자 변환
			bw.write(str);	// 파일에 내용 쓰기
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) 
					bw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	private void openFunc() {
		JFileChooser fc = new JFileChooser();
		
		File currentDir = new File(".");
		fc.setCurrentDirectory(currentDir);	// 현재 디렉토리 설정
		
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Java", "java"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("TEXT", "txt"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
		fc.setAcceptAllFileFilterUsed(true);
		
		fc.showOpenDialog(frame);
		
		File in = fc.getSelectedFile();
		BufferedReader br = null;
		String line = null;
		
		try {
			br = new BufferedReader(new FileReader(in));
			while ((line = br.readLine()) != null) {
				taEditor.append(line + "\n");
			}
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("파일을 읽는 중 오류가 발생했습니다.");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("알 수 없는 오류가 발생했습니다.");
			e.printStackTrace();
		} finally {
			try {
				if (br != null) 
					br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	private void exitFunc() {
		int result = JOptionPane.showConfirmDialog(frame, "정말 종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			System.exit(0);
		} 
	}
	
	private void fontFunc() {
		
		Font selectedFont = JFontChooser.showDialog(frame, taEditor.getFont());
		if (selectedFont != null) {
			taEditor.setFont(selectedFont);
		}		
	}
	
	private void colorFunc() {
		Color selectedColor = JColorChooser.showDialog(frame, "색상 선택", taEditor.getForeground());
		if (selectedColor != null) {
			taEditor.setForeground(selectedColor);
		}
	}
	
	private void newFunc() {
		int result = JOptionPane.showConfirmDialog(frame, "정말 새로 시작하시겠습니까?", "새로 시작 확인", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			taEditor.setText("");
		}
	}
}
