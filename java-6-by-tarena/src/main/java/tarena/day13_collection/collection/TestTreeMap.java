package tarena.day13_collection.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TestTreeMap {
	@SuppressWarnings("rawtypes")
    public static void main(String[] args) {
		TreeMap<String, Comparable> tm = new TreeMap<String, Comparable>();
		//添加一些元素，遍历
		tm.put("name", "guodh");
		tm.put("age", 30);
		tm.put("gender", "男");
		Set<String> keys = tm.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			Object key = it.next();
			System.out.println(key+":"+tm.get(key));
		}
		TreeMap<Integer, String> tm1 = new TreeMap<Integer, String>();
		tm1.put(5, "aaa");
		tm1.put(1, "bbb");
		tm1.put(2, "ccc");
		tm1.put(4, "ddd");
		for (Iterator<Integer> it1 = tm1.keySet().iterator(); it1.hasNext();) {
			Object key = (Object) it1.next();
			System.out.println(key+":"+tm1.get(key));
		}
		
	}
}
