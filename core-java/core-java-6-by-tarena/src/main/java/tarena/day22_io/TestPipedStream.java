package tarena.day22_io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestPipedStream {
	public static void main(String[] args) throws Exception {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.getPos().connect(t2.getPis());
		t1.start();
		t2.start();
	}
}

class Thread1 extends Thread {
	private PipedOutputStream pos = new PipedOutputStream();

	public PipedOutputStream getPos() {
		return pos;
	}

	public void run() {
		DataOutputStream dos = new DataOutputStream(pos);
		for (int i = 0; i < 100; i++) {
			try {
				dos.writeInt(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class Thread2 extends Thread {
	private PipedInputStream pis = new PipedInputStream();

	public PipedInputStream getPis() {
		return pis;
	}

	public void run() {
		DataInputStream dis = new DataInputStream(pis);
		for (int i = 0; i < 100; i++) {
			try {
				System.out.println(dis.readInt());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
