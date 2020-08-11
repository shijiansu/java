package tarena.day14_generic;

import java.util.LinkedHashSet;

public class TestLinkedHashSet {
	public static void main(String[] args) {
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		lhs.add("bbb");
		lhs.add("aaa");
		lhs.add("ddd");
		lhs.add("ccc");
		for(Object o : lhs){
			System.out.println(o);
		}
	}
}
