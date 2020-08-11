package tarena.day07_ooad.p.p2;

import tarena.day07_ooad.p.p1.A;

class C {
	public void show() {
		A a = new A();
		// 别的类中不能访问私有成员
		// System.out.println(a.a);
		// 不能在外包中访问默认的成员
		// System.out.println(a.b);
		// 不能在外包中访问保护的成员
		// System.out.println(a.c);
		System.out.println(a.d);
	}
}