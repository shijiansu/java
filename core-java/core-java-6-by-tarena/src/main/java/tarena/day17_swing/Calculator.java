package tarena.day17_swing;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
	private JTextField text = new JTextField();
	private JFrame frame = new JFrame("计算器");
	private JPanel buttonPanel = new JPanel();
	public Calculator() {
		Font font = new Font("宋体",Font.BOLD+Font.ITALIC, 24);
		text.setFont(font);
		text.setHorizontalAlignment(JTextField.RIGHT);
		text.setEditable(false);
		frame.add(text, "North");
		frame.add(buttonPanel);
		String str = "12+34-56*78/90=";
		GridLayout layout = new GridLayout(5,3);
		buttonPanel.setLayout(layout);
		for(int i=0; i<str.length(); i++){
			JButton button = new JButton(str.charAt(i)+"");
			buttonPanel.add(button);
		}
		frame.setSize(300,240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new Calculator();
	}
	
}
