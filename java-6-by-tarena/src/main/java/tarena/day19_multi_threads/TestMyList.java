package tarena.day19_multi_threads;

public class TestMyList {
	public static void main(String[] args)throws Exception{
		MyList list = new MyList();//临界资源
		list.add("宋婕");
		MyListThread1 t1 = new MyListThread1(list);
		MyListThread2 t2 = new MyListThread2(list);
		t1.start();
		t2.start();
		Thread.sleep(1000);
		list.print();
	}
}
class MyList{
	private Object[] os = new Object[5];
	private int size;
	
	//同步方法,如果一个线程要调用这个方法，这个线程必需先获得
	//当前对象的锁标记
	public synchronized void add(Object o){
		os[size] = o;
		try{Thread.sleep(40);}catch(Exception e){}
		size++;
	}
	public void print(){
		for(int i=0; i<size; i++){
			System.out.print(os[i]+" ");
		}
	}
}

class MyListThread1 extends Thread{
	private MyList list;
	public MyListThread1(MyList list) {
		this.list = list;
	}
	public void run(){
		//临界区
		//synchronized(list){//同步代码块
			list.add("金兰");
		//}
	}
}
class MyListThread2 extends Thread{
	private MyList list;
	public MyListThread2(MyList list) {
		this.list = list;
	}
	public void run(){
		//synchronized(list){
			list.add("赵君");
		//}
	}
}
