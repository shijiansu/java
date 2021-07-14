package tarena.day14_generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericUtils {
	public static <K, V> Map<K, V> map(){
		return new HashMap<K, V>();
	}
	
	public static <T> List<T> list(){
		return new ArrayList<T>();
	}
	
	public static <T> List<T> makeList(@SuppressWarnings("unchecked") T... args){
		List<T> list = new ArrayList<T>();
		for(T o : args){
			list.add(o);
		}
		return list;
	}
	
	public static void main(String[] args) {
		//具有类型推断功能
		Map<Integer, String> ms = map();
		ms.put(1, "abc");
		List<String> ss = list();
		ss.add("abc");
		List<Integer> is = list();
		is.add(1);
		List<String> strs = makeList("aaa", "bbb", "ccc");
		for(String s : strs){
			System.out.println(s);
		}
		
	}
}
