package swing.builder.app;

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
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import java.awt.Font;

public class MyEditor
{

	private JFrame frmMyeditorVer;

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
					MyEditor window = new MyEditor();
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
	public MyEditor()
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
		btnNewButton.setIcon(new ImageIcon(MyEditor.class.getResource("/swing/builder/img/new.png")));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(MyEditor.class.getResource("/swing/builder/img/open.png")));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(MyEditor.class.getResource("/swing/builder/img/save.png")));
		toolBar.add(btnNewButton_2);
				
		toolBar.addSeparator();
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(MyEditor.class.getResource("/swing/builder/img/exit.png")));
		toolBar.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmMyeditorVer.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JTextArea ta = new JTextArea();
		ta.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollPane.setViewportView(ta);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frmMyeditorVer.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mnitNew = new JMenuItem("New");
		mnNewMenu.add(mnitNew);
		
		JMenuItem mnitOpen = new JMenuItem("Open");
		mnNewMenu.add(mnitOpen);
		
		JMenuItem mnitSave = new JMenuItem("Save");
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

}
