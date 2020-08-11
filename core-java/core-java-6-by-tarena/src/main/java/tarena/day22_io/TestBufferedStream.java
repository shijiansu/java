package tarena.day22_io;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class TestBufferedStream {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("1.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		bos.write("我是过滤流".getBytes());

		bos.flush();
		dos.writeInt(100);
		bos.close();
	}
}
