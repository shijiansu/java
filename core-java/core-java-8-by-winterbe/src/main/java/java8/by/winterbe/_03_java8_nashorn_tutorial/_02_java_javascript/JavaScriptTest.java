package java8.by.winterbe._03_java8_nashorn_tutorial._02_java_javascript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

class Person {}

public class JavaScriptTest {
  public static void main(String[] args)
      throws ScriptException, FileNotFoundException, NoSuchMethodException {
    invoke();
    objectType();
  }

  private static FileReader getFile(String fileName) throws FileNotFoundException {
    String path =
        JavaScriptTest.class
            .getResource("")
            .getPath()
            .replace("target/classes", "src/main/java")
            .concat(fileName);
    return new FileReader(path);
  }

  private static ScriptEngine getEngine(String fileName)
      throws FileNotFoundException, ScriptException {
    // Nashorn JavaScript基于ECMAScript 5.1，但是它的后续版本会对ES6提供支持
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    engine.eval(getFile(fileName));
    return engine;
  }

  private static void invoke()
      throws FileNotFoundException, ScriptException, NoSuchMethodException {
    System.out.println("[invoke]");
    ScriptEngine engine = getEngine("javascript.js");
    Invocable invocable = (Invocable) engine;
    Object result = invocable.invokeFunction("fun1", "Peter Parker");
    System.out.println(result);
    System.out.println(result.getClass());
    // Hi there from Javascript, Peter Parker
    // greetings from javascript
    // class java.lang.String
  }

  private static void objectType()
      throws FileNotFoundException, ScriptException, NoSuchMethodException {
    System.out.println("[objectType]");
    ScriptEngine engine = getEngine("javascript.js");
    Invocable invocable = (Invocable) engine;
    // Java对象在传入时不会在JavaScript端损失任何类型信息。
    // 由于脚本在JVM上原生运行，我们可以在Nashron上使用Java API或外部库的全部功能。
    invocable.invokeFunction("fun2", new Date()); // [object java.util.Date]
    invocable.invokeFunction("fun2", LocalDateTime.now()); // [object java.time.LocalDateTime]
    invocable.invokeFunction("fun2", new Person()); // [object Person]
  }
}
