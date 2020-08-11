package tarena.day20_multi_threads;

public class TestDaemon {
	public static void main(String[] args) {
		Thread t1 = new SampleThread();
		Thread t2 = new DaemonThread();
		t2.setDaemon(true);
		t1.start();
		t2.start();
	}
}

class SampleThread extends Thread {
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.print(i + " ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class DaemonThread extends Thread {
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.print("A ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
