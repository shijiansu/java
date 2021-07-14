package tarena.day12_inner_class.collection;

import java.util.Iterator;
import java.util.LinkedList;
public class TestLinkedList {
	public static void print(LinkedList<String> list){
		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i)+"  ");
		}
		System.out.println();
	}
	public static void print1(LinkedList<String> list){
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			Object o = it.next();
			System.out.print(o+"  ");
		}
		System.out.println();
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		print(list);
		list.remove(1);
		print(list);
		list.set(0, "ddd");
		print(list);
		System.out.println(list.contains("ccc"));
		print1(list);
		list.add("fff");
		list.add("hhh");
		list.add("iii");
		print1(list);
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			Object o = it.next();
			//list.remove(o);
			it.remove();
		}
		print1(list);
	}
}
