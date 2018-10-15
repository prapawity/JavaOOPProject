package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerrlerGUI implements ActionListener {
    JFrame frame;
    JPanel p1, p2, p3;
    JLabel label1, label2,err;
    JButton button1, button2, button3, button4;
    JTextField textField1, textField2;
    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();
        if (cmd == "Exit")
            System.exit(JFrame.EXIT_ON_CLOSE);
        else if (cmd == "Clear") {
            textField2.setText("");
        }
        else if (cmd == "WithDraw"){
            if (Double.parseDouble(textField2.getText())<=0 || textField2.getText().equals("")){
                err.setForeground(Color.red);
                err.setText("Invalid Amount");
            }
            else {
                double amt = Double.parseDouble(textField2.getText());
                CheckingAccount acct = new CheckingAccount(Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText()));
                acct.withDraw(amt);
                if (Double.parseDouble(textField1.getText()) < Double.parseDouble(textField2.getText())) {
                    err.setForeground(Color.red);
                    err.setText(("Money is not Enought"));
                } else {
                    err.setForeground(Color.black);
                    err.setText("");
                    //textField1.setText(acct.getBalance(Double.parseDouble(textField.getText())) + " ");
                }
            }
        }
        else if (cmd == "Deposite"){
            if (Double.parseDouble(textField2.getText())<=0 || textField2.getText().equals("")){
                err.setForeground(Color.red);
                err.setText("Invalid Amount");
            }
            else {
                double amt = Double.parseDouble(textField2.getText());
                CheckingAccount acct = new CheckingAccount(Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText()));
                acct.deposite(amt);
                err.setForeground(Color.black);
//                err.setText(acct.getBalance(Double.parseDouble(textField.getText())) + " ");
//                textField1.setText(acct.getBalance(Double.parseDouble(textField.getText())) + " ");
            }

        }
    }
    public void init(){
        frame = new JFrame("Bank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        label1 = new JLabel("Balance");
        label2 = new JLabel("Amount");
        err = new JLabel("Welcome");
        err.setHorizontalAlignment(JTextField.CENTER);
        button1 = new JButton("Deposite");
        button2 = new JButton("WithDraw");
        button4 = new JButton("Clear");
        button3 = new JButton("Exit");
        textField1 = new JTextField("6000");
        textField1.setEditable(false);
        textField2 = new JTextField();
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        frame.setFont(new Font("Dialog", Font.BOLD, 14));

        p1.setLayout(new GridLayout(2,2));
        p1.add(label1);
        p1.add(textField1);
        p1.add(label2);
        p1.add(textField2);
        p2.add(button1);
        p2.add(button2);
        p2.add(button4);
        p2.add(button3);
        p3.setLayout(new BorderLayout());
        p3.add(p1);
        p3.add(p2, BorderLayout.SOUTH);
        frame.add(p3);
        frame.add(err, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
        textField2.requestFocus();
    }

    public static void main(String[] args) {
        TerrlerGUI terrlerGUI = new TerrlerGUI();
        terrlerGUI.init();
    }
}
