package tarena.day06_ooad.associate;

class CPU {
	public void powerOn() {
		System.out.println("CPU power on");
	}
}

/**
 * 聚合关系
 */
class Computer {
	private CPU cpu;

	public Computer(CPU cpu) {
		this.cpu = cpu;
	}

	public void start() {
		cpu.powerOn();
		System.out.println("Computer start...");
	}
}

class TestComputer {
	public static void main(String[] args) {
		CPU cpu = new CPU();
		Computer c = new Computer(cpu);
		c.start();
	}
}