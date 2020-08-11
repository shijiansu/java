package tarena.day13_collection.collection;

import java.util.HashMap;

public class TestHashMap {
	@SuppressWarnings("rawtypes")
    public static void main(String[] args) {
		HashMap<String, Comparable> hm = new HashMap<String, Comparable>();
		hm.put("name", "guodh");
		hm.put("age", 30);
		hm.put("gender", "男");
		Object o = hm.get("age");
		System.out.println(o);
		System.out.println(hm.get("gender"));
		hm.put("age", 40);
		System.out.println(hm.get("age"));
		hm.put(null, "nullValue");
		System.out.println(hm.get(null));
		hm.put(null, "otherNull");
		System.out.println(hm.get(null));
		hm.put("testNull", null);
		System.out.println(hm.get("testNull"));
		hm.put("otherNull", null);
		System.out.println(hm.get("otherNull"));
		hm.put("otherName", "guodh");
		System.out.println(hm.get("otherName"));
		System.out.println(hm.containsKey("name"));
		System.out.println(hm.containsValue("男 "));
		hm.remove("name");
		System.out.println(hm.get("name"));
		System.out.println(hm.containsKey("name"));
		System.out.println(hm.size());
		
	}
}
