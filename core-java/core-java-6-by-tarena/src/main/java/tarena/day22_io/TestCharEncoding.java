package tarena.day22_io;

public class TestCharEncoding {
	public static void main(String[] args) throws Exception {
		String s = "达内外企IT培训";
		byte[] bs = s.getBytes("GBK");// 编码GBK
		/*
		 * for(byte b : bs){ System.out.println(b); }
		 */
		String s1 = new String(bs, "BIG5");
		System.out.println(s1);
		byte[] bs1 = s1.getBytes("BIG5");
		String s2 = new String(bs1, "GBK");
		System.out.println(s2);
	}
}
