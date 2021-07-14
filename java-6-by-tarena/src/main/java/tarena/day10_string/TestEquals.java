package tarena.day10_string;

class Student{
    private int id;
    private String name;
    private int age;
	public Student(int id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public void show(){
		System.out.println(id+":"+name+":"+age);
	}
	/*
	public boolean equals(Object o){
		Student s = (Student)o;
		if(s.id==id){
			return true;
		}
		return false;
	}
	*/
	public boolean equals(Object o){
		//非空原则
		if(o==null){
			return false;
		}
		//自反性原则
		if(this==o){
			return true;
		}
		if(!(o instanceof Student)){
			return false;
		}
		Student s = (Student)o;
		if(s.id==this.id){
			return true;
		}
		return false;
	}
}

public class TestEquals{
    public static void main(String[]args){
		int i = 10;
		int j = 10;
		System.out.println(i==j);
		Student s = new Student(1,"guodh", 30);
		Student s1 = new Student(1,"guodh", 30);
		System.out.println(s==s1);
		boolean b = s.equals(s1);
		System.out.println("equals:"+b);
    }
}