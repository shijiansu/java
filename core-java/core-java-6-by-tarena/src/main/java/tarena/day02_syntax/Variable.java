package tarena.day02_syntax;

public class Variable {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int i = 10;
        long l = 10L;
        float f = 3.14f;
        double d = 3.14;
        char c = 'A';
        boolean bool = true;

        f = (float) 3.14;// 强制类型转换(显式类型转换)
        byte b = 10;
        short s = 10;
        // b = i;//Error, b = (byte)i;
        i = b;// 类型提升，隐式类型转换
        i = 260;
        b = (byte) i;
        System.out.println(b);
        /*
         * i:00000000 00000000 00000001 00000100 b:00000100---->4
         */
    }
}