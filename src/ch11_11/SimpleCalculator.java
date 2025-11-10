package ch11_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SimpleCalculator extends JFrame {

    private DisplayPanel displayPanel;
    private ResultPanel resultPanel;

    public SimpleCalculator() {
        setTitle("간단한 계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        displayPanel = new DisplayPanel();
        add(displayPanel, BorderLayout.NORTH);

        resultPanel = new ResultPanel();
        add(resultPanel, BorderLayout.SOUTH);

        ButtonPanel buttonPanel = new ButtonPanel(new ButtonActionListener(displayPanel, resultPanel));
        add(buttonPanel, BorderLayout.CENTER);

        setSize(350, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}