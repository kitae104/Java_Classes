package swing.qna.iks;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener{
	private JButton btnSave, btnFind, btnCancle, btnChange;
	private JTextField productText, priceText;
	private JTextArea textArea;
	private HashMap<String, String> hash = new HashMap<>();

	public MainFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		makeFrame();
		
		
		setVisible(true);
	}

	private void makeFrame() {
		setLayout(new FlowLayout());
		
		JLabel product = new JLabel("물품");
		add(product);
		
		productText = new JTextField(10);
		add(productText);
		
		JLabel price = new JLabel("가격");
		add(price);
		
		priceText = new JTextField(10);
		add(priceText);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		add(btnSave);
		
		btnFind = new JButton("찾기");
		btnFind.addActionListener(this);
		add(btnFind);
		
		btnCancle = new JButton("삭제");
		btnCancle.addActionListener(this);
		add(btnCancle);
		
		btnChange = new JButton("변경");
		btnChange.addActionListener(this);
		add(btnChange);
		
		textArea = new JTextArea(10, 25);
		textArea.setEditable(false);
		JScrollPane areaScroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(areaScroll);
		
		
	}

	public static void main(String[] args) {
		new MainFrame("내 프레임", 300, 300);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnSave) {
			hash.put(productText.getText(), priceText.getText());
			textArea.append("물건 : " + productText.getText() + ", " + "가격 : " + priceText.getText() + "\n");
			productText.setText("");
			priceText.setText("");
			saveFile();
		}
		
		else if(obj == btnFind) {
			priceText.setText(hash.get(productText.getText()));
		}
		
		else if(obj == btnCancle) {
			hash.remove(productText.getText());
		}
		
		else if(obj == btnChange) {
			hash.replace(productText.getText(), priceText.getText());
		}
		
	}

	private void saveFile() {
		String product = hash.get(productText.getText());
		String price = hash.get(priceText.getText());
		
		String filepath = "C:\\Users\\kyoun\\OneDrive\\Desktop\\database.txt";
		
		try {
			File file = new File(filepath);
			FileWriter fileWrite = new FileWriter(file, true);
			
			fileWrite.write(product);
			fileWrite.write(price);
			fileWrite.write("\n");
			
			fileWrite.flush();
			
			fileWrite.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
