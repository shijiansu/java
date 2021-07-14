package tarena.day07_ooad.poly;

class Vehicle {
	public void stop() {
	}

	public void run() {
	}
}

class Car extends Vehicle {
	public void stop() {
		System.out.println("小汽车停下");
	}

	public void run() {
		System.out.println("小汽车开动");
	}
}

class Bus extends Vehicle {
	public void stop() {
		System.out.println("公共汽车停下");
	}

	public void run() {
		System.out.println("公共汽车开动");
	}
}

class Bicycle extends Vehicle {
	public void stop() {
		System.out.println("自行车在等红灯");
	}

	public void run() {
		System.out.println("自行车过马路");
	}
}

class No11 extends Vehicle {
	public void stop() {
		System.out.println("人在等红灯");
	}

	public void run() {
		System.out.println("人在过马路");
	}
}

public class TestVehicle {
	public static void main(String[] args) {
		Vehicle[] vs = new Vehicle[5];
		vs[0] = new Car();
		vs[1] = new Bus();
		vs[2] = new Bicycle();
		vs[3] = new No11();
		vs[4] = new No11();
		java.util.Random r = new java.util.Random();
		// 如果为真，表示红灯亮
		if (r.nextBoolean()) {
			for (int i = 0; i < vs.length; i++) {
				vs[i].stop();
			}
		} else {
			for (int i = 0; i < vs.length; i++) {
				vs[i].run();
			}
		}
	}
}