package tarena.day21_io;

/**
 * 测试装饰模式
 * 
 * @author Administrator
 * 
 */
public class TestDecorator {
	public static void main(String[] args) {
		Gun gun = new Gun();
		gun.fire();
		Ak47 ak = new Ak47(gun);
		ak.fire();
		B43 b43 = new B43(gun);
		b43.fire();
		b43.aimFire();
		System.out.println("===============");
		B43 b431 = new B43(ak);
		b431.aimFire();
		b431.fire();
	}
}

interface Weapon {
	void fire();
}

/**
 * 原始类，真正完成任务的类
 */
class Gun implements Weapon {
	public void fire() {
		System.out.println("打出一发子弹");
	}
}

/**
 * 装饰类，最大的特点是没有无参的构造方法， 有参的构造方法一定会传入一个被它装饰的对象
 */
class Ak47 implements Weapon {
	private Weapon w;

	public Ak47(Weapon w) {
		this.w = w;
	}

	/**
	 * 装饰类中的功能方法一般是通过调用被装饰对象的方法实现的
	 */
	public void fire() {
		for (int i = 0; i < 10; i++) {
			w.fire();
		}
	}
}

/**
 * 装饰类
 */
class B43 implements Weapon {
	private Weapon w;

	public B43(Weapon w) {
		this.w = w;
	}

	public void fire() {
		System.out.println("增加威力");
		w.fire();
	}

	/**
	 * 增加新的功能方法，只不过这个方法的 实现还得依赖被装饰的对象
	 */
	public void aimFire() {
		System.out.println("瞄准先");
		w.fire();
	}
}
