package java6.newfeatures._1_new_utils._6_script_engine;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class _2_Invocable {
    public static void main(String[] args) throws ScriptException,
            NoSuchMethodException {
        String script = " function greeting(message){print (message);}";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        engine.eval(script);

        if (engine instanceof Invocable) {
            Invocable invocable = (Invocable) engine;
            invocable.invokeFunction("greeting", "hi");

            // It may through NoSuchMethodException
            try {
                invocable.invokeFunction("nogreeing");
            } catch (NoSuchMethodException e) {
                // expected
            }
        }
    }
}
