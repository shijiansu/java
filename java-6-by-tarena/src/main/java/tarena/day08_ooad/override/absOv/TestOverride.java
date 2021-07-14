package tarena.day08_ooad.override.absOv;

class Animal{}
class Dog extends Animal{}
class A{
    Animal get(){
		return new Dog();
    }
}
class B extends A{
    Dog get(){
		return new Dog();
    }
}
public class TestOverride{
    @SuppressWarnings("unused")
    public static void main(String[]args){
		A a = new B();
		Animal an = a.get();
    }
}