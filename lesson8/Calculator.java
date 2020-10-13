package lesson8;

import javax.swing.*;
import java.awt.*;

public class Calculator{
    private JFrame mainFrame;
    public Calculator(){
        mainFrame = new JFrame();

        mainFrame.setBounds(100,100,300,500);
        mainFrame.setTitle("Calculator");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        mainFrame.add(top, BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4,3));
        mainFrame.add(center, BorderLayout.CENTER);

        JPanel rightSide = new JPanel();
        rightSide.setLayout(new GridLayout(4,1));
        mainFrame.add(rightSide, BorderLayout.EAST);

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(1, 2));
        mainFrame.add(bottom, BorderLayout.SOUTH);

//        mainFrame.setLayout(new GridLayout(4,3));

        JTextField outField = new JTextField();
        outField.setEditable(false);
        top.add(outField, BorderLayout.CENTER);

        ActionButtonListener abListener = new ActionButtonListener(outField);
        ResultButtonListener rbListener = new ResultButtonListener(outField);
        CancelButtonListener cbListener = new CancelButtonListener(outField);

        for (int i = 1; i <= 10; i++){
            JButton digitBtn;
            if (i!=10) {
                digitBtn = new JButton(String.valueOf(i));
            }else{
                digitBtn = new JButton(String.valueOf(0));
            }
            center.add(digitBtn);
            digitBtn.addActionListener(abListener);
        }

        JButton plusBtn = new JButton("+");
        rightSide.add(plusBtn);
        plusBtn.addActionListener(abListener);

        JButton minusBtn = new JButton("-");
        rightSide.add(minusBtn);
        minusBtn.addActionListener(abListener);

        JButton multBtn = new JButton("*");
        rightSide.add(multBtn);
        multBtn.addActionListener(abListener);

        JButton divBtn = new JButton("/");
        rightSide.add(divBtn);
        divBtn.addActionListener(abListener);

        JButton cancelBtn = new JButton("C");
        bottom.add(cancelBtn);
        cancelBtn.addActionListener(cbListener);

        JButton submitBtn = new JButton("Submit");
        bottom.add(submitBtn);
        submitBtn.addActionListener(rbListener);

        mainFrame.setVisible(true);
    }
}
