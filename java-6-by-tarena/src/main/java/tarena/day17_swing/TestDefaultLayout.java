package tarena.day17_swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestDefaultLayout {
	public static void main(String[] args) {
		JFrame f = new JFrame("测试默认布局管理器");//BorderLayout
		JButton b = new JButton("确定");
		f.add(b, BorderLayout.NORTH);
		JPanel panel = new JPanel();//FlowLayout
		//panel.setLayout(new BorderLayout());
		JButton b1 = new JButton("面板中的按钮");
		panel.add(b1);
		f.add(panel);
		
		
		
		f.setSize(400, 300);
		f.setVisible(true);
	}
}
