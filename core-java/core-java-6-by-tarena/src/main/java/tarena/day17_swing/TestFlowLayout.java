package tarena.day17_swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestFlowLayout {
	public static void main(String[] args) {
		JFrame f = new JFrame("测试FlowLayout");
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT, 5, 5);
		f.setLayout(layout);
		for(int i=0; i<10; i++){
			JButton b = new JButton("按钮"+i);
			f.add(b);
		}
		f.setSize(400, 300);
		f.setLocation(300,200);
		f.setVisible(true);
	}
}
