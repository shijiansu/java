package tarena.day16_reflection;

//@TestAnnotation
public class MyClass {
	//@TestAnnotation("赵君")
	public MyClass() {
	}
	//要测试，name="赵君"
	@TestAnnotation("赵君")
	public void m1(String name){
		System.out.println("m1(String):"+name);
	}
	
	//要测试，name="宋婕"
	@TestAnnotation("宋婕")
	public void m2(String name){
		System.out.println("m2():" + name);
	}
	
	//要测试
	@TestAnnotation
	public void m3(String name){
		System.out.println("m3():"+name);
	}
	
	//不测试
	@TestAnnotation
	public void m4(String name){
		System.out.println("m4():"+name);
	}
}
