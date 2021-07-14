package tarena.day07_ooad.poly;

public class ConstructorPoly {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
		Parent p = new Child();
	}
}

class Parent {
	private int i = 10;

	public void show() {
		System.out.println("Parent i=" + i);
	}

	public Parent() {
		show();// 基本上不要在构造方法中调用另外的一些方法
	}
}

class Child extends Parent {
	private int i = 20;

	public void show() {
		System.out.println("Child i=" + i);
	}
}