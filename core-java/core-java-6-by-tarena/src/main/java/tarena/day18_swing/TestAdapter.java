package tarena.day18_swing;

/**
 * 缺省适配器模式
 * @author Administrator
 *
 */
public class TestAdapter {

}

class IAImpl extends IAAdapter{
	public void m2() {
		System.out.println("m2()");
	}
}

interface IA{
    void m1();
    void m2();
    void m3();
    void m4();
    void m5();
}

/**
 * IA接口的适配器类
 */
abstract class IAAdapter implements IA{
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
	public void m5() {}
}
