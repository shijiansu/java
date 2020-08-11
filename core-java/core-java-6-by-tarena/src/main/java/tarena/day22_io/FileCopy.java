package tarena.day22_io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
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
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(f);
			fos = new FileOutputStream(args[1]);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = bis.read(buf)) != -1) {
				bos.write(buf, 0, len);
			}
			bos.flush();
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
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
