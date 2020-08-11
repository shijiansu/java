package tarena.day16_reflection;

import java.lang.reflect.Method;

public class TestFramework {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage:java TestFramework className");
			return;
		}
		String className = args[0];
		try {
			Class<?> c = Class.forName(className);
			Object o = c.newInstance();
			Method[] ms = c.getMethods();
			for (Method m : ms) {
				if (m.isAnnotationPresent(TestAnnotation.class)) {
					TestAnnotation t = m.getAnnotation(TestAnnotation.class);
					String str = t.value();
					m.invoke(o, str);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
