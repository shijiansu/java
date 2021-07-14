package tarena.day12_inner_class;

public class Student {
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString(){
		return name+":"+age;
	}
	public int hashCode(){
		return age;
	}
	
	public boolean equals(Object o){
		if(o==null){
			return false;
		}
		if(this==o){
			return true;
		}
		if(!(o instanceof Student)){
			return false;
		}
		Student s = (Student)o;
		if(s.getName().equals(this.name)&&s.getAge()==this.age){
			return true;
		}
		return false;
	}
	
}
