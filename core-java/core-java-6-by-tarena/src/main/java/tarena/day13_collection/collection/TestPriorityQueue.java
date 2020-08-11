package tarena.day13_collection.collection;

import java.util.PriorityQueue;

import tarena.day13_collection.compare.Student;
import tarena.day13_collection.compare.Teacher;

public class TestPriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<Student>();
		Student s1 = new Student("陈才秀", 19);
		Student s2 = new Student("宋婕", 18);
		Student s3 = new Student("郭镫鸿", 20);
		Student s4 = new Student("宋小婕", 18);
		pq.offer(s1);
		pq.offer(s2);
		pq.offer(s3);
		pq.offer(s4);
		while (pq.peek() != null) {
			System.out.println(pq.poll());
		}
		PriorityQueue<Teacher> pq1 = new PriorityQueue<Teacher>(5,new TeacherComparator());
		Teacher t1 = new Teacher("才秀", 22);
		Teacher t2 = new Teacher("赵君", 28);
		Teacher t3 = new Teacher("郭", 30);
		pq1.offer(t2);
		pq1.offer(t1);
		pq1.offer(t3);
		while (pq1.peek() != null) {
			System.out.println(pq1.poll());
		}
	}
}
