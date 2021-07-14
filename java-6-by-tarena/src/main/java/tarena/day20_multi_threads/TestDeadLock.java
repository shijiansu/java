package tarena.day20_multi_threads;

public class TestDeadLock {
	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();
		Thread t1 = new Thread1(o1, o2);
		Thread t2 = new Thread2(o1, o2);
		t1.start();
		t2.start();
	}
}

class Thread1 extends Thread {
	private Object o1;
	private Object o2;

	public Thread1(Object o1, Object o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	public void run() {
		synchronized (o1) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
			synchronized (o2) {
				System.out.println("haha");
			}
		}
	}
}

class Thread2 extends Thread {
	private Object o1;
	private Object o2;

	public Thread2(Object o1, Object o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	public void run() {
		synchronized (o2) {
			try {
				Thread.sleep(20);
			} catch (Exception e) {
			}
			synchronized (o1) {
				System.out.println("hehe");
			}
		}
	}
}