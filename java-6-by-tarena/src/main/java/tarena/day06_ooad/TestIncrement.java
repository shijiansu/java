package tarena.day06_ooad;

class Increment {
	int x = 1;

	Increment increment() {
		x++;
		return this;
	}

	Increment mult() {
		x *= 2;
		return this;
	}
}

public class TestIncrement {
	public static void main(String[] args) {
		Increment a = new Increment();
		System.out.println(a.x);
		a.increment();
		System.out.println(a.x);
		a.increment().increment().increment().increment().mult();
		System.out.println(a.x);

	}
}