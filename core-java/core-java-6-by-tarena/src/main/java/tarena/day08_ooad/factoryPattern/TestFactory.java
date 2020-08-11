package tarena.day08_ooad.factoryPattern;

class Car{
    public void show(){
		System.out.println("秀一下小汽车");
    }
}
class BMW extends Car{
	public void show(){
		System.out.println("我是宝马");
	}
}
class Benz extends Car{
	public void show(){
		System.out.println("我是大奔");
	}
}

class Customer{
	public void buy(){
		Car c = CarFactory.newInstance(0);
		c.show();
	}
}

/**
	工厂类
*/
class CarFactory{
	/**
		工厂方法
	*/
	public static Car newInstance(int i){
		if(i==0){
			return new BMW();
		}else{
			return new Benz();
		}
	}
}