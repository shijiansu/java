package tarena.day05_array;

public class MyArray {
	int[] is = new int[3];
	int size = 0;

	void expend() {
		int[] other = new int[is.length * 2];
		for (int i = 0; i < size; i++) {
			other[i] = is[i];
		}
		is = other;
	}

	void add(int x) {
		// 如果空间不够，扩容
		if (size >= is.length) {
			expend();
		}
		// 把客户的数据放到该放的位置
		is[size] = x;
		size++;
	}

	void delete(int index) {
		if (index >= size || index < 0) {
			return;
		}
		for (int i = index; i < size - 1; i++) {
			is[i] = is[i + 1];
		}
		size--;
	}

	void set(int index, int x) {
		if (index >= size || index < 0) {
			return;
		}
		is[index] = x;
	}

	int get(int index) {
		return is[index];
	}

	void insert(int index, int x) {
		if (size >= is.length) {
			expend();
		}
		for (int i = size; i > index; i--) {
			is[i] = is[i - 1];
		}
		is[index] = x;
		size++;
	}

	void print() {
		for (int i = 0; i < size; i++) {
			System.out.print(is[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyArray ma = new MyArray();
		ma.add(1);
		ma.add(2);
		ma.add(3);
		// ma.delete(2);
		ma.insert(3, 4);
		ma.print();
		/*
		 * ma.add(4); ma.add(5); ma.add(6); ma.add(7); ma.add(8); ma.delete(1);
		 * ma.set(0, 100); ma.print(); System.out.println("\n"+ma.get(4));
		 * ma.insert(4, 200); ma.print(); ma.insert(4, 300); ma.print();
		 * ma.insert(4, 400); ma.print(); ma.insert(4, 500); ma.print();
		 * ma.insert(4, 500); ma.print(); ma.insert(4, 500); ma.print();
		 * ma.insert(4, 500); ma.print(); ma.delete(13); ma.print();
		 */
	}
}