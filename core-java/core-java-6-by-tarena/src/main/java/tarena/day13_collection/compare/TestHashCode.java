package tarena.day13_collection.compare;

public class TestHashCode {
	public static void main(String[] args) {
		Student s1 = new Student("aaa", 20);
		Student s2 = new Student("bbb", 20);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1==s2);
	}
}
