package tarena.day18_swing;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TestJTable {
	public static void main(String[] args) {
		String[] columns = {"姓名","性别", "年龄"};
		String[][] values = {{"张三","男","20"},
							 {"李四","男","22"},
							 {"王五","男","30"},
							 {"赵六","女","20"}};
		JTable table = new JTable(values, columns);
		JFrame frame = new JFrame("测试JTable");
		table.setFont(new Font(null, Font.BOLD, 20));
		JScrollPane scroll = new JScrollPane(table);
		frame.add(scroll);
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Object o = table.getModel().getValueAt(1, 2);
		System.out.println(o);
	}
}
