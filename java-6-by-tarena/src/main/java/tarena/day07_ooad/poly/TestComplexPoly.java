package tarena.day07_ooad.poly;

public class TestComplexPoly {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();
		a1.m(b);// A and A
		a1.m(c);// A and A
		a1.m(d);// A and D
		a2.m(b);// B and B
		a2.m(c);// B and B
		a2.m(d);// A and D
		b.m(b); // B and B
		b.m(c); // B and B
		b.m(d); // A and D
	}
}

class A {
	public void m(D d) {
		System.out.println("A and D");
	}

	public void m(A a) {
		System.out.println("A and A");
	}
}

class B extends A {
	public void m(A a) {
		System.out.println("B and A");
	}

	public void m(B b) {
		System.out.println("B and B");
	}
}

class C extends B {
}

class D extends B {
}