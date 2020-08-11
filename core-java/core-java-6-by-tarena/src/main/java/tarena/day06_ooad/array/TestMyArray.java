package tarena.day06_ooad.array;

public class TestMyArray {
	public static void main(String[] args) {
		MyArray ma = new MyArray();
		ma.add(1);
		ma.add(2);
		ma.add(3);
		// 不允许访问和修改私有属性
		/*
		 * ma.size=1; int[] a = ma.is; a[100] = 3000;
		 */
	}
}