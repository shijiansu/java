package tarena.day14_generic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TestForEach {
	@SuppressWarnings("rawtypes")
    public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,0};
		for(int i=0; i<a.length; i++){
			System.out.println(a[i]);
		}
		System.out.println("================");
		//for each 循环
		for(int i : a){
			System.out.println(i);
		}
		System.out.println("=================");
		HashSet<String> hs = new HashSet<String>();
		hs.add("aaa");
		hs.add("bbb");
		hs.add("ccc");
		for(Object o : hs){
			System.out.println(o);
		}
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("key1", "value1");
		hm.put("key2", "value2");
		for(Object o : hm.keySet()){
			System.out.println(o+":"+hm.get(o));
		}
		for(Object o : hm.entrySet()){
			Map.Entry me = (Map.Entry) o;
			System.out.println(me.getKey()+":"+me.getValue());
		}
	}
}
