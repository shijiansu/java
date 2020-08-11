package tarena.day15_exception;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestStudent {
	public static void main(String[] args) {
		Class<Student> c = Student.class;
		Field[] fs = c.getDeclaredFields();
		System.out.println("属性：");
		for(Field f : fs){
			System.out.print("\t名称：");
			System.out.print(f.getName());
			System.out.print("\t类型：");
			System.out.print(f.getType().getName());
			System.out.print("\t修饰符：");
			System.out.print(Modifier.toString(f.getModifiers()));
			System.out.println();
		}
		System.out.println("构造方法：");
		Constructor<?>[] cs = c.getConstructors();
		for(Constructor<?> co : cs){
			System.out.print("\t"+c.getName()+"(");
			Class<?>[] ps = co.getParameterTypes();
			for(Class<?> cps : ps){
				System.out.print(cps.getName()+",");
			}
			System.out.println(")");
		}
		System.out.println("方法：");
		Method[] ms = c.getMethods();
		for(Method m : ms){
			System.out.print("\t名：");
			System.out.print(m.getName());
			System.out.print("\t修饰符：");
			System.out.print(Modifier.toString(m.getModifiers()));
			System.out.print("\t返回：");
			System.out.print(m.getReturnType().getName());
			System.out.print("\t参数列表：");
			Class<?>[] ps = m.getParameterTypes();
			for(Class<?> cps : ps){
				System.out.print(cps.getName()+",");
			}
			System.out.println(" ");
		}
	}
}
