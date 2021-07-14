package tarena.day07_ooad.p.p2;

import tarena.day07_ooad.p.p1.A;

public class D extends A {
	// protected int c = 30;//相当于有个这样的属性
	public void show() {
		// System.out.println(a);
		// 默认属性在外包中不能访问
		// System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
}