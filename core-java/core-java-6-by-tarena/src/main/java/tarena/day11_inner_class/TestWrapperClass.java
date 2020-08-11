package tarena.day11_inner_class;

public class TestWrapperClass{
    @SuppressWarnings("unused")
    public static void main(String... args){
		int i = 10;
		//把基本数据类型转换成对象
		Integer ii = new Integer(i);
		//把对象转换成基本数据类型
		int i1 = ii.intValue();
		System.out.println(i1);
		byte b = 20;
		Byte bb = new Byte(b);
		byte b1 = bb.byteValue();
		System.out.println(Double.MAX_VALUE);
		System.out.println(Integer.bitCount(17));
		Integer ii1 = Integer.decode("0x123F");
		System.out.println(ii1);
		String str = "123";
		int i2 = Integer.parseInt(str);
		System.out.println(Integer.toHexString(100));
		//===JDK5.0==========
		int i3 = 100;
		Integer ii3 = i3;//自动装箱(自动封箱)
		int i4 = ii3;//自动解箱(自动解封)
		System.out.println("=========================");
		Integer i10 = new Integer(10);
		Integer i20 = new Integer(10);
		System.out.println(i10==i20);
		System.out.println(i10.equals(i20));

		Integer i11 = 11;
		Integer i12 = 11;
		System.out.println(i11==i12);
		Short s1 = 100;
		Short s2 = 100;
		System.out.println(s1==s2);
		Integer i21 = 130;
		Integer i22 = 130;
		System.out.println(i21==i22);
		//-128~127
		Integer i31 = 128;//127
		Integer i32 = 128;//127
		System.out.println(i31==i32);
		//Byte Short Long Character Float Double 
		Long l1 = 127L;
		Long l2 = 127L;
		System.out.println(l1==l2);
		Character ch1 = 127;
		Character ch2 = 127;
		System.out.println(ch1==ch2);
		Float f1 = 3.14f;
		Float f2 = 3.14f;
		System.out.println(f1==f2);
    }
}