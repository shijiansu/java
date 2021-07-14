package tarena.day14_generic;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric3 {
	public static void main(String[] args) {
		ArrayList<Number> l1 = new ArrayList<Number>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		ArrayList<Double> l3 = new ArrayList<Double>();
		List<String> l4 = new ArrayList<String>();
		List<Object> l5 = new ArrayList<Object>();
		Number[] a1 = new Number[10];
		Integer[] a2 = new Integer[10];
		Double[] a3 = new Double[10];
		String[] a4 = new String[10];
		Object[] a5 = new Object[10];
		fill(l1, a1);
		fill(l2, a2);
		fill(l3, a3);
		fill(l4, a4);
		fill(l5, a5);
		//fill(l1, a5);
	}
	//方法的泛型(泛型方法)
	public static <T> void fill(List<T> list, T[] os){
		for(T o : os){
			list.add(o);
		}
	}
}
