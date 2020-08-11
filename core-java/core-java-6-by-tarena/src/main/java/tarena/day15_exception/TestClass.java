package tarena.day15_exception;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestClass {
    @SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException {
		//获得一个类对象的引用，有三种方式
		Class<String> c1 = String.class;
		String s = "abc";
		Class<? extends String> c2 = s.getClass();
		Class<?> c3 = Class.forName("java.lang.String");
		System.out.println(c1==c2);
		System.out.println(c1==c3);
		//通过这种方式获得类对象时，类不会被加载
		Class<Sample> s1 = Sample.class;
		//Sample sa = new Sample();
		//Class s2 = sa.getClass();
		Class<?> s3 = Class.forName("day15.Sample");
		Class<?> superClass = c1.getSuperclass();
		System.out.println(superClass.getName());
		System.out.println("==========interfaces===================");
		Class<?>[] interfaces = c1.getInterfaces();
		for(Class<?> c : interfaces){
			System.out.println(c.getName());
		}
		System.out.println("=============fields============");
		Field[] fs = c1.getFields();
		for(Field f : fs){
			System.out.println(f.getName());
		}
		System.out.println("==========private fields=========");
		Field[] pfs = c1.getDeclaredFields();
		for(Field f : pfs){
			System.out.println(f);
		}
		System.out.println("=========constructors==================");
		Constructor<?>[] cs = c1.getConstructors();
		for(Constructor<?> c : cs){
			System.out.println(c);
		}
		System.out.println("=========methods=============");
		Method[] ms = c1.getMethods();
		for(Method m : ms){
			String methodName = m.getName();
			Class<?>[] parameters = m.getParameterTypes();
			Class<?> returnType = m.getReturnType();
			int modifiers = m.getModifiers();
			String modifiersString = Modifier.toString(modifiers);
			Class<?>[] exceptionType = m.getExceptionTypes();
			String method = modifiersString + " " +
							returnType.getName() + " " +
							methodName +
							"(";
			for(int i=0; i<parameters.length-1; i++){
				method += parameters[i].getName()+",";
			}
			if(parameters.length>0){
				method += parameters[parameters.length-1].getName();
			}
			method += ")";
			for(int i=0; i<exceptionType.length-1; i++){
				method += exceptionType[i].getName()+",";
			}
			if(exceptionType.length>0){
				method += exceptionType[exceptionType.length-1].getName();
			}
			method += ";";
			System.out.println(method);
		}
	}
}
