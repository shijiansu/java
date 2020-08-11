package tarena.day19_multi_threads;

public class TestThread {
	public static void main(String[] args)throws Exception {
		Thread t = new Thread();//线程对象
		t.start();		
		Thread t1 = new FirstThread();
		Runnable runnable = new MyRunnable();
		Thread t2 = new Thread(runnable);
		t1.start();
		t2.start();
		System.out.println("主方法结束");
		Thread.sleep(1000);
		//一个线程对象的start方法只能被调用一次
		//t1.start();
	}
}

class FirstThread extends Thread{
	public void run(){
		for(int i=0; i<100; i++){
			System.out.println("$$$");
		}
	}
}

class MyRunnable implements Runnable{
	public void run(){
		for(int i=0; i<100; i++){
			System.out.println("&&&");
		}
	}
}