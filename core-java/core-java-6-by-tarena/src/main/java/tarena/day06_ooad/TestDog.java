package tarena.day06_ooad;

class Dog {
	String name;
	int age;

	Dog() {
		/*
		 * name = "无名"; age = 1;
		 */
		// 对另外一个构造方法的调用必需出现在第一行
		this("无名", 1);// 调用另外一个构造方法
		System.out.println("空参构造方法已经调用");
	}

	Dog(String name, int age) {
		System.out.println("Dog(String, int)被调用");
		this.name = name;
		this.age = age;
	}

	void setName(String name) {
		// 普通的方法中不允许调用构造方法
		// this("aadfa",2);
		this.name = name;
	}

	void setAge(int age) {
		this.age = age;
	}
	@SuppressWarnings("unused")
	void show() {
		String name = "haha";
		System.out.println(this.name);
	}
}

public class TestDog {
	public static void main(String[] args) {
		Dog d = new Dog("旺财", 3);
		System.out.println(d.name + ":" + d.age);
		d.show();
		Dog d1 = new Dog();
		System.out.println(d1.name + ":" + d1.age);
	}
}