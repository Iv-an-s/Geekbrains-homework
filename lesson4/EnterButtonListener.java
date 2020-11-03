package part2.lesson4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterButtonListener implements ActionListener {
    private JTextArea messageWindow;
    private JTextArea chatWindow;
    private StringBuilder sb = new StringBuilder();

    public EnterButtonListener(JTextArea messageWindow, JTextArea chatWindow) {
        this.messageWindow = messageWindow;
        this.chatWindow = chatWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!messageWindow.getText().isEmpty()) {
            String val = sb.append(chatWindow.getText()).
                    append(messageWindow.getText()).
                    append("\n").toString();
            chatWindow.setText(val);
            messageWindow.setText("");
            sb.setLength(0);
        }
    }
}
