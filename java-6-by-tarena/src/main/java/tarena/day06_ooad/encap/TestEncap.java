package tarena.day06_ooad.encap;

class Girl {
	private String name;
	private int age;

	public Girl(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean isLover(Boy boy) {
		if (boy.getSalary() >= 10000) {
			return true;
		}
		return false;
	}

	public String getName(Boy boy) {
		if (boy.getSalary() >= 8000) {
			return name;
		}
		return null;
	}

	public int getAge() {
		return age;
	}
}

class Boy {
	private String name;
	private int salary;
	private Girl[] girls = new Girl[10];

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public Boy(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public void requestFriend(Girl girl) {
		if (girl.isLover(this)) {
			for (int i = 0; i < girls.length; i++) {
				if (girls[i] == null) {
					girls[i] = girl;
					System.out.println(girl.getName(this) + "成了" + name
							+ "的女朋友！");
					break;
				}
			}
		} else {
			System.out.println(name + "向一个女孩发出请求，没有响应!");
		}
	}
}

public class TestEncap {
	public static void main(String[] args) {
		Girl g1 = new Girl("陈才秀", 19);
		Girl g2 = new Girl("宋婕", 18);
		Girl g3 = new Girl("陈丹", 20);
		Boy b1 = new Boy("王超", 3000);
		Boy b2 = new Boy("郭镫鸿", 100000);
		b1.requestFriend(g1);
		b1.requestFriend(g2);
		b1.requestFriend(g3);
		b2.requestFriend(g1);
		b2.requestFriend(g2);
	}
}