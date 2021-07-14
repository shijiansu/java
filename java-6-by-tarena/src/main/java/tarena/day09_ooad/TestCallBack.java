package tarena.day09_ooad;

interface Lamp{
	void light();
}
class ReadingLamp{
	//先有接口的使用者，然后才有接口的实现者
	public void powerOn(Lamp lamp){
		lamp.light();//接口回调
	}
}

class RedLamp implements Lamp{
	public void light(){
		System.out.println("灯泡发红光");
	}
}

class BlueLamp implements Lamp{
	public void light(){
		System.out.println("灯泡发蓝光");
	}
}

public class TestCallBack{
	public static void main(String[]args){
		ReadingLamp rl = new ReadingLamp();
		Lamp l1 = new RedLamp();
		rl.powerOn(l1);
		Lamp l2 = new BlueLamp();
		rl.powerOn(l2);
	}
}