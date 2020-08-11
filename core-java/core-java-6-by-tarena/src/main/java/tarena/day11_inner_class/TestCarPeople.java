package tarena.day11_inner_class;

class People{
   public void run(){
	  System.out.println("人在大街上走");
   }
}
interface Car{
	public void run();
}
class CarPeople extends People{
	static class CarImpl implements Car	{
		public void run(){
			System.out.println("汽车在飞驰");
		}
	}
	public void carRun(){
		Car c = new CarImpl();
		c.run();
	}
}

public class TestCarPeople{
	public static void main(String[]args){
		CarPeople cp = new CarPeople();
		cp.run();
		cp.carRun();
	}
}