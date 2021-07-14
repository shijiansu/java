package tarena.day18_swing.event.eg1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestEvent1 {
	//static JLabel label = new JLabel("我是一个标签，改变我哦！");
	public static void main(String[] args) {
		JFrame f = new JFrame("测试事件");
		JButton button = new JButton("我是按钮");// 事件源
		JLabel label = new JLabel("我是一个标签，改变我哦！");
		Font font = new Font(null, Font.BOLD, 20);
		label.setFont(font);
		label.setForeground(Color.RED);
		JPanel panel = new JPanel();
		panel.add(button);
		f.add(panel, "North");
		f.add(label);
		//label.setText("这是改变过的内容");
		f.setSize(400, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		ActionListener listener = 
			new ChangeLabelActionListener(label);
		button.addActionListener(listener);
	}
}
class ChangeLabelActionListener implements ActionListener{
	private JLabel label;
	public ChangeLabelActionListener(JLabel label){
		this.label = label;
	}
	public void actionPerformed(ActionEvent e) {
		//System.out.println("把标签给我变了");
		label.setText("改了吧，小样！");
	}
}
