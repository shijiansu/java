package tarena.day12_inner_class.collection;

import java.util.HashSet;
import java.util.Iterator;

import tarena.day12_inner_class.Student;

public class TestHashSet1 {
	public static void main(String[] args) {
		Student s1 = new Student("张三", 19);
		Student s2 = new Student("李四", 20);
		Student s3 = new Student("王二麻子", 21);
		Student s4 = new Student("张三", 19);
		System.out.println(s1.equals(s4));
		HashSet<Student> hs = new HashSet<Student>();
		hs.add(s1);
		hs.add(s2);
		hs.add(s3);
		hs.add(s1);
		hs.add(s4);
		for(Iterator<Student> it = hs.iterator(); it.hasNext();) {
			Student stu = (Student) it.next();
			System.out.println(stu);
		}

	}
}
