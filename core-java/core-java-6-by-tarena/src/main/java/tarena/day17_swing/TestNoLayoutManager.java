package tarena.day17_swing;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestNoLayoutManager {
	public static void main(String[] args) {
		JFrame f = new JFrame("测试不使用布局管理器");
		f.setLayout(null);
		JButton b = new JButton("按钮");
		b.setSize(100,80);
		b.setLocation(150, 100);
		f.add(b);
		f.setSize(400, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
