package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JTextField textField;
    JButton bn1, bn2, bn3, bn4, bn5, bn6, bn7, bn8, bn9, bn10, bn11, bn12, bn13, bn14, bn15, bn16;
    JFrame frame;
    JPanel panel;
    Float num, num2;
    String num3 = "";
    protected String stete, point;
    public void innt(){
        String combo = "";
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textField = new JTextField("0");
        panel = new JPanel(new BorderLayout());
        panel.setLayout(new GridLayout(4,4));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setEditable(false);
        bn1 = new JButton("7");
        bn2 = new JButton("8");
        bn3 = new JButton("9");
        bn4 = new JButton("+");
        bn5 = new JButton("6");
        bn6 = new JButton("5");
        bn7 = new JButton("4");
        bn8 = new JButton("-");
        bn9 = new JButton("3");
        bn10 = new JButton("2");
        bn11 = new JButton("1");
        bn12 = new JButton("*");
        bn13 = new JButton("0");
        bn14 = new JButton(".");
        bn15 = new JButton("=");
        bn16 = new JButton("/");
        bn1.addActionListener(this);
        bn2.addActionListener(this);
        bn3.addActionListener(this);
        bn4.addActionListener(this);
        bn5.addActionListener(this);
        bn6.addActionListener(this);
        bn7.addActionListener(this);
        bn8.addActionListener(this);
        bn9.addActionListener(this);
        bn10.addActionListener(this);
        bn11.addActionListener(this);
        bn12.addActionListener(this);
        bn13.addActionListener(this);
        bn14.addActionListener(this);
        bn15.addActionListener(this);
        bn16.addActionListener(this);

        frame.add(textField, BorderLayout.NORTH);
        panel.add(bn1);
        panel.add(bn2);
        panel.add(bn3);
        panel.add(bn4);
        panel.add(bn5);
        panel.add(bn6);
        panel.add(bn7);
        panel.add(bn8);
        panel.add(bn9);
        panel.add(bn10);
        panel.add(bn11);
        panel.add(bn12);
        panel.add(bn13);
        panel.add(bn14);
        panel.add(bn15);
        panel.add(bn16);
        frame.add(panel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.innt();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        System.out.println(stete+"---"+String.valueOf(num));
        if (cmd == "+"){
            num = Float.parseFloat(textField.getText());
            stete = "+";
            System.out.println(stete);
        }
        else if (cmd == "-"){
            num = Float.parseFloat(textField.getText());
            stete = "-";
            System.out.println(stete);

        }
        else if (cmd == "*"){
            num = Float.parseFloat(textField.getText());

            stete = "*";
            System.out.println(stete);

        }
        else if (cmd == "/"){
            num = Float.parseFloat(textField.getText());
            stete = "/";
            System.out.println(stete);

        }
        else if (cmd == "="){
            if (stete.equals("+")) {
                num2 = Float.parseFloat(textField.getText());
                System.out.println(String.valueOf(num+num2));
                textField.setText(String.valueOf(num+num2));
            }
            else if (stete.equals("-")) {
                num2 = Float.parseFloat(textField.getText());
                System.out.println(String.valueOf(num-num2));
                textField.setText(String.valueOf(num-num2));
            }
            else if (stete.equals("*")) {
                num2 = Float.parseFloat(textField.getText());
                System.out.println(String.valueOf(num*num2));
                textField.setText(String.valueOf(num*num2));
            }
            else if (stete.equals("/")) {
                num2 = Float.parseFloat(textField.getText());
                System.out.println(String.valueOf(num/num2));
                textField.setText(String.valueOf(num/num2));
            }
            stete = "";

        }
        else if(cmd == ".") {
            num3 = textField.getText();
            textField.setText(num3+".");
        }



        else {
            if (num3.equals(""))
                textField.setText(cmd);
            else {
                textField.setText(num3 + "." + cmd);
                num3 = "";
            }
        }
    }
}
