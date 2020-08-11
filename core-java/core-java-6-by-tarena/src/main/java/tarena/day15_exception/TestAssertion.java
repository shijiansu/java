package tarena.day15_exception;

public class TestAssertion {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
		int i = -10;
		//以下的代码必需是在i为正数的情况下才可运行
		assert i>0:"i不是正数";//我断言，i是正数
		System.out.println("i为正数");
		String s = "abc";
	}
}
