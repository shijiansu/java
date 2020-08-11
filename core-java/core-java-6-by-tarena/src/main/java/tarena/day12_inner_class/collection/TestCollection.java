package tarena.day12_inner_class.collection;

import java.util.ArrayList;
import java.util.Iterator;

import tarena.day12_inner_class.Student;

public class TestCollection {
	public static void main(String[] args) {
		Student s1 = new Student("张三", 19);
		Student s2 = new Student("李四", 20);
		Student s3 = new Student("王二麻子", 21);
		ArrayList<Object> al = new ArrayList<Object>();
		al.add(s1);
		al.add(s2);
		al.add(s3);
		s1.setAge(25);
		Student s = (Student)al.get(0);
		System.out.println(s);
		al.add("abc");
		al.add(new Object());
		Iterator<Object> it = al.iterator();
		while(it.hasNext()){
			Object o = it.next();
			Student stu = (Student)o;//ClassCastException
			System.out.println(stu.getName());
		}
		
	}
}
