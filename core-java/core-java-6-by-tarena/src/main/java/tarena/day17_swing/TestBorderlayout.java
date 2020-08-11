package tarena.day17_swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestBorderlayout {
	public static void main(String[] args) {
		JFrame f = new JFrame("测试BorderLayout");
		BorderLayout layout = new BorderLayout();
		f.setLayout(layout);
		JButton b1 = new JButton("北丐洪七公");
		JButton b2 = new JButton("南帝段智兴");
		JButton b3 = new JButton("西毒欧阳锋");
		JButton b4 = new JButton("东邪黄药师");
		JButton b5 = new JButton("中神通王重阳");
		f.add(b1, BorderLayout.NORTH);
		f.add(b2, BorderLayout.SOUTH);
		f.add(b3, "West");
		f.add(b4, BorderLayout.EAST);
		f.add(b5, BorderLayout.CENTER);
		f.setSize(400, 300);
		f.setVisible(true);
	}
}
