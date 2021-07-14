package java8.by.winterbe._03_java8_nashorn_tutorial._04_javascript_java2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaTest {
  public static void main(String[] args)
      throws ScriptException, FileNotFoundException, NoSuchMethodException {
    invoke();
  }

  private static FileReader getFile(String fileName) throws FileNotFoundException {
    String path =
        JavaTest.class
            .getResource("")
            .getPath()
            .replace("target/classes", "src/main/java")
            .concat(fileName);
    return new FileReader(path);
  }

  private static ScriptEngine getEngine(String fileName)
      throws FileNotFoundException, ScriptException {
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    engine.eval(getFile(fileName));
    return engine;
  }

  private static void invoke()
      throws FileNotFoundException, ScriptException, NoSuchMethodException {
    System.out.println("[invoke]");
    getEngine("java_test.js");
  }
}
