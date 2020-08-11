package tarena.day22_io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf = new RandomAccessFile("passwd", "r");
		String str = null;
		while ((str = raf.readLine()) != null) {
			System.out.println(str);
		}
		raf.close();
		System.out.println("==========================");
		RandomAccessFile raf1 = new RandomAccessFile("passwd", "r");
		File file = new File("point");
		long pos = 0;
		if (file.exists()) {
			FileInputStream fis = new FileInputStream("point");
			DataInputStream dis = new DataInputStream(fis);
			pos = dis.readLong();
			raf1.seek(pos);
			dis.close();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(raf1.readLine());
		}
		pos = raf1.getFilePointer();
		FileOutputStream fos = new FileOutputStream("point");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeLong(pos);
		dos.close();
		raf1.close();
		
	}
}
