package tarena.day13_collection.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import tarena.day13_collection.compare.Hero;

public class TestHashMap2 {
	@SuppressWarnings("rawtypes")
    public static void main(String[] args) {
		Hero h1 = new Hero("张无忌", "明教教主",1000);
		Hero h2 = new Hero("杨逍","光明左使",600);
		Hero h3 = new Hero("谢逊","明教护法",700);
		Hero h4 = new Hero("赵敏","元朝郡主",400);
		Hero h5 = new Hero("张无忌", "明教教主",1001);
		HashMap<Integer, Hero> hm = new HashMap<Integer, Hero>();
		hm.put(1, h1);
		hm.put(2, h2);
		hm.put(3, h3);
		hm.put(4, h4);
		hm.put(1, h1);
		for (Iterator<Integer> it = hm.keySet().iterator(); it.hasNext();) {
			Integer key = (Integer) it.next();
			Hero value = (Hero) hm.get(key);
			System.out.println(key+":"+value);
		}
		System.out.println("====================");
		HashMap<Hero, String> hm1 = new HashMap<Hero, String>();
		hm1.put(h1, "武当弟子");
		hm1.put(h2, "乾坤大挪移得主");
		hm1.put(h3,"金毛狮王");
		hm1.put(h4, "教主老婆");
		hm1.put(h5, "九阳神功");
		Set<?> entrys = hm1.entrySet();
		for (Iterator<?> it = entrys.iterator(); it.hasNext();) {
			Map.Entry me = (Map.Entry) it.next();
			System.out.println(me.getKey()+":"+me.getValue());
		}
		
	}
}
