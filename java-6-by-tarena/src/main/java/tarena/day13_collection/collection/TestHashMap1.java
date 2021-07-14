package tarena.day13_collection.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestHashMap1 {
	@SuppressWarnings("rawtypes")
    public static void main(String[] args) {
		HashMap<String, Comparable> hm = new HashMap<String, Comparable>();
		hm.put("name", "guodh");
		hm.put("age", 30);
		hm.put("gender", "男");
		Set<String> keys = hm.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			Object key = it.next();
			Object value = hm.get(key);
			System.out.println(key+":"+value);
		}
		System.out.println("=======================");
		Collection<Comparable> values = hm.values();
		Iterator<Comparable> it1 = values.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		
		System.out.println("=======================");
		Set<?> entrys = hm.entrySet();
		Iterator<?> it2 = entrys.iterator();
		while(it2.hasNext()){
			Object o = it2.next();
			Map.Entry me = (Map.Entry)o;
			Object key = me.getKey();
			Object value = me.getValue();
			System.out.println(key+":"+value);
		}
	}
}
