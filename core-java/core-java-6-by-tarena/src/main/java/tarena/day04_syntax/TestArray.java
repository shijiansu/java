package tarena.day04_syntax;

public class TestArray {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
		// int i1, i2, i3, i4, i5, i6, i7;
		int nums[] = new int[7];
		for (int i = 0; i < 7; i++) {
			nums[i] = i;
		}
		nums[0] = 100;
		nums[1] = 200;
		nums[2] = 300;
		for (int i = 0; i < 7; i++) {
			System.out.print(nums[i] + " ");
		}
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		int[] b = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		int[] c;
		// c = {1,2,3,4,5,6,7,8,9,0};//Error
		c = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		/*
		 * int[] a = new int[10]; a[0] = 1; a[1] = 2; ....
		 */
		Dog[] dogs = new Dog[3];
		dogs[0] = new Dog();
		dogs[1] = new Dog();
		dogs[2] = new Dog();
		dogs[0].size = 40;
		dogs[1].size = 50;
		dogs[2].bark(3);
		System.out.println("=========================");
		int[] is = new int[10];
		for (int i = 0; i < 10; i++) {
			System.out.print(is[i]);
		}
		System.out.println();
		System.out.println(is.length);
		// is.length = 20;//Error
		for (int i = 0; i < is.length; i++) {
			System.out.print(is[i]);
		}
	}
}