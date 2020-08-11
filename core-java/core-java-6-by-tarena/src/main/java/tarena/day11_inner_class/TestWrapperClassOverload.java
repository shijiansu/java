package tarena.day11_inner_class;

public class TestWrapperClassOverload{
	
	public static void m(int i){
		System.out.println("m(int)");
	}
	
	public static void m(double d){
		System.out.println("m(double)");
	}
	public static void m(Integer i){
		System.out.println("m(Integer)");
	}
	
	public static void m(Double d){
		System.out.println("m(Double)");
	}
	@SuppressWarnings("unused")
    public static void main(String[]args){
		m(10);
		//Double d = new Integer(10);
		double d = 10;
		//Animal a = new Dog();
		//Double d1 = 10;
		long l = 20;
		//Long l1 = 20;


    }
}