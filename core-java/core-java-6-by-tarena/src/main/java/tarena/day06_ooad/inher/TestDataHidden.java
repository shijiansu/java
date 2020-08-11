package tarena.day06_ooad.inher;

/*public*/class Girl {
	private String name;
	private int age;
	private boolean lover;
	private String addr;
	private String job;

	public Girl(String name, int age, boolean lover, String addr, String job) {
		this.name = name;
		this.age = age;
		this.lover = lover;
		this.addr = addr;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age + 1;
	}

	public boolean getLover() {
		return lover;
	}

	public String getAddr() {
		return addr;
	}

	public String getJob() {
		return job;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		if (age <= 0 || age >= 60) {
			return;
		}
		this.age = age;
	}

	public void setLover(boolean lover) {
		this.lover = lover;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setJob(String job) {
		this.job = job;
	}
}

public class TestDataHidden {
	public static void main(String[] args) {
		Girl g = new Girl("如花", 18, false, "天河", "无业");
		System.out.println(g.getName());
		System.out.println(g.getAge());
		System.out.println(g.getLover());
		// g.age = 0;
	}
}