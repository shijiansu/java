package tarena.day16_reflection;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeMap;

public class TarenaStudent {
	@Order(3)
	public void studyCoreJava(){
		System.out.println("study core java");
	}
	@Order(1)
	public void studyUnix(){
		System.out.println("study unix");
	}
	@Order(2)
	public void studyOracle(){
		System.out.println("study oracle");
	}
	@Order(5)
	public void studyJDBC(){
		System.out.println("study jdbc");
	}
	@Order(4)
	public void studyOOAD(){
		System.out.println("study ooad");
	}
	@Order(6)
	public void studyWEB(){
		System.out.println("study Web");
	}
	public static void main(String[] args)throws Exception {
		Class<?> c = Class.forName("day16.TarenaStudent");
		Object o = c.newInstance();
		Method[] ms = c.getMethods();
		TreeMap<Integer, Method> tm = new TreeMap<Integer, Method>();
		for(Method m : ms){
			if(m.isAnnotationPresent(Order.class)){
				Order order = m.getAnnotation(Order.class);
				int key = order.value();
				tm.put(key, m);
			}
		}
		Set<Integer> keys = tm.keySet();
		for(Integer key : keys){
			Method m = tm.get(key);
			m.invoke(o);
		}
	}
}
