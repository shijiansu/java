package tarena.day17_swing;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class NotePad {
	private JFrame frame = new JFrame("记事本");
	private JMenuBar menuBar = new JMenuBar();
	private JMenu file = new JMenu("文件");
	private JMenu edit = new JMenu("编辑");
	private JMenu help = new JMenu("帮助");
	private JMenuItem newFile = new JMenuItem("新建...");
	private JMenuItem openFile = new JMenuItem("打开...");
	private JMenuItem closeFile = new JMenuItem("关闭");
	private JMenuItem exit = new JMenuItem("退出");
	private JMenuItem copy = new JMenuItem("拷贝");
	private JMenuItem cut = new JMenuItem("剪贴");
	private JMenuItem paste = new JMenuItem("粘贴");
	private JMenuItem about = new JMenuItem("关于本程序...");
	public NotePad() {
		file.add(newFile);
		file.add(openFile);
		file.add(closeFile);
		file.add(exit);
		edit.add(copy);
		edit.add(cut);
		edit.add(paste);
		help.add(about);
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
		frame.setJMenuBar(menuBar);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new NotePad();
	}
}
