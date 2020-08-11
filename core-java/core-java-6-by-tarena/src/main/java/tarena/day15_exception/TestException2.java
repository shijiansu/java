package tarena.day15_exception;

import java.util.Random;

public class TestException2 {
	public static void main(String[] args) throws Exception {
		try{
			m1();
		}catch(Exception e){
			System.out.println("一个人20万");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void m1() throws Exception {
		m2();
	}

	public static void m2() throws Exception {
		m3();
	}

	public static void m3() throws Exception {
		m4();
	}

	public static void m4() throws Exception {
		m5();
	}

	public static void m5() throws Exception {
		Random r = new Random();
		if (r.nextBoolean()) {
			throw new Exception("村长: 出事了，爆炸啦，死人啦，100多人！");
		}
	}

}
