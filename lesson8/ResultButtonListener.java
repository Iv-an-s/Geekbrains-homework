package lesson8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultButtonListener implements ActionListener {
    private JTextField outField;

    public ResultButtonListener(JTextField outField){
        this.outField = outField;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
        Object result;

        try {
            result = scriptEngine.eval(outField.getText());
            System.out.println(result);
        }catch (javax.script.ScriptException ex){
            ex.printStackTrace();
            result = null;
        }
        outField.setText(String.valueOf(result));
    }
}
