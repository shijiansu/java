package tarena.day10_string;

public class TestString{
    @SuppressWarnings("unused")
    public static void main(String[]args){
		String s1 = "abc";
		String s2 = new String();
		byte[] bs = new byte[5];
		bs[0] = 65;
		bs[1] = 66;
		bs[2] = 67;
		bs[3] = 68;
		bs[4] = 69;
		String s3 = new String(bs);
		System.out.println(s3);
		char[] cs = new char[4];
		cs[0] = '圣';
		cs[1] = '诞';
		cs[2] = '快';
		cs[3] = '乐';
		String s4 = new String(cs);
		System.out.println(s4);
		String s5 = new String("abc");
		System.out.println(s5);
		System.out.println("=========================");
		String str1 = new String("abc");
		str1 = "def";
		String str2 = new String("abc");
		System.out.println(str1==str2);
		String str3 = "abc";
		String str4 = "abc";
		System.out.println(str3==str4);
		str4 = "def";
		System.out.println(str3);
		System.out.println(str1==str3);
    }
}