package tarena.day17_swing;

import javax.swing.JOptionPane;

public class TestJOptionPane {
	public static void main(String[] args) {
		int result = JOptionPane.showConfirmDialog(null, "你确定吗？");
		if(result==JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(null, "用户选择了YES");
		}else if(result==JOptionPane.NO_OPTION){
			System.out.println("用户选择了NO");
			String userInput = JOptionPane.showInputDialog("请输入一个值：");
			JOptionPane.showMessageDialog(null, "用户输入的值是："+userInput);
		}else{
			System.out.println("用户取消了选择");
		}
	}
}
