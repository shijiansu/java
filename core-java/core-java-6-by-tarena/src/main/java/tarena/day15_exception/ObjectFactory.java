package tarena.day15_exception;

public class ObjectFactory {
	//工厂方法
	public static Object get(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		/*if(className.equals("Student")){
			return new Student();
		}else if(className.equals("Teacher")){
			return new Teacher();
		}
		return null;*/
		Class<?> c = Class.forName(className);
		Object o = c.newInstance();
		return o;
	}
	@SuppressWarnings("unused")
    public static void main(String[] args)throws Exception {
		Student s = (Student) get("day15.Student");
		Teacher t = (Teacher) get("day15.Teacher");
		Sample s1 = (Sample) get("day15.Sample");
	}
}
