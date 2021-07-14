package tarena.day09_ooad;

public class TestFeeder{
    public static void main(String[]args){
		Feeder f = new Feeder();
		Tiger t = new Tiger();
		Dog d = new Dog();
		Cat c = new Cat();
		Fish fish = new Fish();
		Human h = new Human();
		Bone b = new Bone();
		XiaMi xm = new XiaMi();
		f.feed(t, h);
		f.feed(d, b);
		f.feed(fish, xm);
		f.feed(c, fish);
    }
}
abstract class Animal{
    public abstract void eat(Food food);
}
interface Food{
	String getName();
}
class Feeder{
	public void feed(Animal animal, Food food){
		animal.eat(food);
	}
}
//==========================================
class Tiger extends Animal{
	public void eat(Food food){
		System.out.println("Tiger eat "+food.getName());
	}
}
class Dog extends Animal{
	public void eat(Food food){
		System.out.println("Dog eat "+food.getName());
	}
}
class Cat extends Animal{
	public void eat(Food food){
		System.out.println("Cat eat "+food.getName());
	}
}
class Fish extends Animal implements Food{
	public String getName(){
		return "Fish";
	}
	public void eat(Food food){
		System.out.println("Fish eat "+food.getName());
	}
}

class Human implements Food{
	public String getName(){
		return "Human";
	}
}
class Bone implements Food{
	public String getName(){
		return "Bone";
	}
}

class XiaMi implements Food{
	public String getName(){
		return "XiaMi";
	}
}
