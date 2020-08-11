package tarena.day18_swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestMouseEvent {
	private JLabel label = new JLabel("开始");
	private JPanel panel = new JPanel();
	private JTextField text = new JTextField();
	private class MyMouseListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			label.setText("鼠标被点了一下");
		}
		public void mouseEntered(MouseEvent e) {
			label.setText("鼠标进来了");			
		}
		public void mouseExited(MouseEvent e) {
			label.setText("鼠标走啦！");
		}
		public void mousePressed(MouseEvent e) {
			label.setText("鼠标被按下");
		}
		public void mouseReleased(MouseEvent e) {
			label.setText("鼠标被释放");
		}	
	}
	private class OtherMouseListener implements MouseMotionListener{
		public void mouseDragged(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			text.setText("鼠标的位置：X="+x+", Y="+y);
		}
		public void mouseMoved(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			text.setText("鼠标移动位置：X="+x+", Y="+y);
		}
	}
	public TestMouseEvent() {
		JFrame frame = new JFrame("测试鼠标事件");
		Font font = new Font(null, Font.BOLD+Font.ITALIC, 24);
		label.setFont(font);
		text.setFont(font);
		panel.setBackground(Color.GREEN);
		frame.add(label, "North");
		frame.add(panel);
		frame.add(text, "South");
		
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		MouseListener mouseListener = new MyMouseListener();
		panel.addMouseListener(mouseListener);
		MouseMotionListener mouseMotionListener = 
			new OtherMouseListener();
		panel.addMouseMotionListener(mouseMotionListener);
	}
	public static void main(String[] args) {
		new TestMouseEvent();
	}
}
