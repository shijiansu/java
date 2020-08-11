package tarena.day21_io;

import java.io.File;
import java.io.FileFilter;

public class TestListJavaFile {
	private static class JavaFileFilter implements FileFilter {
		public boolean accept(File pathname) {
			if (pathname.isFile() && pathname.getName().endsWith(".java")) {
				return true;
			}
			return false;
		}
	}

	// 打印某个目录下所有的.java文件
	public static void printJavaFile(String path) {
		File file = new File(path);
		if (!(file.exists() && file.isDirectory())) {
			System.out.println("必需是一个已经存在的目录。");
			return;
		}
		File[] fs = file.listFiles(new JavaFileFilter());
		for (File f : fs) {
			System.out.println(f.getAbsolutePath());
		}
	}

	public static void main(String[] args) {
		String path = "E:/sd0810/corejava/day08";
		printJavaFile(path);
	}
}
