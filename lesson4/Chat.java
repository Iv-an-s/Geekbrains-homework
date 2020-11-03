package part2.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Chat {
        private JFrame chat;

    public Chat(){
        StringBuilder sb = new StringBuilder();

        chat = new JFrame();
        chat.setTitle("SuperChat");
        chat.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chat.setBounds(100,50, 800, 600);
        chat.setLayout(new BorderLayout());

        JPanel messageWindow = new JPanel();
        messageWindow.setLayout(new BorderLayout());
        chat.add(messageWindow, BorderLayout.SOUTH);

        JTextArea message = new JTextArea();
        message.setEditable(true);
        JScrollPane jsp = new JScrollPane(message);
        jsp.setPreferredSize(new Dimension(600, 100));
        messageWindow.add(jsp, BorderLayout.CENTER);

        JPanel chatWindow = new JPanel();
        chatWindow.setLayout(new BorderLayout());
        chat.add(chatWindow, BorderLayout.CENTER);

        JTextArea textOfChat = new JTextArea();
        textOfChat.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(textOfChat);
        chatWindow.add(jScrollPane);

        EnterButtonListener enterButtonListener = new EnterButtonListener(message, textOfChat);
        message.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    String val = sb.append(textOfChat.getText()).
                                    append(message.getText()).toString();
                    textOfChat.setText(val);
                    message.setText("");
                    sb.setLength(0);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        JButton button = new JButton("Enter");
        messageWindow.add(button, BorderLayout.EAST);
        button.addActionListener(enterButtonListener);

        chat.setVisible(true);
    }
}
