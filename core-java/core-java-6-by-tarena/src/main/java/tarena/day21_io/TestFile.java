package tarena.day21_io;

import java.io.File;

public class TestFile {
	public static void main(String[] args) throws Exception {
		File file = new File("1.txt");
		file.createNewFile();
		// file.delete();
		File dir = new File("dir1/dir2");
		// dir.mkdir();
		// dir.delete();
		// dir.mkdirs();
		// dir.delete();
		File dir1 = new File("dir1");
		// dir1.delete();
		// file.deleteOnExit();
		// Thread.sleep(5000);
		System.out.println(file.exists());
		System.out.println(dir1.exists());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getCanonicalPath());
		System.out.println(dir.getParent());
		File dirParent = dir.getParentFile();
		System.out.println(dirParent.getAbsolutePath());
		System.out.println(dir.getPath());
		System.out.println(file.list());
	}
}
