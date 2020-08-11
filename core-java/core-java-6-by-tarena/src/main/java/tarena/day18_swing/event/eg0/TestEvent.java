package tarena.day18_swing.event.eg0;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestEvent {
	public static void main(String[] args) {
		JFrame f = new JFrame("测试事件");
		f.setLayout(new FlowLayout());
		JButton button = new JButton("我是按钮");//事件源
		ActionListener listener = 
			new ButtonActionListener();
		button.addActionListener(listener);
			
		f.add(button);
		f.setSize(400, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
//事件对象
/*class ActionEvent extends EventObject{
	public ActionEvent(Object source) {
		super(source);
	}
}*/

//监听接口
/*interface ActionListener extends EventListener{
	public void actionPerformed(ActionEvent event);
}*/

//监听者
class ButtonActionListener implements ActionListener{
	public void actionPerformed(ActionEvent event) {
		System.out.println("我被按了一下...");
	}
}


