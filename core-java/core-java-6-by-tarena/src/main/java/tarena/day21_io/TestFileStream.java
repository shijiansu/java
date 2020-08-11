package tarena.day21_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("1.txt");
			for (char c = 'A'; c <= 'Z'; c++) {
				fos.write(c);
			}
			fos.write('\n');
			byte[] bs = new byte[26];
			for (int i = 97; i <= 97 + 25; i++) {
				bs[i - 97] = (byte) i;
			}
			fos.write(bs);
			System.out.println("==================");
			fis = new FileInputStream("1.txt");
			byte[] buf = new byte[1024];
			int len = fis.read(buf);
			for (int i = 0; i < len; i++) {
				System.out.print((char) buf[i] + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (Exception e) {
				}
			if (fis != null)
				try {
					fis.close();
				} catch (Exception e) {
				}
		}
	}
}
