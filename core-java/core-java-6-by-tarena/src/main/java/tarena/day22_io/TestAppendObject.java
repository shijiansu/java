package tarena.day22_io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestAppendObject {
	public static void main(String[] args) throws Exception {
		Student s = new Student("新来的", 30);
		/*
		 * FileOutputStream fos = new FileOutputStream("student.dat", true);
		 * ObjectOutputStream oos = new ObjectOutputStream(fos);
		 * oos.writeObject(s); oos.close();
		 */
		ArrayList<Student> stus = new ArrayList<Student>();
		FileInputStream fis = new FileInputStream("student.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student stu = null;
		try {
			while (true) {
				stu = (Student) ois.readObject();
				stus.add(stu);
			}
		} catch (EOFException e) {
		}
		ois.close();
		FileOutputStream fos = new FileOutputStream("student.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for (Student ss : stus) {
			oos.writeObject(ss);
		}
		oos.writeObject(s);
		oos.close();
		FileInputStream fis1 = new FileInputStream("student.dat");
		ObjectInputStream ois1 = new ObjectInputStream(fis1);
		Student stu1 = null;
		try {
			while (true) {
				stu1 = (Student) ois1.readObject();
				stu1.show();
			}
		} catch (EOFException e) {
		}
		ois1.close();
	}
}
