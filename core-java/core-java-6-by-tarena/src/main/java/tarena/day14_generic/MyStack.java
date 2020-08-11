package tarena.day14_generic;

import java.util.LinkedList;

public class MyStack<E> {
	private LinkedList<E> list = new LinkedList<E>();
	public void push(E o){
		list.push(o);
	}
	public E poll(){
		return list.poll();
	}
	public E peek(){
		return list.peek();
	}
	public boolean empty(){
		return list.isEmpty();
	}
	public static void main(String[] args) {
		MyStack<String> s = new MyStack<String>();
		s.push("aaa");
		s.push("bbb");
		s.push("ccc");
		//s.push(1);
		while(!s.empty()){
			System.out.println(s.poll());
		}
	}
}
