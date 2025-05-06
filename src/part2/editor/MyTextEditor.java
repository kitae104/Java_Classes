package part2.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class MyTextEditor {

	private JFrame frame;
	private JTextArea taEditor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyTextEditor window = new MyTextEditor();
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
	public MyTextEditor() {
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
		mnNewMenu.add(mItemOpen);
		
		JMenuItem mItemSave = new JMenuItem("Save");
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
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("info");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "에디터 만들기\n2025.05.01\nprogram by 김기태", "정보", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		taEditor = new JTextArea();
		taEditor.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollPane.setViewportView(taEditor);
		
		JToolBar toolBar = new JToolBar();
		scrollPane.setColumnHeaderView(toolBar);
		
		JButton btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFunc();
			}
		});
		btnNew.setIcon(new ImageIcon(MyTextEditor.class.getResource("/part2/images/new.png")));
		toolBar.add(btnNew);
		
		JButton btnOpen = new JButton("");
		btnOpen.setIcon(new ImageIcon("D:\\Github\\Java_WS\\Java_Classes\\images\\open.png"));
		toolBar.add(btnOpen);
		
		JButton btnSave = new JButton("");
		btnSave.setIcon(new ImageIcon("D:\\Github\\Java_WS\\Java_Classes\\images\\save.png"));
		toolBar.add(btnSave);
		
		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitFunc();
			}
		});
		btnExit.setIcon(new ImageIcon("D:\\Github\\Java_WS\\Java_Classes\\images\\exit.png"));
		toolBar.add(btnExit);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(MyTextEditor.class.getResource("/part2/images/run.png")));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(MyTextEditor.class.getResource("/part2/images/compile.png")));
		toolBar.add(btnNewButton_1);
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
