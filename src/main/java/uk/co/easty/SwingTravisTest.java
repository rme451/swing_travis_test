package uk.co.easty;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTravisTest extends JFrame implements ActionListener{

    public SwingTravisTest() {
        initUI();
    }

    public final void initUI() {
        JButton button1 = new JButton("Button1");
        button1.setName("button1");

        JButton button2 = new JButton("Button2");
        button2.setName("button2");

        button1.setBounds(50, 60, 100, 30);
        button2.setBounds(180, 60, 100, 30);
        getContentPane().setLayout(null);
        getContentPane().add(button1);
        getContentPane().add(button2);

        button1.addActionListener(this);
        button2.addActionListener(this);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Button 1 clicked!");
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Button 2 clicked!");
            }
        });

        setTitle("My Demo App");

        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("OK!");
    }

    public static void main(String[] args) {
        SwingTravisTest ex = new SwingTravisTest();
        ex.setVisible(true);
    }
}