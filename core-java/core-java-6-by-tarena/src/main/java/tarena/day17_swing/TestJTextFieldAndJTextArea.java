package tarena.day17_swing;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestJTextFieldAndJTextArea {
	public static void main(String[] args) {
		JFrame f = new JFrame("测试文本框");
		JTextField textField = new JTextField(20);
		Font font = new Font(null, Font.BOLD, 18);
		textField.setFont(font);
		JTextArea textArea = new JTextArea(10, 20);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setFont(font);
		f.add(scrollPane, "Center");
		f.add(textField, "South");
		f.setSize(500, 460);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
