package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankGUI implements ActionListener {
    JFrame frame;
    JTextField textField, textField2;
    JTextArea textArea;
    JButton button;
    JPanel panel, panel2;
    JLabel label1, label2;
    JScrollPane scrollPane;
    public Account account = new Account();

    public void init(){
        frame = new JFrame("Bank");
        frame.setSize(600,600);
        textArea = new JTextArea();
        textArea.setEditable(false);
        panel = new JPanel();
        panel2 = new JPanel();
        panel.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(1,2));
        label1 = new JLabel("Anoubt");
        label2 = new JLabel("Do");
        label2.setHorizontalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        button = new JButton("Add");
        button.addActionListener(this);
        scrollPane = new JScrollPane();
        textField = new JTextField();
        textField2 = new JTextField();
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(scrollPane);
        panel2.add(label1);
        panel2.add(textField);
        panel2.add(label2);
        panel2.add(textField2);
        panel.add(panel2, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        BankGUI bankGUI = new BankGUI();
        bankGUI.init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        Double amt = Double.parseDouble(textField.getText());
        Double ack = Double.parseDouble(textField2.getText());
        if (cmd.equals("Add")){

            account.setBalance(amt);
            account.deposite(ack);
            System.out.println(account.showBalance());
            textArea.append(Double.toString(account.showBalance()));
            }
        }
    }

