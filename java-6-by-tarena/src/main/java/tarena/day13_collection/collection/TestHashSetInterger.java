package tarena.day13_collection.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class TestHashSetInterger {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
		Random r = new Random();
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0; i<3000; i++){
			int x = r.nextInt(20);
			hs.add(x);
		}
		for (Iterator<Integer> it = hs.iterator(); it.hasNext();) {
			Integer i = (Integer) it.next();
			System.out.println(i);
		}
		String s;
	}
}
