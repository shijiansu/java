package tarena.day15_exception;

public class TestError {
	public static void m()/* throws Error */{
		throw new Error("这是一个严重的错误");
	}

	public static void main(String[] args) {
		//不要对一个Error进行捕获，因为Error代表一个严重的，
		//不可恢复的问题
		try {
			m();
		} catch (Error e) {
			System.out.println("捕获了一个错误");
		}
	}
}
