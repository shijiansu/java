package java6.newfeatures._1_new_utils._6_script_engine;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;

public class _4_ScriptContext {
    public static void main(String[] args) throws Exception {
        String script=" print(greeting) ";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");

        //Attribute from ScriptEngineManager
        manager.put("greeting", "Hello from ScriptEngineManager");
        engine.eval(script);

        //Attribute from ScriptEngine
        engine.put("greeting", "Hello from ScriptEngine");
        engine.eval(script);

        //Attribute from eval method
        ScriptContext context = new SimpleScriptContext();
        context.setAttribute("greeting", "Hello from eval method",
                ScriptContext.ENGINE_SCOPE);
        engine.eval(script,context);

    }
}
