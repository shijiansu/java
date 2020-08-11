package java6.newfeatures._1_new_utils._6_script_engine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;

public class _3_Redirectory {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");

        PipedReader pr = new PipedReader();
        PipedWriter pw = new PipedWriter(pr);
        PrintWriter writer = new PrintWriter(pw);
        engine.getContext().setWriter(writer);

        String script = "print('Hello from JavaScript')";
        engine.eval(script);

        BufferedReader br = new BufferedReader(pr);
        System.out.println(br.readLine());
    }
}
