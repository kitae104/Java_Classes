package part2.editor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class JFontChooser extends JDialog {
    private JComboBox<String> fontBox;
    private JComboBox<Integer> sizeBox;
    private JCheckBox boldBox, italicBox;
    private JLabel previewLabel;
    private Font selectedFont;

    public JFontChooser(Frame parent, Font initialFont) {
        super(parent, "글꼴 선택", true);
        setLayout(new BorderLayout());

        // 폰트 목록 가져오기
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();
        fontBox = new JComboBox<>(fontNames);

        sizeBox = new JComboBox<>(new Integer[]{8, 10, 12, 14, 16, 18, 20, 24, 28, 32, 36, 40});
        boldBox = new JCheckBox("굵게");
        italicBox = new JCheckBox("기울임");

        // 미리보기 라벨
        previewLabel = new JLabel("가나다 ABCD Preview");
        previewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        previewLabel.setPreferredSize(new Dimension(400, 100));

        // 초기값 설정
        if (initialFont != null) {
            fontBox.setSelectedItem(initialFont.getFamily());
            sizeBox.setSelectedItem(initialFont.getSize());
            boldBox.setSelected(initialFont.isBold());
            italicBox.setSelected(initialFont.isItalic());
            previewLabel.setFont(initialFont);
        }

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("글꼴:"));
        topPanel.add(fontBox);
        topPanel.add(new JLabel("크기:"));
        topPanel.add(sizeBox);
        topPanel.add(boldBox);
        topPanel.add(italicBox);
        add(topPanel, BorderLayout.NORTH);

        add(previewLabel, BorderLayout.CENTER);

        JButton okButton = new JButton("확인");
        JButton cancelButton = new JButton("취소");
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(okButton);
        bottomPanel.add(cancelButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // 이벤트 연결
        ActionListener updatePreviewListener = e -> updatePreview();
        fontBox.addActionListener(updatePreviewListener);
        sizeBox.addActionListener(updatePreviewListener);
        boldBox.addActionListener(updatePreviewListener);
        italicBox.addActionListener(updatePreviewListener);

        okButton.addActionListener(e -> {
            selectedFont = previewLabel.getFont();
            dispose();
        });

        cancelButton.addActionListener(e -> {
            selectedFont = null;
            dispose();
        });

        pack();
        setLocationRelativeTo(parent);
    }

    private void updatePreview() {
        String fontName = (String) fontBox.getSelectedItem();
        int fontSize = (Integer) sizeBox.getSelectedItem();
        int style = Font.PLAIN;
        if (boldBox.isSelected()) style |= Font.BOLD;
        if (italicBox.isSelected()) style |= Font.ITALIC;

        Font previewFont = new Font(fontName, style, fontSize);
        previewLabel.setFont(previewFont);
    }

    public Font getSelectedFont() {
        return selectedFont;
    }

    // 정적 메서드로 대화상자 띄우기
    public static Font showDialog(Component parent, Font currentFont) {
        Frame frame = JOptionPane.getFrameForComponent(parent);
        JFontChooser chooser = new JFontChooser(frame, currentFont);
        chooser.setVisible(true);
        return chooser.getSelectedFont();
    }
}
