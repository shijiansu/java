package tarena.day08_ooad.override.abs;

abstract class Animal{
    @SuppressWarnings("unused")
	private String breed;
    @SuppressWarnings("unused")
	private int age;
	public abstract void eat();
	public void sleep(){
		System.out.println("动物睡觉");
	}
	public Animal(){
		
	}
	public Animal(String breed, int age){
		this.breed = breed;
		this.age = age;
	}
}

class Dog extends Animal{
	public void eat(){
		System.out.println("狗吃骨头");
	}
}

abstract public class TestAbstract{
	public static final void abc(){}
	public static void main(String[]args){
		Animal a = new Dog();
		a.eat();
		a.sleep();
	}
}