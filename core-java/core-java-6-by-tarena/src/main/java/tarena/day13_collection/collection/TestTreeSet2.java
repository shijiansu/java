package tarena.day13_collection.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import tarena.day13_collection.compare.Teacher;

public class TestTreeSet2 {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
		Teacher t1 = new Teacher("才秀", 22);
		Teacher t2 = new Teacher("赵君", 28);
		Teacher t3 = new Teacher("郭", 30);
		Comparator<?> c = new TeacherComparator();
		TreeSet<Teacher> ts = new TreeSet<Teacher>();
		ts.add(t1);
		ts.add(t2);
		ts.add(t3);
		Iterator<Teacher> it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}

//比较器类
class TeacherComparator implements Comparator<Object>{
	public int compare(Object o1, Object o2) {
		Teacher t1 = (Teacher) o1;
		Teacher t2 = (Teacher) o2;
		/*if(t1.getAge()>t2.getAge()){
			return -1;
		}else if(t1.getAge()<t2.getAge()){
			return 1;
		}
		return 0;*/
		return -(t1.getAge()-t2.getAge());
	}
}
