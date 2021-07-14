package tarena.day16_reflection;

import java.lang.reflect.Array;

public class TestArray {
	public static void main(String[] args) {
		//int[] array = new int[4];
		Object array = Array.newInstance(int.class, 4);
		//array[0] = 0;
		Array.setInt(array, 0, 0);
		//array[1] = 10;
		Array.setInt(array, 1, 10);
		//System.out.println(Array.getInt(array, 1));
		for(int i=0; i<Array.getLength(array); i++){
			System.out.println(Array.getInt(array, i));
		}
	}
}
