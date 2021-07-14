package tarena.day22_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjectStream3 {
    public static void main(String[] args) throws Exception {
		Student s1 = new Student("张三", 20);
		Student s2 = new Student("李四", 21);
		Teacher t = new Teacher("王二");
		s1.setTeacher(t);
		s2.setTeacher(t);
		FileOutputStream fos = new FileOutputStream("student1.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		FileOutputStream fos1 = new FileOutputStream("student2.dat");
		ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
		oos.writeObject(s1);
		oos1.writeObject(s2);
		oos.close();
		oos1.close();
		FileInputStream fis = new FileInputStream("student1.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student ss1 = (Student) ois.readObject();

		FileInputStream fis1 = new FileInputStream("student2.dat");
		ObjectInputStream ois1 = new ObjectInputStream(fis1);
		Student ss2 = (Student) ois1.readObject();
		System.out.println(ss1.getTeacher() == ss2.getTeacher());
		ois.close();
		ois1.close();
	}
}
