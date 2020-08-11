package tarena.day22_io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjectStream1 {
	public static void main(String[] args) throws Exception {
		Student s1 = new Student("张三", 20);
		Student s2 = new Student("李四", 21);
		FileOutputStream fos = new FileOutputStream("student.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.writeObject(s2);
		oos.close();
		// student.dat中保着多个对象，要求全部读出，
		// 并调用它的show();
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
		/*
		 * while((stu = (Student)ois.readObject())!=null){ stu.show(); }
		 */
		ois.close();
	}
}
