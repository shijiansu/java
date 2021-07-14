package tarena.day21_io;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class TestJTree {
	public static void main(String[] args) {
		JFrame f = new JFrame("我的文件浏览器");
		FileTreeModel ftm = new FileTreeModel("E:\\");
		JTree tree = new JTree(ftm);
		JScrollPane scroll = new JScrollPane(tree);
		f.add(scroll);
		f.setSize(400, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		// ==================================
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				JTree tree = (JTree) e.getSource();
				FileNode fn = (FileNode) tree.getLastSelectedPathComponent();
				File file = fn.getFile();
				int i = JOptionPane.showConfirmDialog(null,
						"真的要删除文件：" + file.getName() + "吗？");
				if (i == JOptionPane.YES_OPTION) {
					file.delete();
				}
			}
		});
	}
}

class FileNode {
	private File file;

	public FileNode(String path) {
		file = new File(path);
	}

	public String toString() {
		return file.getName();
	}

	public File getFile() {
		return file;
	}

	public FileNode getChild(int index) {
		File[] fs = file.listFiles();
		if (fs != null) {
			return new FileNode(fs[index].getAbsolutePath());
		}
		return null;
	}

	public int getIndex(FileNode fn) {
		File[] fs = file.listFiles();
		for (int i = 0; i < fs.length; i++) {
			if (fs[i].getName().equals(fn.file.getName())) {
				return i;
			}
		}
		return -1;
	}

	public int getCount() {
		File[] ss = file.listFiles();
		if (ss != null) {
			return ss.length;
		}
		return 0;
	}
}

class FileTreeModel implements TreeModel {
	private String startPath;

	public FileTreeModel(String startPath) {
		this.startPath = startPath;
	}

	public Object getChild(Object parent, int index) {
		FileNode fn = (FileNode) parent;
		return fn.getChild(index);
	}

	public int getChildCount(Object parent) {
		FileNode fn = (FileNode) parent;
		return fn.getCount();
	}

	public int getIndexOfChild(Object parent, Object child) {
		FileNode pfn = (FileNode) parent;
		FileNode cfn = (FileNode) child;
		return pfn.getIndex(cfn);
	}

	public Object getRoot() {
		return new FileNode(startPath);
	}

	public boolean isLeaf(Object node) {
		FileNode fn = (FileNode) node;
		return fn.getCount() == 0;
	}

	public void removeTreeModelListener(TreeModelListener l) {
	}

	public void valueForPathChanged(TreePath path, Object newValue) {
	}

	public void addTreeModelListener(TreeModelListener l) {
	}

}
