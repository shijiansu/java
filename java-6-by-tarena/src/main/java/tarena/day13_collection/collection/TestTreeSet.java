package tarena.day13_collection.collection;

import java.util.Iterator;
import java.util.TreeSet;

public class TestTreeSet {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("bbb");
		ts.add("aaa");
		ts.add("ccc");
		ts.add("fff");
		Iterator<String> it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		TreeSet<Integer> ts1 = new TreeSet<Integer>();
		for(int i=10; i>0; i--){
			ts1.add(i);
		}
		for (Iterator<Integer> it1 = ts1.iterator(); it1.hasNext();) {
			System.out.println(it1.next());
		}
	}
}
