package tarena.day13_collection.compare;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TestComparator {
	public static void main(String[] args) {
		Student s1 = new Student("aaa", 20);
		Student s2 = new Student("bbb", 18);
		Student s3 = new Student("ccc", 22);
		TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Object>(){
			public int compare(Object o1, Object o2) {
				Student stu1 = (Student) o1;
				Student stu2 = (Student) o2;
				return stu1.getName().compareTo(stu2.getName());
			}
		});
		ts.add(s1);
		ts.add(s2);
		ts.add(s3);
		Iterator<Student> it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
