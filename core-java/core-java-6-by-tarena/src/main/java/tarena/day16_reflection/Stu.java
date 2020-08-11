package tarena.day16_reflection;

import java.util.HashSet;

//@Override
public class Stu {
	//@Override
	private int id;
	private String name;
	public Stu(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Deprecated
	public void old(){}
	
	@SuppressWarnings({"unused"})
	public void newm(){
		HashSet<?> hs = new HashSet<Object>();	
	}
	
	@Override//这是一个annotation注释
	public String toString(){
		return id+":"+name;
	}
}
