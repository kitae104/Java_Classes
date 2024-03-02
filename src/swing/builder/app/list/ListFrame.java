package swing.builder.app.list;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListFrame
{

	private JFrame frmList;
	private JList list;

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
					ListFrame window = new ListFrame();
					window.frmList.setVisible(true);
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
	public ListFrame()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmList = new JFrame();
		frmList.setTitle("LIST 연습하기");
		frmList.setBounds(100, 100, 536, 361);
		frmList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmList.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(12, 10, 91, 23);
		frmList.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(115, 14, 50, 15);
		frmList.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Load Value");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 리스트에는 모델을 사용해야 함 
				DefaultListModel<String> model = new DefaultListModel<>();
				model.addElement("AAA");
				model.addElement("BBB");
				model.addElement("CCC");
				model.addElement("DDD");
				model.addElement("EEE");
				list.setModel(model);
			}
		});
		btnNewButton_1.setBounds(32, 132, 126, 23);
		frmList.getContentPane().add(btnNewButton_1);
		
		list = new JList();
		list.setBounds(198, 49, 294, 230);
		frmList.getContentPane().add(list);
	}
}
