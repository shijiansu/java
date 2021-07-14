package tarena.day06_ooad.associate;

/**
 * 老虎和它的腿之间是组合关系，腿的生命同期和老虎的 生命同期等同，
 */

class Leg {
	private String name;

	public Leg(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Tiger {
	private Leg[] legs = new Leg[4];

	public Tiger() {
		legs[0] = new Leg("左前腿");
		legs[1] = new Leg("右前腿");
		legs[2] = new Leg("左后腿");
		legs[3] = new Leg("右后腿");
	}

	public void run() {
		System.out.println(legs[0].getName() + "腾空");
		System.out.println(legs[1].getName() + "腾空");
		System.out.println(legs[2].getName() + "蹬地");
		System.out.println(legs[3].getName() + "蹬地");
		System.out.println("老虎飞奔了起来...");
	}
}

class TestRelation1 {
	public static void main(String[] args) {
		Tiger t = new Tiger();
		t.run();
	}
}
