package tarena.day17_swing;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

public class TestComponent {
	public static void main(String[] args) {
		JFrame f = new JFrame("测试组件");
		JButton b = new JButton("我是按钮",new ImageIcon("nextdown.jpg"));
		f.setLayout(new FlowLayout());
		f.add(b);
		JCheckBox checkBox1 = new JCheckBox("多选框", true);
		JCheckBox checkBox2 = new JCheckBox("多选框", true);
		JCheckBox checkBox3 = new JCheckBox("多选框", true);
		
		f.add(checkBox1);
		f.add(checkBox2);
		f.add(checkBox3);
		
		JRadioButton radioButton1 = new JRadioButton("单选按钮1");
		JRadioButton radioButton2 = new JRadioButton("单选按钮2");
		JRadioButton radioButton3 = new JRadioButton("单选按钮3");
		//JRadioButton一定要加入到ButtonGroup中才有效
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		buttonGroup.add(radioButton3);
		f.add(radioButton1);
		f.add(radioButton2);
		f.add(radioButton3);
		
		JLabel label = new JLabel("这是一个JLabel的文字");
		label.setFont(new Font(null,Font.BOLD, 20));
		f.add(label);
		
		JProgressBar progressBar = new JProgressBar();
		f.add(progressBar);
		
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(null);
		if(result == JFileChooser.APPROVE_OPTION){
			String filename = fileChooser.getSelectedFile().getName();
			JOptionPane.showMessageDialog(null, "用户选择了文件："+filename);
		}
		
		f.setSize(800, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		for(int i=0; i<=100; i++){
			progressBar.setValue(i);
			try{Thread.sleep(50);}catch(Exception e){}
		}
	}
}
