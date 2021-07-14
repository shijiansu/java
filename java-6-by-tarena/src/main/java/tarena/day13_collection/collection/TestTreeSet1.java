package tarena.day13_collection.collection;

import java.util.Iterator;
import java.util.TreeSet;

import tarena.day13_collection.compare.Student;

public class TestTreeSet1 {
	public static void main(String[] args) {
		Student s1 = new Student("陈才秀", 19);
		Student s2 = new Student("宋婕", 18);
		Student s3 = new Student("郭镫鸿", 20);
		Student s4 = new Student("宋小婕", 18);
	/*	Object o = s1;
		Comparable c = (Comparable)o;
		c.compareTo(o)*/
		TreeSet<Student> ts = new TreeSet<Student>();
		ts.add(s1);
		ts.add(s2);
		ts.add(s3);
		ts.add(s4);
		for (Iterator<Student> it = ts.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
}
