package tarena.day14_generic;

public class MyGenericClass<T> {
	@SuppressWarnings("unused")
    private T a;
	public void set(T o){}
	public T get(){return null;}
	//在静态方法中不能使用类定义的泛型
	public static <M> void staticm(M x){//不能T
		
	}
}
