package tarena.day16_reflection;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;

public class TestORM {
	public static void main(String[] args) throws Exception {
		// 从数据库中读取一条记录
		FileInputStream fis = new FileInputStream("student.properties");
		Properties prop = new Properties();
		prop.load(fis);
		fis.close();
		// 构造出一个Student对象
		Class<?> c = Class.forName("day16.Student");// 类名也应该从配置文件中读取出来
		Object o = c.newInstance();
		// 对每一个属性符值
		Set<?> keys = prop.keySet();
		for (Object key : keys) {
			String p = (String) key;
			// 得到方法名
			// "name"===>"setName"
			String methodName = "set" + (p.charAt(0) + "").toUpperCase()
					+ p.substring(1);
			// 得到属性对象，目的是想知道属性的类型
			Field f = c.getDeclaredField(p);
			// 得到方法对象，为了调用
			try {
				Method setMethod = c.getMethod(methodName, f.getType());
				if (f.getType() == String.class) {
					setMethod.invoke(o, prop.getProperty(p));
				} else if (f.getType() == int.class) {
					setMethod.invoke(o, Integer.parseInt(prop.getProperty(p)));
				}
			} catch (NoSuchMethodException e) {
				//给私有的属性符值
				f.setAccessible(true);//这一步是必需的
				if (f.getType() == int.class) {
					f.setInt(o, Integer.parseInt(prop.getProperty(p)));
				} else if (f.getType() == String.class) {
					f.set(o, prop.getProperty(p));
				}
			}
			// 调用方法
		}
		System.out.println(o);
	}
}
