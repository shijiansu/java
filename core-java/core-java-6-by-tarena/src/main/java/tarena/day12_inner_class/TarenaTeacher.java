package tarena.day12_inner_class;

public class TarenaTeacher {
	public static void main(String[] args) {
		Teacher t = Tarena.getTeacher("CoreJava");
		Teacher t1 = Tarena.getTeacher("Unix");
		Teacher t2 = Tarena.getTeacher("C#");
		System.out.println(t.getName());
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		t.teach();
		t1.teach();
		t2.teach();
	}
}

interface Teacher{
	String getName();
	void teach();
}
class Tarena{
	private static class Guodh implements Teacher{
		public String getName(){return "Guodh";}
		public void teach(){
			System.out.println("Guodh teach Core Java");
		}
	}
	private static class WangChao implements Teacher{
		public String getName(){return "WangChao";}
		public void teach(){
			System.out.println("WangChao teach Unix");
		}
	}
	private static class Chencx implements Teacher{
		public String getName(){return "Chencx";}
		public void teach(){
			System.out.println("Chencx teach All");
		}
	}
	public static Teacher getTeacher(String course){
		if(course.equals("CoreJava")){
			return new Guodh();
		}else if(course.equals("Unix")){
			return new WangChao();
		}else{
			return new Chencx();
		}
	}
}
