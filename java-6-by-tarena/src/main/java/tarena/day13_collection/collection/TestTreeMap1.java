package tarena.day13_collection.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

import tarena.day13_collection.compare.Hero;

public class TestTreeMap1 {
	public static void main(String[] args) {
		Hero h1 = new Hero("张无忌", "明教教主",1000);
		Hero h2 = new Hero("杨逍","光明左使",600);
		Hero h3 = new Hero("谢逊","明教护法",700);
		Hero h4 = new Hero("赵敏","元朝郡主",400);
		Hero h5 = new Hero("张无忌", "明教教主",1001);
		TreeMap<Integer, Hero> tm = new TreeMap<Integer, Hero>();
		tm.put(1, h1);
		tm.put(2, h2);
		tm.put(3, h3);
		tm.put(4, h4);
		tm.put(5, h5);
		for (Iterator<Integer> it = tm.keySet().iterator(); it.hasNext();) {
			Integer key = (Integer) it.next();
			System.out.println(key+":"+tm.get(key));
		}
		System.out.println("=====================");
		TreeMap<Hero, String> tm1 = new TreeMap<Hero, String>();
		tm1.put(h1, "武当弟子");
		tm1.put(h2, "乾坤大挪移得主");
		tm1.put(h3,"金毛狮王");
		tm1.put(h4, "教主老婆");
		tm1.put(h5, "九阳神功");
		for (Iterator<Hero> it = tm1.keySet().iterator(); it.hasNext();) {
			Hero h = (Hero) it.next();
			System.out.println(h+":"+tm1.get(h));
		}
		System.out.println("=========================");
		TreeMap<Hero, String> tm2 = new TreeMap<Hero, String>(new Comparator<Object>(){
			public int compare(Object o1, Object o2) {
				Hero h1 = (Hero) o1;
				Hero h2 = (Hero) o2;
				return h1.getName().compareTo(h2.getName());
			}
		});
		tm2.put(h1, "武当弟子");
		tm2.put(h2, "乾坤大挪移得主");
		tm2.put(h3,"金毛狮王");
		tm2.put(h4, "教主老婆");
		tm2.put(h5, "九阳神功");
		for (Iterator<Hero> it = tm2.keySet().iterator(); it.hasNext();) {
			Hero h = (Hero) it.next();
			System.out.println(h+":"+tm2.get(h));
		}
	}
}
