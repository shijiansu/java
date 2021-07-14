package java8.by.winterbe._01_modern_java_a_guide_to_java8._02_lambda_expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        origin();
        beforeLambda();
        lambda1();
        lambda2();
    }

    private static List<String> getList() {
        return Arrays.asList("peter", "anna", "mike", "xenia");
    }

    public static void origin() {
        System.out.println("[origin]");
        List<String> names = getList();
        System.out.println(names);
    }

    public static void beforeLambda() {
        System.out.println("[beforeLambda]");
        List<String> names = getList();
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println(names);
    }

    public static void lambda1() {
        System.out.println("[lambda1]");
        List<String> names = getList();
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        System.out.println(names);
    }

    public static void lambda2() {
        System.out.println("[lambda2]");
        List<String> names = getList();
        // Collections.sort(names, (String a, String b) -> b.compareTo(a));
        Collections.sort(names, (a, b) -> b.compareTo(a));
        System.out.println(names);
    }
}
