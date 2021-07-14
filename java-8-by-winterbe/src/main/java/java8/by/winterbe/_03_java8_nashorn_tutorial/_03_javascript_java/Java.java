package java8.by.winterbe._03_java8_nashorn_tutorial._03_javascript_java;

import java.util.Arrays;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class Java {
  public static String fun1(String name) {
    System.out.println(String.format("Hi there from Java, %s", name));
    return "greetings from java";
  }

  public static void fun2(Object object) {
    System.out.println(object.getClass());
  }

  public static void fun3(ScriptObjectMirror mirror) {
    System.out.println(mirror.getClassName() + ": " + Arrays.toString(mirror.getOwnKeys(true)));
  }

  public static void fun4(ScriptObjectMirror person) {
    System.out.println("Full Name is: " + person.callMember("getFullName"));
  }
}
