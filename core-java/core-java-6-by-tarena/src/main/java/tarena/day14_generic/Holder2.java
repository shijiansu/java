package tarena.day14_generic;

/**
 * 带泛型的类(泛型类)
 */
public class Holder2<E>{//参数化类型
	private E o;
	public void set(E o){
		this.o = o;
	}
	public E get(){
		return o;
	}
	@SuppressWarnings("unused")
    public static void main(String[] args) {
		Holder2<String> h = new Holder2<String>();
		//h.set(new Automobile());
		//Automobile a = (Automobile) h.get();
		h.set("abc");
		String s = h.get();
		Holder2<Automobile> h1 = new Holder2<Automobile>();
		//h1.set("abc");
		h1.set(new Automobile());
		Automobile a = h1.get();
		
	}
}
