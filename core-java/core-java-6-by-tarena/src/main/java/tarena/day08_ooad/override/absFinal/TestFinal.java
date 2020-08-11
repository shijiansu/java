package tarena.day08_ooad.override.absFinal;

public class TestFinal{
    public static void main(String[]args){
		final Dog d = new Dog();
		d.age = 10;
		d.age = 20;
		//d = new Dog();
    }
}

/*final*/ class FinalA{
	public static final double PI = 3.14;
	final int i;//常量
	public FinalA(){
		i = 100;
	}
	public FinalA(int i){
		this.i = i;
	}
	public void change(){
		//i = 20;
	}
	//强制的让子类继承并不允许覆盖
	@SuppressWarnings("unused")
	public final void show(final int v){
		System.out.println("秀一下");
		final int x;
		x = 100;
		//x = 200;
		//x++;
		//v++;
	}
	public void m(final Dog d){
		d.age = 20;
		d.age = 30;
		//d = new Dog();
	}
}
class Dog{
	int age = 10;
}
class FinalB extends FinalA{
	/*不能覆盖父类中的final方法
	public final void show(){
		System.out.println("再秀一下");
	}
	*/
}
