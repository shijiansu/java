package tarena.day21_io;

import java.io.File;
import java.io.FileFilter;

public class TestFileList {
	public static void main(String[] args) {
		File file = new File("D:\\");
		String[] ss = file.list();
		for (String s : ss) {
			System.out.println(s);
		}
		System.out.println("=======================");
		File[] fs = file.listFiles();
		for (File f : fs) {
			if (f.isDirectory()) {
				System.out.print("目录:");
			} else {
				System.out.print("文件:");
			}
			System.out.println(f.getAbsolutePath());
		}
		System.out.println("=========================");
		File[] fs1 = file.listFiles(new FileFilter() {
			public boolean accept(File pathname) {
				if (pathname.isDirectory()) {
					return true;
				}
				return false;
			}
		});
		for (File f : fs1) {
			if (f.isDirectory()) {
				System.out.print("目录:");
			} else {
				System.out.print("文件:");
			}
			System.out.println(f.getAbsolutePath());
		}
	}
}
