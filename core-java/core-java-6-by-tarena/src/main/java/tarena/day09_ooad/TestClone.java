package tarena.day09_ooad;

class Student implements Cloneable{
   private String name;
   private int age;
   public Student(String name, int age){
		this.name = name;
		this.age = age;
   }
   public void show(){
		System.out.println(name+":"+age);
   }
   public Object clone()throws CloneNotSupportedException{
		return super.clone();
   }
}

public class TestClone{
    public static void main(String[]args)throws Exception{
		Student s = new Student("陈才秀", 19);
		Student s1 = (Student)s.clone();
		s.show();
		s1.show();
    }
}