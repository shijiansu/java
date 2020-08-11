package tarena.day11_inner_class;

public class VarParameter{
	/*
	public static void show(String[] ss){
		for(int i=0; i<ss.length; i++){
			System.out.println(ss[i]+" ");
		}
	}
	*/
	public static void show(String... ss){
		System.out.println("show(String...)");
		System.out.println(ss.length);
		for(int i=0; i<ss.length; i++){
			System.out.println(ss[i]+" ");
		}
	}
	public static void show(String s){
		System.out.println("show(String)");
	}
	public static void show(String s1, String s2){
		System.out.println("show(String, String)");
	}
    public static void main(String[]args){
		String[] ss = new String[3];
		ss[0] = "aaa";
		ss[1] = "bbb";
		ss[2] = "ccc";
		//show(ss);
		System.out.println("===============");
		//show("aaa","bbb","ccc","ddd");
		show();
		show("aaa");
		show("aaa","bbb");
		show("aaa","bbb","ccc");
    }
}