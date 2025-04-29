package part2.components;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListFrame {

	private JFrame frmList;
	private JList lstName;
	private JTextField tfName;
	private DefaultListModel<String> listModel;
	private DefaultComboBoxModel<String> comboModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListFrame window = new ListFrame();
					window.frmList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmList = new JFrame();
		frmList.setTitle("LIST 연습하기");
		frmList.setBounds(100, 100, 411, 329);
		frmList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmList.getContentPane().setLayout(null);

		JButton btnAdd = new JButton("추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				if (name.equals("")) {
					JOptionPane.showMessageDialog(frmList, "이름을 입력하세요");
					return;
				}
				listModel.addElement(name);
				tfName.setText("");
			}
		});
		btnAdd.setBounds(253, 21, 132, 23);
		frmList.getContentPane().add(btnAdd);

		JButton btnToCombo = new JButton(">>");
		btnToCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = lstName.getSelectedIndex();
				if (index == -1) {
					JOptionPane.showMessageDialog(frmList, "이름을 선택하세요");
					return;
				}
				String name = listModel.get(index);
				comboModel.addElement(name);
				listModel.remove(index);
			}
		});
		btnToCombo.setBounds(176, 106, 65, 23);
		frmList.getContentPane().add(btnToCombo);

		listModel = new DefaultListModel<String>();

		lstName = new JList();
		lstName.setModel(listModel);
		lstName.setBounds(12, 53, 147, 230);
		frmList.getContentPane().add(lstName);

		tfName = new JTextField();
		tfName.setBounds(12, 22, 229, 21);
		frmList.getContentPane().add(tfName);
		tfName.setColumns(10);

		comboModel = new DefaultComboBoxModel<String>();
		JComboBox cbName = new JComboBox();
		cbName.setModel(comboModel);
		cbName.setBounds(269, 54, 119, 23);
		frmList.getContentPane().add(cbName);
	}
}
