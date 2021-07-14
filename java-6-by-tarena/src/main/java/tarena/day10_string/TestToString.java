package tarena.day10_string;

class Student2{
    private int id;
    private String name;
    private int age;
	public Student2(int id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public void show(){
		System.out.println(id+":"+name+":"+age);
	}
	public String toString(){
		return id+":"+name+":"+age;
	}
}
public class TestToString{
	public static void main(String[]args){
		Student2 s = new Student2(1,"guodh",30);
		String str = s.toString();
		System.out.println(str);
		System.out.println(s/*.toString()*/);
		String ss = "Hello " + s;
		System.out.println(ss);
	}
}
