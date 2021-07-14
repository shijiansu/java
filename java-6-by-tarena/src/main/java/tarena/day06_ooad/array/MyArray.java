package tarena.day06_ooad.array;

public class MyArray {
	private int[] is = new int[3];
	private int size = 0;

	public int size() {
		return size;
	}

	private void expend() {
		int[] other = new int[is.length * 2];
		for (int i = 0; i < size; i++) {
			other[i] = is[i];
		}
		is = other;
	}

	public void add(int x) {
		// 如果空间不够，扩容
		if (size >= is.length) {
			expend();
		}
		// 把客户的数据放到该放的位置
		is[size] = x;
		size++;
	}

	public void delete(int index) {
		if (index >= size || index < 0) {
			return;
		}
		for (int i = index; i < size - 1; i++) {
			is[i] = is[i + 1];
		}
		size--;
	}

	public void set(int index, int x) {
		if (index >= size || index < 0) {
			return;
		}
		is[index] = x;
	}

	public int get(int index) {
		return is[index];
	}

	public void insert(int index, int x) {
		if (size >= is.length) {
			expend();
		}
		for (int i = size; i > index; i--) {
			is[i] = is[i - 1];
		}
		is[index] = x;
		size++;
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(is[i] + " ");
		}
		System.out.println();
	}
}