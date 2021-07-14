package tarena.day08_ooad;

import java.util.Scanner;
/**
	模板模式
	模板类
*/
abstract class Drink{
   public void boilWater(){
		System.out.println("water boiling");
   }
   public void prueInCup(){
		System.out.println("put water in cup");
   }
   public abstract void brew();
   public abstract void addCondiment();
   public boolean isAdd(){
		return true;
   }
   /**
	  模板方法
   */
   public final void prepareDrink(){
		boilWater();
		brew();
		prueInCup();
		if(isAdd()){
			addCondiment();
		}
   }
}

class Coffee extends Drink{
	public void brew(){
		System.out.println("put coffee in cup");
	}
	public void addCondiment(){
		System.out.println("add sugar and milk into cup");
	}
	public boolean isAdd(){
		System.out.print("add condiment?");
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		s.close();
		if(str.equals("Y")||str.equals("y")){
			return true;
		}
		return false;
	}
}

class Tea extends Drink{
	public void brew(){
		System.out.println("put tea in cup");
	}
	public void addCondiment(){
		System.out.println("add leamon into cup");
	}
	public boolean isAdd(){
		return false;
	}
}

public class TestTemplate{
	public static void main(String[]args){
		Drink d1 = new Tea();
		d1.prepareDrink();
		System.out.println("=========================");
		d1 = new Coffee();
		d1.prepareDrink();
	}
}