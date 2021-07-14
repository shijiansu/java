package tarena.day19_multi_threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;

public class TestThreadSecurity {
	@SuppressWarnings("unused")
    public static void main(String[] args) {
		ArrayList<?> arrayList;
		Vector<?> v  = new Vector<Object>();
		arrayList = new ArrayList<Object>();
		Thread t1 = new SecurityThread(arrayList);
		Thread t2 = new SecurityThread(arrayList);
		t1.start();
		t2.start();
		//想要一个线程安全的List
		//但在使用Iterator进行迭代时，另外的线程修改了这个集合的元素会导致异常
		List<?> list = Collections.synchronizedList(new ArrayList<Object>());
		Set<?> set = Collections.synchronizedSet(new HashSet<Object>());
		Map<Object, Object> map = Collections.synchronizedMap(new HashMap<Object, Object>());
		SortedMap<?, ?> smap = Collections.synchronizedSortedMap(new TreeMap<Object, Object>());
		
	}
}

class SecurityThread extends Thread{
	//list是不是临界资源?不是
	private ArrayList<String> list = new ArrayList<String>();
	//list2是不是线程安全？
	private ArrayList<?> list2;
	public SecurityThread(ArrayList<?> list) {
		list2 = list;
	}
	public void run(){
		list.add("haha");
		//list1也不是临界资源
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("ccc");
		for(Object o : list2){
			System.out.println(o);
		}
	}
}

//写一个线程安全的集合
class SecurityList{
	private Object[] os = new Object[10];
	private int size;
	public synchronized void add(Object o){
		os[size] = o;
		size++;
	}
	/*
	 * "abc","def"  2
	 * t1  "ccc"
	 * t2 get(2)
	 * 
	 */
	public synchronized Object get(int index){
		if(index<size){
			return os[index];
		}
		return null;
	}
}