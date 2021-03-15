package swing.qna;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentPaneFrame extends JFrame {
	
	public ContentPaneFrame(String title, int width, int hight) {
		setTitle(title);
		setSize(width, hight);
//		setLocation(800, 300);
		setLocationRelativeTo(this);				// 화면 가운데에 표시
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);	// 이렇게도 되는구나
		
		// 레이아웃 설정
		setLayout(new FlowLayout());				// flow는 흐름대로, 
//		setLayout(new BorderLayout());				// Border는 동서남북+센터
		
		Container c = getContentPane();				// 컨테이너 생성.
		c.setBackground(Color.darkGray);

		JButton b1 = new JButton("OK");				// 버튼은 컴포넌트
		c.add(b1);									// 컨테이너에 붙은 버튼 요즘엔 쓰지 않는다.
		
		JButton b2 = new JButton("Cancel");
		add(b2);									// 프레임에 붙은 버튼
		
		JButton b3 = new JButton("Ignore");
		b3.setBackground(Color.RED);				// 왜 색이 적용 안되지? 맥이라서 그런가?
		add(b3);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// 초기화 할 때 아예 제목, 크기를 정해주자
		new ContentPaneFrame("ContentPane 프레임", 350, 150);
		
	}

}
