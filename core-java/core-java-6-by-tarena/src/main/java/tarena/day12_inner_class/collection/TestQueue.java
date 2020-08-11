package tarena.day12_inner_class.collection;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestQueue {
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
		Queue q = new LinkedList<String>();
		q.offer("Chencx");
		q.offer("Guodh");
		q.offer("Zhouxingxing");
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println("======================");
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.offer("bbb");
		pq.offer("aaa");
		pq.offer("fff");
		pq.offer("ddd");
		String str = null;
		while((str=(String)pq.poll())!=null){
			System.out.println(str);
		}
	}
}
