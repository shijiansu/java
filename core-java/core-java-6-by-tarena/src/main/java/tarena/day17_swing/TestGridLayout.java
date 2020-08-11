package tarena.day17_swing;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGridLayout {
	public static void main(String[] args) {
		JFrame f = new JFrame("测试GridLayout");
		GridLayout layout = new GridLayout(4,3,10,10);
		f.setLayout(layout);
		for(int i=0; i<10; i++){
			JButton b = new JButton(i+"");
			f.add(b);
		}
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 300);
		f.setVisible(true);
	}
}
