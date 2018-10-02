package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChatProgram implements ActionListener, KeyListener {
    JFrame frame;
    JTextArea label;
    JTextField textField;
    JButton bn1,bn2,bn3;
    JPanel p1, p3;
    JScrollPane scrollPane;
    public void init(){
        frame = new JFrame("Chat Programs");
        frame.setSize(600,600);
        label = new JTextArea();
        label.setEnabled(false);
        textField = new JTextField();
        bn1 = new JButton("Submit");
        bn2 = new JButton("Clear");
        bn3 = new JButton("Exit");
        bn1.addActionListener(this);
        bn2.addActionListener(this);
        bn3.addActionListener(this);
        textField.addKeyListener(this);
        p1 = new JPanel(new BorderLayout());
        p3 = new JPanel();
        scrollPane = new JScrollPane(label);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textField.setBackground(Color.cyan);
        p3.setBackground(Color.red);
        p1.add(scrollPane);
        p1.add(textField,BorderLayout.SOUTH);
        p3.add(bn1);
        p3.add(bn2);
        p3.add(bn3);
        frame.add(p1);
        frame.add(p3, BorderLayout.SOUTH);
        frame.setVisible(true);
        textField.requestFocus();
    }

    public static void main(String[] args) {
        ChatProgram chatProgram = new ChatProgram();
        chatProgram.init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd == "Submit") {
            if (textField.getText().equals("") || textField.getText().equals("Please fill in textfield"))
                textField.setText("Please fill in textfield");
            else {
                label.append(textField.getText() + "\n");
                textField.setText("");
            }
        }
        else if (cmd == "Clear")
            textField.setText("");
        else if (cmd =="Exit")
            System.exit(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int ggg = e.getKeyCode();
        if (ggg == KeyEvent.VK_ENTER)
            if (textField.getText().equals("") || textField.getText().equals("Please fill in textfield"))
                textField.setText("Please fill in textfield");
            else {
                label.append(textField.getText() + "\n");
                textField.setText("");
            }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
