package java8.by.winterbe._03_java8_nashorn_tutorial._01_basic;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class HelloWorldTest {
  public static void main(String[] args) throws ScriptException {
    helloWorld();
  }

  private static void helloWorld() throws ScriptException {
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    engine.eval("print('Hello World!');");
  }
}
