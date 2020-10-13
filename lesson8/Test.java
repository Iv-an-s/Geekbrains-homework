package lesson8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Test {
    public static void main(String[] args){
        String one = "10 + 20 - 50/10";

            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");

        try {
            Object expResult1 = scriptEngine.eval(one);
            System.out.println(expResult1);
        }catch (javax.script.ScriptException e){
            e.printStackTrace();
        }
    }





}

