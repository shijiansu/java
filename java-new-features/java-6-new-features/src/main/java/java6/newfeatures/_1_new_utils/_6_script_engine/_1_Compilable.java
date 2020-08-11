package java6.newfeatures._1_new_utils._6_script_engine;

import javax.script.*;

public class _1_Compilable {
    public static void main(String[] args) throws ScriptException {
        String script = " println (greeting); greeting= 'Good Afternoon!' ";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        engine.put("greeting", "Good Morning!");

        if (engine instanceof Compilable) {
            Compilable compilable = (Compilable) engine;
            CompiledScript compiledScript = compilable.compile(script);
            compiledScript.eval();
            compiledScript.eval();
        }
    }
}
