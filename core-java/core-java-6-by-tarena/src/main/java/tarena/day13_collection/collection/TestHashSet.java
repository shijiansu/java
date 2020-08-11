package tarena.day13_collection.collection;

import java.util.HashSet;
import java.util.Iterator;

import tarena.day13_collection.compare.Student;

public class TestHashSet {
	public static void print(HashSet<Student> hs){
		Iterator<Student> it = hs.iterator();
		while(it.hasNext()){
			Object o = it.next();
			Student s = (Student)o;
			System.out.println(s);
		}
	}
	public static void main(String[] args) {
		Student s1 = new Student("陈才秀", 19);
		Student s2 = new Student("宋婕", 18);
		Student s3 = new Student("郭镫鸿", 20);
		Student s4 = new Student("宋小婕", 18);
		HashSet<Student> hs = new HashSet<Student>();
		hs.add(s1);
		hs.add(s2);
		hs.add(s3);
		hs.add(s4);
		print(hs);
		
		
	}
}
