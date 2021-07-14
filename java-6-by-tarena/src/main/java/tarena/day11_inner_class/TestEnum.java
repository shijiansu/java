package tarena.day11_inner_class;

//不安全的枚举
class Season{
    public static final int SPRING = 0;
    public static final int SUMMER = 1;
    public static final int AUTUMN = 2;
    public static final int WINTER = 3;
}

//类型安全的枚举类
final class Season1{
	public static final Season1 SPRING = new Season1("春");
	public static final Season1 SUMMER = new Season1("夏");
	public static final Season1 AUTUMN = new Season1("秋");
	public static final Season1 WINTER = new Season1("冬");
	private Season1(String name){
		this.name = name;
	}
	private String name;
	public String toString(){
		return name;
	}
	public void show(){
		System.out.println(name+"天啊"+name+"天!");
	}
}

//新的枚举类型，是编译期语法
interface IA{}
enum Season2 implements IA{
	SPRING("春"){
		public void show(){
			System.out.println("春天啊春天！");	
		}
	},
	SUMMER("夏"){
		public void show(){
			System.out.println("激情夏日!");
		}
	},
	AUTUMN("秋"){
		public void show(){
			System.out.println("天凉好个秋！");
		}
	},
	WINTER("冬"){
		public void show(){
			System.out.println("冬天来了，春天还会远吗？");
		}
	};
	private String name;
	private Season2(String name){
		this.name = name;
	}
	public String toString(){
		return name;
	}
	public abstract void show();
}

enum Week{
	星期一,
	星期二,
	星期三,
	星期四,
	星期五,
	星期六,
	星期日
}
/*
class SeasonChild extends Season2{
}
*/
public class TestEnum{
	enum Test{A, B, C, D}
	public static void show(int i){
		if(i==Season.SPRING){
			System.out.println("春天");
		}else if(i==Season.SUMMER){
			System.out.println("夏天");
		}else if(i==Season.AUTUMN){
			System.out.println("秋天");
		}else if(i==Season.WINTER){
			System.out.println("冬天");
		}
	}
	public static void show(Season1 s){
		if(s==Season1.SPRING){
			System.out.println("春天");
		}else if(s==Season1.SUMMER){
			System.out.println("夏天");
		}else if(s==Season1.AUTUMN){
			System.out.println("秋天");
		}else if(s==Season1.WINTER){
			System.out.println("冬天");
		}
	}

	public static void show(Season2 s){
		if(s==Season2.SPRING){
			System.out.println("春天");
		}else if(s==Season2.SUMMER){
			System.out.println("夏天");
		}else if(s==Season2.AUTUMN){
			System.out.println("秋天");
		}else if(s==Season2.WINTER){
			System.out.println("冬天");
		}
	}
	public static void main(String[]args){
		Season1 s = Season1.SPRING;
		System.out.println(s);
		Season1.WINTER.show();
		Season2 s1 = Season2.WINTER;
		show(s1);
		Week w = Week.星期五;
		switch(w){
			case 星期一:
				System.out.println("今天是星期一");
				break;
			case 星期二:
				System.out.println("今天是星期二");
				break;
			case 星期三:
				System.out.println("今天是星期三");
				break;
			case 星期四:
				System.out.println("今天是星期四");
				break;
			case 星期五:
				System.out.println("今天是星期五");
				break;
			case 星期六:
				System.out.println("今天是星期六");
				break;
			case 星期日:
				System.out.println("今天是星期日");
		}
		System.out.println("============================");
		String str = Season2.SPRING.name();
		System.out.println(str);
		System.out.println(Week.星期日.ordinal());
		Season2[] ss = Season2.values();
		for(int i=0; i<ss.length; i++){
			System.out.print(ss[i]+" ");
			ss[i].show();
		}
	}
}