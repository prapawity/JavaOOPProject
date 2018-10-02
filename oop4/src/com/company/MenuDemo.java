package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDemo implements ActionListener {
    JFrame frame;
    JMenu menu1, menu2, menu3;
    JMenuItem menuItem, menuItem2, menuItem3, menuItem4;
    JMenuBar menuBar;
    JFileChooser fileChooser;
    public void init(){
        frame = new JFrame("Menu Demo");
        fileChooser = new JFileChooser();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu1 = new JMenu("File");
        menu2 = new JMenu("help");
        menuBar = new JMenuBar();
        menuItem = new JMenuItem("New");
        menuItem2 = new JMenuItem("Open");
        menuItem3 = new JMenuItem("Exit");
        frame.setJMenuBar(menuBar);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menu1.add(menuItem);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400,200);
    }

    public static void main(String[] args) {
        MenuDemo menuDemo = new MenuDemo();
        menuDemo.init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd == "Exit")
            System.exit(JFrame.EXIT_ON_CLOSE);
        else if (cmd == "Open"){
            fileChooser.showDialog(null, "Open");
        }
    }
}
