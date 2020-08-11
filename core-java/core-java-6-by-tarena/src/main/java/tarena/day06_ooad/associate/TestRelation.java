package tarena.day06_ooad.associate;

/**
 * 车轮
 */
class Wheel {
	private String name;

	public Wheel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void run() {
		System.out.println(name + "滚动");
	}
}

/*
 * 车, 车和车轮之间是聚合关系，因为车的生命周期和轮不同， 并且，车轮可以换
 */
class Car {
	private Wheel[] ws = new Wheel[4];

	public void change(int i, Wheel w) {
		ws[i] = w;
	}

	public void add(Wheel w) {
		for (int i = 0; i < ws.length; i++) {
			if (ws[i] == null) {
				ws[i] = w;
				break;
			}
		}
	}

	public void run() {
		for (int i = 0; i < ws.length; i++) {
			ws[i].run();
		}
		System.out.println("车跑了起来");
	}
}

class TestRelation {
	public static void main(String[] args) {
		Car c = new Car();
		Wheel w1 = new Wheel("左前轮");
		Wheel w2 = new Wheel("右前轮");
		Wheel w3 = new Wheel("左后轮");
		Wheel w4 = new Wheel("右后轮");
		c.add(w1);
		c.add(w2);
		c.add(w3);
		c.add(w4);
		c.run();
		System.out.println("左前轮胎爆啦。。");
		Wheel w5 = new Wheel("新的左前轮");
		c.change(0, w5);
		c.run();
	}
}