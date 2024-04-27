package swing.builder.app.editor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MyEditor2
{

	private JFrame frmMyeditorVer;
	private RSyntaxTextArea ta;

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
					MyEditor2 window = new MyEditor2();
					window.frmMyeditorVer.setLocationRelativeTo(null);
					window.frmMyeditorVer.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyEditor2()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmMyeditorVer = new JFrame();
		frmMyeditorVer.setTitle("MyEditor ver0.1");
		frmMyeditorVer.setBounds(100, 100, 1000, 800);
		frmMyeditorVer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JToolBar toolBar = new JToolBar();
		frmMyeditorVer.getContentPane().add(toolBar, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(MyEditor2.class.getResource("/swing/builder/img/new.png")));
		toolBar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				openFile();
			}

		});
		btnNewButton_1.setIcon(new ImageIcon(MyEditor2.class.getResource("/swing/builder/img/open.png")));
		toolBar.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				saveFile();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(MyEditor2.class.getResource("/swing/builder/img/save.png")));
		toolBar.add(btnNewButton_2);

		toolBar.addSeparator();

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(MyEditor2.class.getResource("/swing/builder/img/exit.png")));
		toolBar.add(btnNewButton_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmMyeditorVer.getContentPane().add(scrollPane, BorderLayout.CENTER);

		// 새로운 RSyntaxTextArea
		ta = new RSyntaxTextArea(20, 60);
		ta.setFont(new Font("Monospaced", Font.PLAIN, 16));
		ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		ta.setCodeFoldingEnabled(true);
		RTextScrollPane sp = new RTextScrollPane(ta);
		scrollPane.setViewportView(ta);

		Insets margin = new Insets(0,10, 0, 10);
		ta.setBorder(new EmptyBorder(margin));
		
		JMenuBar menuBar = new JMenuBar();
		frmMyeditorVer.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenuItem mnitNew = new JMenuItem("New");
		mnNewMenu.add(mnitNew);

		JMenuItem mnitOpen = new JMenuItem("Open");
		mnitOpen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				openFile();
			}
		});
		mnNewMenu.add(mnitOpen);

		JMenuItem mnitSave = new JMenuItem("Save");
		mnitSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				saveFile();
			}

		});
		mnNewMenu.add(mnitSave);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);

		JMenuItem mnitExit = new JMenuItem("Exit");
		mnNewMenu.add(mnitExit);

		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_2 = new JMenu("Info");
		menuBar.add(mnNewMenu_2);

		JMenuItem mnitProgInfo = new JMenuItem("program info");
		mnNewMenu_2.add(mnitProgInfo);
	}

	private void openFile()
	{
		JFileChooser fc = new JFileChooser();
		File currentDirectory = new File(".");
		fc.setCurrentDirectory(currentDirectory);

		fc.addChoosableFileFilter(new FileNameExtensionFilter("Java", "java"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("TEXT", "txt"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
		fc.setAcceptAllFileFilterUsed(true);

		fc.showOpenDialog(null);

		File in = fc.getSelectedFile();
		BufferedReader br = null;
		String line = null;

		try
		{
			br = new BufferedReader(new FileReader(in));
			while ((line = br.readLine()) != null)
			{
				ta.append(line + "\n");
			}
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		} finally
		{
			try
			{
				br.close();
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
	}

	private void saveFile()
	{
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("TEXT", "txt"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));

		fc.showSaveDialog(null);

		File out = fc.getSelectedFile();
		BufferedWriter bw = null;

		try
		{
			bw = new BufferedWriter(new FileWriter(out));
			String str = ta.getText();
			str = str.replace("\n", System.getProperty("line.separator"));
			bw.write(str);

		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		} finally
		{
			try
			{
				bw.close();
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
	}
}
