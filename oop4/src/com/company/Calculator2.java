package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator2 implements ActionListener {
    JFrame frame;
    JTextField tf1, tf2, tf3;
    JLabel lb1, lb2, lb3;
    JButton bn1, bn2, bn3, bn4, bn5, bn6;
    JPanel p1, p2;
    public void init(){
        frame = new JFrame("BANK");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tf1 = new JTextField(10);
        tf2 = new JTextField(10);
        tf3 = new JTextField(10);
        lb1 = new JLabel("Number 1");
        lb2 = new JLabel("Number 2");
        lb3 = new JLabel("Result");
        bn1 = new JButton("Add");
        bn2 = new JButton("Subtract");
        bn3 = new JButton("Multiply");
        bn4 = new JButton("Clear");
        bn5 = new JButton("Exit");
        bn6 = new JButton("Divide");
        bn1.addActionListener(this);
        bn2.addActionListener(this);
        bn3.addActionListener(this);
        bn4.addActionListener(this);
        bn5.addActionListener(this);
        bn6.addActionListener(this);
        p1 = new JPanel();
        p2 = new JPanel();
        lb1.setHorizontalAlignment(JLabel.CENTER);
        lb2.setHorizontalAlignment(JLabel.CENTER);
        lb3.setHorizontalAlignment(JLabel.CENTER);
        tf1.setHorizontalAlignment(JTextField.RIGHT);
        tf2.setHorizontalAlignment(JTextField.RIGHT);
        tf3.setHorizontalAlignment(JTextField.RIGHT);
        tf3.setEditable(false);
        frame.setLayout(new GridLayout(2,1));
        p2.add(lb1);
        p2.add(tf1);
        p2.add(lb2);
        p2.add(tf2);
        p2.add(lb3);
        p2.add(tf3);
        p1.add(bn1);
        p1.add(bn2);
        p1.add(bn3);
        p1.add(bn6);
        p1.add(bn4);
        p1.add(bn5);
        frame.add(p2, BorderLayout.NORTH);
        frame.add(p1, BorderLayout.SOUTH);
        frame.setFont(new Font("Dialog", Font.BOLD, 18));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator2 calculator2 = new Calculator2();
        calculator2.init();;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd == "Add"){
            tf3.setText(String.valueOf(Double.parseDouble(tf1.getText())+Double.parseDouble(tf2.getText())));
        }
        else if (cmd == "Exit")
            System.exit(JFrame.EXIT_ON_CLOSE);
        else if (cmd == "Subtract"){
            tf3.setText(String.valueOf(Double.parseDouble(tf1.getText())-Double.parseDouble(tf2.getText())));
        }
        else if (cmd == "Multiply"){
            tf3.setText(String.valueOf(Double.parseDouble(tf1.getText())*Double.parseDouble(tf2.getText())));
        }
        else if (cmd == "Divide"){
            tf3.setText(String.valueOf(Double.parseDouble(tf1.getText())/Double.parseDouble(tf2.getText())));
        }
        else if (cmd == "Clear"){
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
        }

    }
}
