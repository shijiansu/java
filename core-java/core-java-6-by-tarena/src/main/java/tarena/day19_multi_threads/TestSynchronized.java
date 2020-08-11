package tarena.day19_multi_threads;

public class TestSynchronized {
	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();
		synchronized(o1){
			synchronized(o2){
				System.out.println("(^_^)");
			}
		}
	}
}
