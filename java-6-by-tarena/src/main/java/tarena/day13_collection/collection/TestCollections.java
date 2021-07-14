package tarena.day13_collection.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import tarena.day13_collection.compare.Teacher;

public class TestCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("ccc");
		list.add("bbb");
		Collections.sort(list);
		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		Teacher t1 = new Teacher("才秀", 22);
		Teacher t2 = new Teacher("赵君", 28);
		Teacher t3 = new Teacher("郭", 30);
		List<Teacher> list1 = new ArrayList<Teacher>();
		list1.add(t1);
		list1.add(t2);
		list1.add(t3);
		list1.add(t1);
		Collections.sort(list1, new Comparator<Object>(){
			public int compare(Object o1, Object o2) {
				Teacher t1 = (Teacher) o1;
				Teacher t2 = (Teacher) o2;
				return t1.getAge()-t2.getAge();
			}
		});
		for (Iterator<Teacher> it1 = list1.iterator(); it1.hasNext();) {
			System.out.println(it1.next());
		}
		
	}
}
