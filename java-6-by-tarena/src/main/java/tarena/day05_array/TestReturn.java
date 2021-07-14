package tarena.day05_array;

public class TestReturn {
	@SuppressWarnings("unused")
    public static int get() {
		if (true) {
			return 10;
			// System.out.println("dfasdf");
		}
		return 20;
		// System.out.println("=====");
	}

	public static void main(String[] args) {
		System.out.println(get());
	}
}