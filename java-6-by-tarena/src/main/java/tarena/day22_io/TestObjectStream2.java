package tarena.day22_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjectStream2 {
	public static void main(String[] args) throws Exception {
		Student s1 = new Student("张三", 20);
		Student s2 = new Student("李四", 21);
		Teacher t = new Teacher("王二");
		s1.setTeacher(t);
		s2.setTeacher(t);
		FileOutputStream fos = new FileOutputStream("student.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.writeObject(s2);
		oos.close();
		FileInputStream fis = new FileInputStream("student.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student ss1 = (Student) ois.readObject();
		Student ss2 = (Student) ois.readObject();
		System.out.println(ss1.getTeacher() == ss2.getTeacher());
		ois.close();
	}
}
