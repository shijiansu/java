package tarena.day16_reflection;

public class Student {
	private String name;
	private int age;
	private String gender;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
/*	public void setName(String name) {
		this.name = name;
	}*/
	public int getAge() {
		return age;
	}
/*	public void setAge(int age) {
		this.age = age;
	}*/
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {	}
	public String toString(){
		return name+":"+age+":"+gender;
	}
	
	public void m(int x, String y, double z){
		System.out.println("m(int, String, double)");
	}
	public static void ms(){
		System.out.println("ms()");
	}
	public static void ms(int x, int y, String z){
		System.out.println("ms(int, int, String)");
	}
}
