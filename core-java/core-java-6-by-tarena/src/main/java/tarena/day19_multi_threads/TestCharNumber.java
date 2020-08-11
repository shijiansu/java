package tarena.day19_multi_threads;

public class TestCharNumber {
	public static void main(String[] args) {
		Thread t1 = new CharThread();
		Thread t2 = new NumberThread();
		t1.setPriority(1);
		t2.setPriority(10);
		t1.start();
		t2.start();
	}
}
class NumberThread extends Thread{
	public void run(){
		for(int i=1; i<=26; i++){
			System.out.print(i+" ");
		}
	}
}
class CharThread extends Thread{
	public void run(){
		for(char c='A'; c<='Z'; c++){
			System.out.print(c+" ");
			if(c=='E'){
				Thread.yield();
			}
		}
	}
}