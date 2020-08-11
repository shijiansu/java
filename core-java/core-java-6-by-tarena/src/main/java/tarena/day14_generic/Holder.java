package tarena.day14_generic;

public class Holder {
	private Automobile auto;
	public void set(Automobile auto){
		this.auto = auto;
	}
	public Automobile get(){
		return auto;
	}
	public static void main(String[] args) {
		Holder h = new Holder();
		h.set(new Automobile());
		//h.set("String");
	}
}

class Automobile{}

class Holder1{
	private Object o;
	public void set(Object o){
		this.o = o;
	}
	public Object get(){
		return o;
	}
	
	@SuppressWarnings("unused")
    public static void main(String[] args) {
		Holder1 h = new Holder1();
		Automobile a = new Automobile();
		h.set(a);
		Automobile b = (Automobile) h.get();
		h.set("abc");
		String s = (String) h.get();
		//每一次拿出一个对象都要进行强制类型转换
		//这就导致代码类型不安，有可能抛出ClassCastException
	}
}
