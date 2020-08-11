package tarena.day18_swing;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JSpinner;

public class TestComponent {
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
		JFrame f = new JFrame("测试组件");
		f.setLayout(new FlowLayout());
		String[] ss = {"中国","美国"};
		JComboBox<?> comboBox = new JComboBox(ss);
		//comboBox.addItem("中国");
		//comboBox.addItem("美国");
		f.add(comboBox);
		
		String[] ss1 = {"法国","德国"};
		JList<?> list = new JList(ss1);
		list.setBackground(Color.GREEN);
		f.add(list);
		
		JSpinner spinner = new JSpinner();
		spinner.setValue(100);
		f.add(spinner);
		JSlider slider = new JSlider();
		f.add(slider);
		f.setSize(500, 450);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
