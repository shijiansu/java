package tarena.day12_inner_class.inner;

public class TestAnonyInnerClass {
	private int i1 = 10;
	private static int s1 = 100;
	@SuppressWarnings("unused")
	public void show(final int p){
		int i2 = 20;
		final int i3 = 30;
		IA ia = new IA(){
			public void show(){
				int i4 = 40;
				System.out.println(i1);
				System.out.println(s1);
				//System.out.println(i2);
				System.out.println(i3);
				System.out.println(p);
				System.out.println(i4);
			}
		};
	}
	
	@SuppressWarnings("unused")
	private IA ia = new IA(){
		public void show(){}
	};
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		IA ia = new IA() {
			public void show() {
				System.out.println("Haha");
			}
		};
		ia.show();
		AbsClassA ac = new AbsClassA() {
			public void show() {
				System.out.println("abstract show");
			}
		};
		ac.show();
		ClassA ca = new ClassA("abc"){
			{
				System.out.println("初始化匿名类");
			}
			public void show(){
				System.out.println("Haha ClassA show");
			}
		};
		ca.show();
		
		System.out.println(new IA(){public void show(){}});
		String str = "hello "+new IA(){public void show(){}};
	}
}

interface IA {
	void show();
}

abstract class AbsClassA {
	public abstract void show();
}

class ClassA {
	public ClassA(String name){
		System.out.println("ClassA 构造");
	}
	public void show() {
		System.out.println("ClassA show");
	}
}
