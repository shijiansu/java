package tarena.day17_swing;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FirstFrame {
	public static void main(String[] args) {
		//1、选择一个容器
		JFrame f = new JFrame("这是我的第一个窗口");//窗体容器
		//2、选择布局管理器
		LayoutManager lm = new FlowLayout();
		//给容器设置布局管理器
		f.setLayout(lm);
		//3、添加组件
		JButton button = new JButton("确定");
		f.add(button);
		//4、添加事件
		//太麻烦，不写了....
		//5、显示出来
		f.setSize(400,300);
		f.setVisible(true);
		
	}
}
