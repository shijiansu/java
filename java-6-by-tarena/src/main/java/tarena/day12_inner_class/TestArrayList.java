package tarena.day12_inner_class;

import java.util.ArrayList;

public class TestArrayList {
	public static void print(ArrayList<Integer> al){
		System.out.println("=====================");
		for(int i=0; i<al.size(); i++){
			System.out.println(al.get(i));
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		print(al);
		System.out.println(al.get(2));
		al.remove(new Integer(1));
		print(al);
	}
}
