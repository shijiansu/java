package tarena.day10_string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	public void test1(){
		Pattern p = Pattern.compile("ab");
		Matcher m = p.matcher("abaaaba");
		if(m.find()){
			System.out.println(m.start());
		}
		if(m.find()){
			System.out.println(m.start());
		}
		System.out.println(m.find());
	}
	
	public void test2(){
		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher("a12c3e456f");
		while(m.find()){
			System.out.println(m.start());
		}
	}
	
	public void test3(){
		String str = "0x1a";
		Pattern p = Pattern.compile("0[xX][0-9a-fA-F]+");
		Matcher m = p.matcher(str);
		System.out.println(m.matches());
	}
	
	public void test4(){
		String str = "a12c3e456f";
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(str);
		while(m.find()){
			System.out.print(m.start()+ " : ");
			System.out.println(m.group());
		}
	}
	
	public void test5(){
		String str = "proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java";
		Pattern p = Pattern.compile("proj1[^,]*");
		Matcher m = p.matcher(str);
		while(m.find()){
			System.out.println(m.group());
		}
		
	}
	
	public void test6(){
		Pattern p = Pattern.compile("\\d\\d\\d([-\\s])?\\d\\d\\d\\d");
		Matcher m = p.matcher("123-4567");
		System.out.println(m.matches());
	}
	
	public void test7(){
		Pattern p = Pattern.compile("a.c");//"a\\.c"
		Matcher m = p.matcher("ac abc a ca.c");
		while(m.find()){
			System.out.println(m.group());
		}
	}
	
	public void test8(){
		Pattern p = Pattern.compile(".*?xx");
		Matcher m = p.matcher("yyxxxyxx");
		while(m.find()){
			System.out.println(m.group());
		}
	}
	
	public void test9(){
		String str = "0x1234F";
		System.out.println(str.matches("0[xX][0-9a-fA-F]+"));
		str = "a12cd345f678kk";
		System.out.println(str.replaceAll("\\d+", "haha"));
		str = "111abc1222abc2333abc3444abc4555";
		String[] ss = str.split("abc\\d");
		for(int i=0; i<ss.length; i++){
			System.out.print(ss[i]+ " ");
		}
	}
	
}



