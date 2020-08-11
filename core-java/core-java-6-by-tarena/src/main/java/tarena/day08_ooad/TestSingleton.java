package tarena.day08_ooad;

/**
	单例模式
*/

//饿汉式
class SingletonObject{
	private static SingletonObject so 
		= new SingletonObject();
    private SingletonObject(){}	
	public static SingletonObject getInstance(){
		return so;
	}
}

//懒汉式
class SingletonObject1{
	private static SingletonObject1 so;
    private SingletonObject1(){}	
	public static synchronized SingletonObject1 getInstance(){
		if(so==null){
			so = new SingletonObject1();
		}
		return so;
	}
}

public class TestSingleton{
	public static void main(String[]args){
		//SingletonObject so = new SingletonObject();
		SingletonObject1 so = SingletonObject1.getInstance();
		System.out.println(so);
		SingletonObject1 so1 = SingletonObject1.getInstance();
		System.out.println(so1);
	}
}