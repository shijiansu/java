package tarena.day23_socket;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import tarena.day22_io.Student;

public class TestSendObject {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("10.3.1.38", 10222);
		OutputStream os = s.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		Student o = new Student("testing", 21);
		oos.writeObject(o);
		oos.close();
		s.close();
	}
}
