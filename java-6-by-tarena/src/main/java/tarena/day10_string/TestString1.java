package tarena.day10_string;

public class TestString1{
    @SuppressWarnings("unused")
    public static void main(String[]args){
		String s1 = new String("abc");
		String s2 = new String("def");
		String s3 = "abc";
		String s4 = "def";
		String s5 = "abc"+"def"+"hij";
		String s55 = "abcdefhij";
		System.out.println(s5==s55);
		String s6 = new String("abcdef");
		System.out.println("===========================");
		String str1 = "abcdef";
		int c = str1.codePointAt(0);
		System.out.println(c);
		String str2 = "abd";
		System.out.println(str2.compareTo(str1));
		str1 = "abc";
		str2 = "def";
		String str3 = str1.concat(str2);
		System.out.println(str1);
		str1 = "abcdef";
		System.out.println(str1.contains("def"));
		char[] cs = {'a','b','c'};
		String str4 = String.copyValueOf(cs);//new String(cs);
		System.out.println(str4);
		String fileName = "hello.java";
		System.out.println(fileName.endsWith(".java"));
		String str5 = new String("abc");
		String str6 = new String("ABC");
		System.out.println(str5==str6);
		System.out.println(str5.equals(str6));
		System.out.println(str5.equalsIgnoreCase(str6));
		String str7 = "  abcdef  ";
		byte[] bs = str7.getBytes();
		for(int i=0; i<bs.length; i++){
			System.out.println(bs[i]);
		}
		System.out.println(str7.indexOf('d'));
		System.out.println(str7.indexOf("cde"));
		System.out.println(str7.length());
		String str8 = "aabbccddddffcdcd";
		String str9 = str8.replace('d', 'e');
		System.out.println(str8);
		System.out.println(str9);
		String str10 = str8.replace("cd", "dc");
		System.out.println(str10);
		String str11 = "guodh:x:100:1:desc:homedir:loginshell";
		String[] ss = str11.split(":");
		for(int i=0; i<ss.length; i++){
			System.out.println(ss[i]);
		}
		String str12 = "abcdefhijklmn";
		System.out.println(str12.startsWith("abc"));
		String str13 = str12.substring(5,7);
		System.out.println(str13);
		String str14 = "AbCdEf";
		System.out.println(str14.toLowerCase());
		String str15 = "    abc    ";
		System.out.println("["+str15+"]");
		System.out.println("["+str15.trim()+"]");
		int i = 100;
		String str16 = String.valueOf(i);
		str16 = i+"";
		System.out.println(str16);

    }
}