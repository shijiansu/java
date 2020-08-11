package tarena.day04_syntax;

public class TestInstanceVariable {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
		Dog d = new Dog();
		System.out.println(d.size);
		System.out.println(d.breed);
		System.out.println(d.name);
		int i;// 局部变量
		// 没有初始化的局部变量不能使用
		// System.out.println(i);

	}
}