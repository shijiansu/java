package tarena.day20_multi_threads;

//打桩调试
public class TestInterrupted {
	public static void main(String[] args) throws Exception {
		System.out.println("主线程开始");
		Thread t = new SleepThread();
		t.start();
		Thread.sleep(2000);
		t.interrupt();
		System.out.println("主线程结束");
	}
}

class SleepThread extends Thread {
	public void run() {
		System.out.println("Sleep线程开始");
		try {
			Thread.sleep(5000);
			System.out.println("Sleep线程结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
