package tarena.day22_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjectStream {
	public static void main(String[] args) throws Exception {
		Student s = new Student("杨松岩", 28);
		Teacher t = new Teacher("老师");
		s.setTeacher(t);
		FileOutputStream fos = new FileOutputStream("student.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.close();
		FileInputStream fis = new FileInputStream("student.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student s1 = (Student) ois.readObject();
		System.out.println(s);
		System.out.println(s1);
		s.show();
		s1.show();
		ois.close();
		System.out.println(s.getTeacher());
		System.out.println(s1.getTeacher());
	}
}
