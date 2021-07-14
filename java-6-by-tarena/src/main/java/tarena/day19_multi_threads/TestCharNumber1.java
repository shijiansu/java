package tarena.day19_multi_threads;

public class TestCharNumber1 {
	public static void main(String[] args) {
		Thread t2 = new NumberThread1();
		Thread t1 = new CharThread1(t2);
		t1.start();
		t2.start();
	}
}
class NumberThread1 extends Thread{
	public void run(){
		for(int i=1; i<=26; i++){
			System.out.print(i+" ");
		}
	}
}
class CharThread1 extends Thread{
	private Thread t;
	public CharThread1(Thread t) {
		this.t = t;
	}
	public void run(){
		for(char c='A'; c<='Z'; c++){
			System.out.print(c+" ");
			if(c=='E'){
				try{t.join();}catch(Exception e){}
			}
		}
	}
}