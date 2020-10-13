package lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelButtonListener implements ActionListener {
    JTextField outField;

    public CancelButtonListener(JTextField outField) {
        this.outField = outField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        outField.setText("");
    }
}
