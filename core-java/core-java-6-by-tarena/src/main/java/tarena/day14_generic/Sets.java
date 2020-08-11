package tarena.day14_generic;

import java.util.HashSet;
import java.util.Set;

public class Sets {
	public static <T> Set<T> union(Set<T> a, Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	public static <T> Set<T> intersection(Set<T> a, Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}
	
	public static <T> Set<T> difference(Set<T> superSet, Set<T> subSet){
		Set<T> result = new HashSet<T>(superSet);
		result.removeAll(subSet);
		return result;
	}
	
	public static <T> Set<T> complement(Set<T> a, Set<T> b){
		return difference(union(a, b),intersection(a, b));
	}
	
	public static void main(String[] args) {
		Set<Integer> ss1 = new HashSet<Integer>();
		ss1.add(1);
		ss1.add(2);
		ss1.add(3);
		Set<Integer> ss2 = new HashSet<Integer>();
		ss2.add(3);
		ss2.add(4);
		ss2.add(5);
		Set<Integer> ss = union(ss1, ss2);
		print(ss);
		System.out.println("==============");
		print(intersection(ss1, ss2));
		System.out.println("==============");
		print(difference(ss1, ss2));
		System.out.println("==============");
		print(complement(ss1, ss2));
		
	}
	private static <T> void print(Set<T> ss) {
		for(T o : ss){
			System.out.println(o);		
		}
	}
}
