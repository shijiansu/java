package tarena.day21_io;

import java.io.File;
import java.io.FileFilter;

public class PrintJavaFile {
	private static class JavaFileFilter implements FileFilter {
		public boolean accept(File pathname) {
			if (pathname.isDirectory() || pathname.getName().endsWith(".java")) {
				return true;
			}
			return false;
		}
	}

	public static void print(File file) {
		File[] fs = file.listFiles(new JavaFileFilter());
		for (File f : fs) {
			if (f.isFile()) {
				System.out.println(f.getAbsolutePath());
			} else {
				print(f);// 递归调用
			}
		}
	}

	public static void main(String[] args) {
		print(new File("E:\\"));
	}
}
