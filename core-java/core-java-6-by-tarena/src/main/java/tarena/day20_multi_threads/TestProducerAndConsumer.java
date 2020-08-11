package tarena.day20_multi_threads;

public class TestProducerAndConsumer {
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		Thread producer1 = new ProducerThread(stack);
		Thread producer2 = new ProducerThread(stack);
		Thread consumer = new ConsumerThread(stack);
		producer1.start();
		producer2.start();
		consumer.start();
	}
}

// 仓库
class MyStack {
	private char[] cs = new char[6];
	private int size;

	public synchronized void push(char c) {
		while (size == cs.length) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		cs[size] = c;
		size++;
		System.out.println(c + " pushed!");
		notifyAll();
	}

	public synchronized char pop() {
		while (size == 0) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		size--;
		System.out.println(cs[size] + " poped!");
		notifyAll();
		return cs[size];
	}

	public synchronized void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(cs[i] + " ");
		}
		System.out.println();
	}
}

// 生产者
class ProducerThread extends Thread {
	private MyStack stack;

	public ProducerThread(MyStack stack) {
		this.stack = stack;
	}

	public void run() {
		for (char c = 'A'; c <= 'Z'; c++) {
			stack.push(c);
			stack.print();
			try {
				Thread.sleep(20);
			} catch (Exception e) {
			}
		}
	}
}

// 消费者
class ConsumerThread extends Thread {
	private MyStack stack;

	public ConsumerThread(MyStack stack) {
		this.stack = stack;
	}

	public void run() {
		for (int i = 0; i < 52; i++) {
			stack.pop();
			stack.print();
			try {
				Thread.sleep(40);
			} catch (Exception e) {
			}
		}
	}
}
