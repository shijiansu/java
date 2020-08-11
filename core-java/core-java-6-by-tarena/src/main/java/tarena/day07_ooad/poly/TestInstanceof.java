package tarena.day07_ooad.poly;

public class TestInstanceof {
	public static void main(String[] args) {
		Object o = new Cat();
		if (o instanceof Cat) {
			System.out.println("is cat");
		}
		if (o instanceof Animal) {
			System.out.println("is animal");
		}
		if (o instanceof Object) {
			System.out.println("is object");
		}
		if (o instanceof Dog) {
			System.out.println("is dog");
		}
		System.out.println("=====================");
		o = null;
		if (o instanceof Cat) {
			System.out.println("is cat");
		}
		if (o instanceof Animal) {
			System.out.println("is animal");
		}
		if (o instanceof Object) {
			System.out.println("is object");
		}
		if (o instanceof Dog) {
			System.out.println("is dog");
		}
	}
}