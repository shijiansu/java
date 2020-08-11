package tarena.day18_swing;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashSet;

public class TestGirl {
	public static void main(String[] args) {
		Girl g = new Girl("陈才秀");//事件源
		Boy1 b1 = new Boy1("赵君");//事件监听者
		Boy2 b2 = new Boy2("董旭源");
		g.addEmotionListener(b1);//事件监听者注册到事件源上
		g.addEmotionListener(b2);
		g.fire();
		g.removeEmotionListener(b1);
		g.fire();
		g.removeEmotionListener(b2);
		g.fire();
	}
}

//事件对象
class EmotionEvent extends EventObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7272640213393835751L;

	public EmotionEvent(Object source) {
		super(source);
	}
}

//监听接口
//定义事件监听者的一个标准
interface EmotionListener extends EventListener{
	void doWhenGirlSad(EmotionEvent event);
	void doWhenGirlHappy(EmotionEvent event);
}

//事件源
class Girl{
	private String name;
	//private EmotionListener lover;
	private HashSet<EmotionListener> lovers = new HashSet<EmotionListener>();
	public Girl(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	//注册事件监听者的方法
	public void addEmotionListener(EmotionListener lover){
		/*this.lover = lover;
		System.out.println(name+"说：我终于可以嫁出去了！");*/
		lovers.add(lover);
		System.out.println(name+"说：我又有男朋友了，嘻嘻！");
	}
	
	public void removeEmotionListener(EmotionListener lover){
		/*if(this.lover==lover){
			this.lover=null;
			System.out.println(name+"说：没有你，我可怎么活！");
		}*/
		lovers.remove(lover);
		System.out.println(name+"说：咱俩分手吧，没缘分!");
	}
	public void fire(){
		EmotionEvent event = new EmotionEvent(this);
		for(int i=1; i<=10;i++){
			System.out.print("第"+i+"天：");
			/*if(i%2==0){
				//所谓向监听者发送一个事件对象，其实就是
				//调用监听者的某一个方法，把事件对象传进去
				System.out.println(name+"说：我今天心情很爽!");
				if(lover!=null)lover.doWhenGirlHappy(event);
			}else{
				System.out.println(name+"说：我今天心情很不爽!");
				if(lover!=null)lover.doWhenGirlSad(event);
			}*/
			if(i%2==0){
				for(EmotionListener l : lovers){
					System.out.println(name+"说：我今天心情很爽!");
					l.doWhenGirlHappy(event);
				}
			}else{
				for(EmotionListener l : lovers){
					System.out.println(name+"说：我今天心情很不爽!");
					l.doWhenGirlSad(event);
				}
			}
		}
	}
}

//事件监听者
class Boy1 implements EmotionListener{
	private String name;
	public Boy1(String name){
		this.name = name;
	}
	public void doWhenGirlHappy(EmotionEvent event) {
		Girl g = (Girl) event.getSource();
		System.out.println(name+"对"+g.getName()+"说：你爽我也爽，大家爽才是真的爽!");
	}

	public void doWhenGirlSad(EmotionEvent event) {
		Girl g = (Girl) event.getSource();
		System.out.println(name+"对"+g.getName()+"说：你不爽我也不爽，我比你还不爽!");
	}
}

class Boy2 implements EmotionListener{
	private String name;
	public Boy2(String name){
		this.name = name;
	}
	public void doWhenGirlHappy(EmotionEvent event) {
		Girl g = (Girl) event.getSource();
		System.out.println(name+"对"+g.getName()+"说：你爽我就不爽了!");
	}

	public void doWhenGirlSad(EmotionEvent event) {
		Girl g = (Girl) event.getSource();
		System.out.println(name+"对"+g.getName()+"说：你不爽我就爽了，(^_^)!");
	}
}









