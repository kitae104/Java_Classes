package project.javaeditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import swing.components.CheckBoxEx;

public class JavaEditor extends JFrame implements ActionListener {

	private JMenuBar mb;
	private JMenu menuFile, menuEdit, menuInfo;
	private JMenuItem menuItemNew, menuItemOpen, menuItemSave, menuItemExit;
	private JMenuItem menuItemInfo;
	
	private JToolBar toolBar;
	
	private JButton btnNew, btnOpen, btnSave, btnExit;
	private JButton btnOk;
	
//	private JTextArea ta;
	private RSyntaxTextArea textArea;
	
	private final int EXIT_SUCCESS = 0;	// 상수 
	
	private ImageIcon[] imgs = { 
			new ImageIcon("images/new.png"),
			new ImageIcon("images/open.png"),
			new ImageIcon("images/save.png"),
			new ImageIcon("images/compile.png"),
			new ImageIcon("images/run.png"),
			new ImageIcon("images/exit.png")
	};
		
	private CheckBoxEx chkEx;
	
	private JPanel panelBase;
	
	private JTextField tf;
	private JTree tree;
	private JTextArea ta;
	private JMenu menuRun;
	private JMenuItem menuItemCompile;
	private JMenuItem menuItemRun;
	private JButton btnCompile;
	private JButton btnRun;
	
	private String fileName = null;
	private Process process;
	private BufferedReader bufferedReader;
	private StringBuffer readBuffer;
	
	public JavaEditor(String title, int width, int height) {
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
		         
        // JTree 처리하기 
        tree = new JTree();
        
        String path = "C:\\Users\\김기태\\Documents\\A_SRC";
        File fileRoot = new File(path);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(fileRoot);
        DefaultTreeModel model = new DefaultTreeModel(root);

        File[] subItems = fileRoot.listFiles();
        for (File file : subItems) {
          root.add(new DefaultMutableTreeNode(file.getName()));
        }        
        tree.setModel(model);
		
        // 새로운 RSyntaxTextArea
		textArea = new RSyntaxTextArea(20, 60);
		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        
        ta = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        JSplitPane jsp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, scrollPane);
		jsp2.setDividerLocation(350);
        
		
        JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tree, jsp2);
		jsp.setDividerLocation(150);
        
		panelBase.add(jsp);
	}

	private void makeToolBar() {
		toolBar = new JToolBar("내 툴바");
		
		btnNew = new JButton(imgs[0]);
		btnNew.addActionListener(this);
		
		btnOpen = new JButton(imgs[1]);
		btnOpen.addActionListener(this);
		
		btnSave = new JButton(imgs[2]);
		btnSave.addActionListener(this);
		
		btnCompile = new JButton(imgs[3]);
		btnCompile.addActionListener(this);
		
		btnRun = new JButton(imgs[4]);
		btnRun.addActionListener(this);
		
		btnExit = new JButton(imgs[5]);
		btnExit.addActionListener(this);
		btnExit.setToolTipText("프로그램을 종료합니다.");
		
		toolBar.add(btnNew);
		toolBar.add(btnOpen);
		toolBar.add(btnSave);
		toolBar.addSeparator();
		toolBar.add(btnCompile);
		toolBar.add(btnRun);
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
				
		menuRun = new JMenu("실행");
		menuItemCompile = new JMenuItem("컴파일");
		menuItemCompile.addActionListener(this);
		
		menuItemRun = new JMenuItem("실행");
		menuItemRun.addActionListener(this);
				
		menuRun.add(menuItemCompile);
		menuRun.add(menuItemRun);
		
		menuInfo = new JMenu("정보");
		menuItemInfo = new JMenuItem("프로그램정보");
		menuItemInfo.addActionListener(this);
		
		menuInfo.add(menuItemInfo);
		
		mb.add(menuFile);
		mb.add(menuEdit);
		mb.add(menuRun);
		mb.add(menuInfo);		
	}

	public static void main(String[] args) {
		new JavaEditor("Java Editor", 1000, 600);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == menuItemExit || obj == btnExit) {	
			
			checkExit();
			
		} else if(obj == menuItemInfo) {
			// 기능 추가 필요 !!
			
		} else if(obj == btnOk) {
			
			String msg = JOptionPane.showInputDialog("숫자1?");
			int sum = Integer.parseInt(msg) + 10;
			tf.setText(sum + "");
			
		} else if(obj == btnNew || obj == menuItemNew) {
			
			textArea.setText("");
			
		} else if (obj == btnOpen || obj == menuItemOpen) {			
			
			fileOpen();
			
		} else if(obj == btnSave || obj == menuItemSave) {
			
			fileSave();
			
		} else if(obj == btnCompile || obj == menuItemCompile) {
			
			compileCode();
			
			
		} else if(obj == btnRun || obj == menuItemRun) {
			
			runCode();
			
		}
	}

	private void runCode()
	{
		if(fileName == null) {
			JOptionPane.showMessageDialog(this, "실행할 파일이 없습니다.");
			return;
		}
		
		ta.setText("");
		
		//String fName = fileName.replace(".java", "");
		
		String cmd = "cmd.exe /c java " + fileName;
		System.out.println(cmd);
		
		try
		{
			process = Runtime.getRuntime().exec(cmd);
			
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null; 
						
			while((line = bufferedReader.readLine()) != null) {
				ta.append(line + "\n");				
			}
			ta.append("실행 완료");
		} 
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}

	private void compileCode()
	{
		if(fileName == null) {
			JOptionPane.showMessageDialog(this, "컴파일할 파일이 없습니다.");
			return;
		}
		
		ta.setText("");
		
		String cmd = "cmd.exe /c javac " + fileName;
		System.out.println(cmd);
		
		try
		{
			process = Runtime.getRuntime().exec(cmd);
			
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;			
			
			while((line = bufferedReader.readLine()) != null) {
				ta.append(line + "\n");
			}
			
			ta.append("컴파일 완료!");
		} 
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}

	private void fileSave()
	{
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Java", "java"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("TEXT", "txt"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
		
		fc.showSaveDialog(null);
		
		File out = fc.getSelectedFile();
		
		fileName = out.getAbsolutePath();
		
		BufferedWriter bw = null;			

		try {				
			bw = new BufferedWriter(new FileWriter(out));	
			String str = textArea.getText();
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

	private void fileOpen()
	{
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Java", "java"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("TEXT", "txt"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
		//fc.setAcceptAllFileFilterUsed(false);
		
		fc.showOpenDialog(null);
		
		File in = fc.getSelectedFile();
		
		fileName = in.getAbsolutePath();
		
		BufferedReader br = null;
		String line = null;

		try {				
			br = new BufferedReader(new FileReader(in));				
			while((line = br.readLine()) != null) {
				textArea.append(line + "\n");
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
