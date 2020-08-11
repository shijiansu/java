package tarena.day10_string;

import java.util.Random;
public class TestString2{
	private static Random r = new Random();
	private static char getChar(){
		return (char)(97+r.nextInt(26));
	}
	public static String generateString(){
		int size = r.nextInt(20);
		char[] cs = new char[size];
		for(int i=0; i<cs.length; i++){
			cs[i] = getChar();
		}
		return new String(cs);
	}
	@SuppressWarnings("unused")
    public static void main(String[]args){
		long start = System.nanoTime();
		String str = null;
		for(int i=0; i<1000; i++){
			str += generateString();
		}
		long end = System.nanoTime();
		System.out.println(end-start);
		start = System.nanoTime();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<1000; i++){
			sb.append(generateString());
		}
		str = sb.toString();
		end =  System.nanoTime();
		System.out.println(end-start);

		start = System.nanoTime();
		StringBuilder sb1 = new StringBuilder();
		for(int i=0; i<1000; i++){
			sb1.append(generateString());
		}
		str = sb1.toString();
		end =  System.nanoTime();
		System.out.println(end-start);
    }
}