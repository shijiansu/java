package tarena.day14_generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TestGeneric1 {
	@SuppressWarnings("rawtypes")
    public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("abc");
		//list.add(1);
		list.add("def");
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
		for(String s : list){
			System.out.println(s);
		}
		HashSet<Number> hs = new HashSet<Number>();
		hs.add(1);
		hs.add(3.14);
		ArrayList<Comparable> a1 = new ArrayList<Comparable>();
		a1.add(10);
		a1.add("abc");
		TreeSet<Student> ts = new TreeSet<Student>();
		ts.add(new Student());
		ts.add(new Student());
		Map<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "abc");
		hm.put(2, "30");
		hm.put(3, "haha");
		Set<Integer> keys = hm.keySet();
		Iterator<Integer> ite = keys.iterator();
		while(ite.hasNext()){
			Integer key = ite.next();
			String value = hm.get(key);
			System.out.println(key+":"+value);
		}
		System.out.println("======================");
		Set<Map.Entry<Integer, String>> entries 
			= hm.entrySet();
		for(Map.Entry<Integer, String> me : entries){
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println(key+":"+value);
		}
		
	}
}

class Student implements Comparable<Student>{
	@SuppressWarnings("unused")
    private String name;
	private int age;
	public int compareTo(Student o) {
		return age - o.age;
	}
}

interface GenericInterface<E>{
	void show(E e);
	E get();
}
class GenericInterfaceImpl implements GenericInterface<String>{
	public String get() {
		return "hello";
	}
	public void show(String e) {
		System.out.println(e);
	}	
}
class GenericClass<A, B, C, D>{
	@SuppressWarnings("unused")
    private A a;
	@SuppressWarnings("unused")
	private B b;
	@SuppressWarnings("unused")
	private C c;
	@SuppressWarnings("unused")
	private D d;
	
	public GenericClass(A a, B b, C c, D d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		GenericClass<Integer, String, Double, Boolean>
		g = new GenericClass<Integer, String, Double, Boolean>
		 (1, "abc", 1.2, false);
		
	}
}
