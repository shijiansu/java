package tarena.day14_generic;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric2 {
	@SuppressWarnings("unused")
    public static void main(String[] args) {
		Object o = new Integer(2);
		Object[] os = new Integer[10];
		Object o1 = os;
		List<?> list = new ArrayList<Object>();
		List<String> list1 = new ArrayList<String>();
		//泛型前后要完全一致
		//ArrayList<Number> ns = new ArrayList<Integer>();
		//ns.add(1.3);
		ArrayList<Number> l1 = new ArrayList<Number>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		ArrayList<Double> l3 = new ArrayList<Double>();
		List<String> l4 = new ArrayList<String>();
		List<Object> l5 = new ArrayList<Object>();
		print(l1);
		print(l2);
		print(l3);
		print(l4);
		print(l5);
		/*
		List<String> l6 = new ArrayList();
		l6.add("abc");
		//l6.add(1);
		List l7 = new ArrayList<String>();
		l7.add("abc");
		l7.add(1);
		*/
		List<?> l8 = new ArrayList<String>();
		//l8.add("abc");
		//l8.add(1);
		//l8.set(0, "abc");
		l8.add(null);
	}
	/*public static void print(List<?> list){
		for(Object o : list){
			System.out.println(o);
		}
	}*/
/*	public static void print(List<? extends Number> list){
		for(Number o : list){
			System.out.println(o);
		}
		//list.add(1.2);
	}*/
/*	public static void print(List<? extends Comparable> list){
		for(Comparable o : list){
			System.out.println(o);
		}
	}*/
	/*public static void print(List<? super Number> list){
		for(Object o : list){
			System.out.println(o);
		}
		list.add(1);
		list.add(1.2);
		//list.add("string");
		Object o = list.get(0);
	}*/
	public static void print(List<?> list){}
}
