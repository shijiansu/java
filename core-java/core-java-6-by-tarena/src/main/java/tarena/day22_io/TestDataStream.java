package tarena.day22_io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestDataStream {
    @SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		int x = 1000;
		FileOutputStream fos = new FileOutputStream("1.txt");
		/*
		 * byte[] bs = new byte[4]; bs[3] = (byte) (x&0xFF); x >>= 8; bs[2] =
		 * (byte) (x&0xFF); x >>= 8; bs[1] = (byte) (x&0xFF); x >>= 8; bs[0] =
		 * (byte) (x&0xFF); for(int i=0; i<bs.length; i++){
		 * System.out.println(bs[i]); } fos.write(bs);
		 */
		byte b = 10;
		short s = 20;
		int i = 30;
		long l = 40;
		float f = 3.14f;
		double d = 4.13;
		boolean bool = true;
		char c = '中';
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeByte(b);
		dos.writeShort(s);
		dos.writeInt(i);
		dos.writeLong(l);
		dos.writeFloat(f);
		dos.writeDouble(d);
		dos.writeBoolean(bool);
		dos.writeChar(c);
		dos.writeUTF("我是字符串");
		dos.close();

		FileInputStream fis = new FileInputStream("1.txt");
		DataInputStream dis = new DataInputStream(fis);
		System.out.println(dis.readByte());
		System.out.println(dis.readShort());
		System.out.println(dis.readInt());
		System.out.println(dis.readLong());
		System.out.println(dis.readFloat());
		System.out.println(dis.readDouble());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readChar());
		System.out.println(dis.readUTF());
		dis.close();
	}
}
