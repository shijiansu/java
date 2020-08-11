package java7.newfeatures._2_strings_in_switch;

public class _1_SwitchString {
    public static void main(String[] args) {
        String s = "test";
        switch (s) {
        case "test":
            System.out.println("test");
        case "test1":
            System.out.println("test1");
            break;
        default:
            System.out.println("break");
            break;
        }
    }
}
