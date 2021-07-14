package tarena.day22_io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjectStream4 {
	public static void main(String[] args) throws Exception {
		Student s = new Student("赵君", 20);
		FileOutputStream fos = new FileOutputStream("student.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		s.setAge(21);
		s.setName("赵2君");
		oos.writeObject(s.clone());
		FileInputStream fis = new FileInputStream("student.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student stu = null;
		try {
			while (true) {
				stu = (Student) ois.readObject();
				stu.show();
			}
		} catch (EOFException e) {
		}
		ois.close();
	}
}
