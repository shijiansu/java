package tarena.day16_reflection;

import java.lang.reflect.Method;

public class TestReflect {
	public static void main(String[] args) throws Exception{
		/*
		 * Student s = new Student();
		 * s.setName("guodh");
		 * s.setAge(30);
		 */
		//可能是从配置文件或xml文件中获取的类名
		String className = "day16.Student";
		Class<?> c = Class.forName(className);
		Object o = c.newInstance();
		Method m = c.getMethod("setName", String.class);
		//System.out.println(m);
		m.invoke(o, "guodh");
		Method m1 = c.getMethod("setAge", int.class);
		m1.invoke(o, 30);
		System.out.println(o);
		Method m2 = c.getMethod("m", int.class, String.class, double.class);
		m2.invoke(o, 1,"abc", 1);
		Method m3 = c.getMethod("ms");
		m3.invoke(null);
	}
}



