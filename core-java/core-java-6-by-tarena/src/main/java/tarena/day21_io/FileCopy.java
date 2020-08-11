package tarena.day21_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: FileCopy sourceFileName targetFileName");
			return;
		}
		File f = new File(args[0]);
		if (!f.exists()) {
			System.out.println("文件不存在");
			return;
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(f);
			fos = new FileOutputStream(args[1]);
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = fis.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (Exception e) {
				}
			if (fos != null)
				try {
					fos.close();
				} catch (Exception e) {
				}
		}
	}
}
