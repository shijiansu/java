package tarena.day22_io;

import java.io.FileOutputStream;

public class TestFileOutputStream {
	public static void main(String[] args) throws Exception {
		// String str = "床前明月光，我是郭德刚";
		String str = "你是我是谁？我是我是谁";
		FileOutputStream fos = new FileOutputStream("1.txt", true);
		fos.write(str.getBytes());
		long l = 1234567890L;
		fos.write((l + "").getBytes());
		fos.close();
	}
}
