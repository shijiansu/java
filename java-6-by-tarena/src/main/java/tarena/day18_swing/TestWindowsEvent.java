package tarena.day18_swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestWindowsEvent {
	private JFrame frame = new JFrame("测试窗口事件");
	private class MyWindowListener extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "您确定要退出系统吗?");
			if(result==JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
	}
	/*
	private class MyWindowListener implements WindowListener{
		public void windowActivated(WindowEvent e) {
			System.out.println("窗口被激活！");
		}
		public void windowClosed(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "您确定要退出系统吗?");
			if(result==JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
		public void windowDeactivated(WindowEvent e) {
			System.out.println("窗口被钝化");
		}
		public void windowDeiconified(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowOpened(WindowEvent e) {}
	}
	*/
	public TestWindowsEvent() { 
		frame.setSize(400, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new MyWindowListener());
	}
	public static void main(String[] args) {
		new TestWindowsEvent();
	}
}
