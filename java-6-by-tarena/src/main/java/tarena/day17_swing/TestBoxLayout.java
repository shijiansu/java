package tarena.day17_swing;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TestBoxLayout {
	public static void main(String[] args) {
		JFrame f = new JFrame("测试BoxLayout");
		// 传参数时不能直接传JFrame,只能传JFrame.getContentPane()
		BoxLayout layout 
			= new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS);
		f.setLayout(layout);
		for(int i=0; i<10; i++){
			JButton b = new JButton("按钮"+i);
			f/*.getContentPane()*/.add(b);
		}
		f.setSize(400, 300);
		f.setVisible(true);
	}
}
